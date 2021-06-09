package apps;

import java.util.Vector;
import java.util.Iterator;
import com.ibm.rhapsody.apps.*;
import com.telelogic.rhapsody.core.*;

public class MainApp extends App
{
	final String TargetProjectName = "AutoRepaired";
	int statechartCount = 0;
	int nodeCount = 0;
	int stateCount = 0;
	int conditionCount = 0;
	int transitionCount = 0;

	Vector<AntiPatternBase> antiPatterns;
	
	/*
	* This method is called on invoking an app inside Rhapsody.
	* rhapsody - Instance of an active Rhapsody application 
	* selected - Selected element in Rhapsody
	*/
	public void execute(IRPApplication rhapsody, IRPModelElement selected)
	{
		/* Create all strategies */
		createStrategies();
		print();
		
		if(selected.getIsOfMetaClass("Project") == 1)
		{		
			/* Copy project to a new project for working on it without changing original one */
			//IRPProject targetProject = copyProject(rhapsody, selected);
			IRPProject targetProject = (IRPProject)selected;
			runAntiPattern(targetProject);
		}
		else if(selected.getIsOfMetaClass("Package") == 1)
		{
			IRPPackage irpPackage = (IRPPackage)selected;	
			runAntiPattern(irpPackage);
		}
		else if(selected.getIsOfMetaClass("Class") == 1)
		{
			IRPClass irpClass = (IRPClass)selected;	
			runAntiPattern(irpClass);
		}
		else if(selected.getIsOfMetaClass("Statechart") == 1)
		{
			/* Control the strategies for only selected statechart */
			IRPStatechart irpStatechart = (IRPStatechart)selected;
			runAntiPattern(irpStatechart);
		}
		else
		{
			System.out.printf("Selected model element: %s %s", selected.getMetaClass(), selected.getName());
		}
		
		printStatistics();
	}
	
	public void runAntiPattern(IRPProject irpProject)
	{
		if(irpProject != null)
		{
			//System.out.printf("Project: %s\n", irpProject.getName());
			IRPCollection irpPackages = irpProject.getPackages();
			for(int packageIndex = 1; packageIndex <= irpPackages.getCount(); packageIndex++)
			{
				IRPPackage irpPackage = (IRPPackage)irpPackages.getItem(packageIndex);				
				runAntiPattern(irpPackage);
			}
		}
	}	
	
	public void runAntiPattern(IRPPackage irpPackage)
	{
		if(irpPackage != null)
		{
			//System.out.printf("  Package: %s\n", irpPackage.getName());
			IRPCollection irpClasses = irpPackage.getClasses();
			for(int classIndex = 1; classIndex <= irpClasses.getCount(); classIndex++)
			{
				IRPClass irpClass = (IRPClass)irpClasses.getItem(classIndex);					
				//System.out.printf("    Class:%s ", irpClass.getName());				
				IRPStatechart irpStatechart = irpClass.getStatechart();
				runAntiPattern(irpStatechart);
			}
			
			IRPCollection irpPackages = irpPackage.getPackages();
			for(int packageIndex = 1; packageIndex <= irpPackages.getCount(); packageIndex++)
			{
				IRPPackage irpSubPackage = (IRPPackage)irpPackages.getItem(packageIndex);				
				runAntiPattern(irpSubPackage);
			}
		}
	}
	
	public void runAntiPattern(IRPClass irpClass)
	{
		if(irpClass != null)
		{
			IRPStatechart irpStatechart = irpClass.getStatechart();
			runAntiPattern(irpStatechart);		
		}
	}
 
	public void runAntiPattern(IRPStatechart irpStatechart)
	{
		if(irpStatechart != null)
		{
			/* Create and initialize Statechart class object */
			//System.out.printf("Statechart:%s\n", irpStatechart.getName());
			Statechart statechart = new Statechart(rhapsody, irpStatechart);
			statechart.initialize();
			//if(!statechart.isHasAndState())
			{
				runAntiPattern(statechart);
				statechart.print();
			}	
		}
		else
		{
			//System.out.printf("has no any statechart\n");
		}
	}
	
	public void runAntiPattern(Statechart statechart)
	{
		statechartCount++;
		nodeCount += statechart.getNodesCount();
		stateCount += statechart.getStateCount();
		conditionCount += statechart.getConditionsCount();
		transitionCount += statechart.getTransitionCount();
		
		Iterator<AntiPatternBase> iter = antiPatterns.iterator();
		
		while(iter.hasNext())
		{
			AntiPatternBase antiPattern = iter.next();
			antiPattern.run(statechart);
		}
	}	
	
    /*
     *  Debug app by launching it as "Java Application" is Eclipse.
	 *  Note: Select an element in Rhapsody in order to simulate launching app on a selected element in the browser.
     */	
	public static void main(String[] args) 
	{
		MainApp app = new MainApp();
		app.invokeFromMain();
	}	
	
	/* Helper functions */
	public void createStrategies()
	{
		antiPatterns = new Vector<AntiPatternBase>();
		AntiPatternBase antiPattern = null;
		
		antiPattern = new _1_CSDAntiPattern();
		antiPatterns.add(antiPattern);
		
		antiPattern = new _2_TBSWDHAntiPattern();
		antiPatterns.add(antiPattern);	
	
		antiPattern = new _3_TWCWOEAntiPattern();
		antiPatterns.add(antiPattern);
		
		antiPattern = new _4_ISNAntiPattern();
		antiPatterns.add(antiPattern);
		
		antiPattern = new _5_URSAntiPattern();
		antiPatterns.add(antiPattern);
		
		antiPattern = new _6_NCAntiPattern();
		antiPatterns.add(antiPattern);		
		
		antiPattern = new _7_UNSAntiPattern();
		antiPatterns.add(antiPattern);
	}
	
	public IRPProject copyProject(IRPApplication rhapsody, IRPModelElement selected)
	{
		IRPProject targetProject = null;
		
		IRPCollection projects = rhapsody.getProjects();
		if(projects.getCount() == 1)
		{
			/* Create target project */
			IRPProject sourceProject = (IRPProject)selected;
			
			String projectPath = sourceProject.getCurrentDirectory();
			String repairedProjectPath = projectPath + "_" + TargetProjectName;
			
			rhapsody.createAndInsertProject(repairedProjectPath, TargetProjectName);
			projects = rhapsody.getProjects();
			targetProject = (IRPProject)projects.getItem(2);
			
			IRPCollection sourceProjectPackages = sourceProject.getPackages();
			for(int packageIndex = 1; packageIndex <= sourceProjectPackages.getCount(); packageIndex++)
			{
				boolean copyPackage = false;
				IRPPackage irpPackage = (IRPPackage)sourceProjectPackages.getItem(packageIndex);
				IRPCollection irpClasses = irpPackage.getClasses();			
				for(int classIndex = 1; classIndex <= irpClasses.getCount(); classIndex++)
				{
					IRPClass irpClass = (IRPClass)irpClasses.getItem(classIndex);					
					IRPStatechart irpStatechart = irpClass.getStatechart();
					
					if(irpStatechart != null)
					{
						copyPackage = true;
						break;
					}
				}
			
				if(copyPackage)
				{
					//irpPackage.copyToAnotherProject(targetProject);
				}
			}
		}
		else
		{
			/* Find Target Project */
			for(int projectIndex = 1; projectIndex <= projects.getCount(); projectIndex++)
			{
				IRPProject project = (IRPProject)projects.getItem(projectIndex);
			
				if(project.getName().equals(TargetProjectName))
				{
					targetProject = project;
				}
			}
		}
		
		return targetProject;
	}
	
	/* Logging functions */
	public void print()
	{
		System.out.printf("%-60s:   #N   #S   #C   #T(  #E:  #I) | 1 2 3 4 5 6 7 | %-10s\n", "[Name]", "Complexity");
	}
	
	public void printStatistics()
	{
		System.out.printf("\n[Total number of processed elements]\n");
		System.out.printf("#SM:%d\n", statechartCount);
		System.out.printf("#N:%d\n", nodeCount);
		System.out.printf("#S:%d\n", stateCount);
		System.out.printf("#C:%d\n", conditionCount);
		System.out.printf("#T:%d\n", transitionCount);
		
		System.out.printf("\n%-30s %4s %4s %4s\n", "[AntiPattern Hits]", "#SM", "#S", "#T");
		
		Iterator<AntiPatternBase> iter = antiPatterns.iterator();
		
		while(iter.hasNext())
		{
			AntiPatternBase antiPattern = iter.next();
			antiPattern.print();
		}	
	}
}
