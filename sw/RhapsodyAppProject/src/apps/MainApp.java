package apps;

import java.util.Vector;
import java.util.Iterator;
import com.ibm.rhapsody.apps.*;
import com.telelogic.rhapsody.core.*;

public class MainApp extends App
{
	final String TargetProjectName = "AutoRepaired";
	
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
			IRPProject targetProject = copyProject(rhapsody, selected);
			
			/* Work on target project */
			IRPCollection targetProjectPackages = targetProject.getPackages();
			for(int packageIndex = 1; packageIndex <= targetProjectPackages.getCount(); packageIndex++)
			{
				IRPPackage irpPackage = (IRPPackage)targetProjectPackages.getItem(packageIndex);				
				IRPCollection irpClasses = irpPackage.getClasses();
				for(int classIndex = 1; classIndex <= irpClasses.getCount(); classIndex++)
				{
					IRPClass irpClass = (IRPClass)irpClasses.getItem(classIndex);					
					IRPStatechart irpStatechart = irpClass.getStatechart();
					
					Statechart statechart = new Statechart(rhapsody, irpStatechart);
					statechart.initialize();
					runAntiPattern(statechart);	
					statechart.print();
				}
			}			
		}
		else if(selected.getIsOfMetaClass("Statechart") == 1)
		{
			/* Control the strategies for only selected statechart */
			
			IRPStatechart irpStatechart = (IRPStatechart)selected;
			
			/* Create and initialize Statechart class object */
			Statechart statechart = new Statechart(rhapsody, irpStatechart);
			statechart.initialize();
			runAntiPattern(statechart);	
			statechart.print();
		}
		else
		{
			System.out.printf("Selected model element: %s %s", selected.getMetaClass(), selected.getName());
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
					irpPackage.copyToAnotherProject(targetProject);
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
	
	public void runAntiPattern(Statechart statechart)
	{
		Iterator<AntiPatternBase> iter = antiPatterns.iterator();
		
		while(iter.hasNext())
		{
			AntiPatternBase strategy = iter.next();
			strategy.run(statechart);
		}
	}
	
	/* Logging functions */
	public void print()
	{
		System.out.printf("%-10s: #N #S #C #T | 1 2 3 4 5 6 7 | %-10s\n", "Name", "Complexity");
	}
}
