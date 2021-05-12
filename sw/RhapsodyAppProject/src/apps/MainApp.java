package apps;

import java.util.Vector;
import java.util.Iterator;
import com.ibm.rhapsody.apps.*;
import com.telelogic.rhapsody.core.*;

public class MainApp extends App 
{
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
		
		if(selected.getIsOfMetaClass("Project") == 1)
		{
			/* Control the strategies for all statecharts in selected Project */
			
			IRPProject irpProject = (IRPProject)selected;
			
			IRPCollection irpPackages = irpProject.getPackages();
			for(int packageIndex = 1; packageIndex <= irpPackages.getCount(); packageIndex++)
			{
				IRPPackage irpPackage = (IRPPackage)irpPackages.getItem(packageIndex);				
				IRPCollection irpClasses = irpPackage.getClasses();
				for(int classIndex = 1; classIndex <= irpClasses.getCount(); classIndex++)
				{
					IRPClass irpClass = (IRPClass)irpClasses.getItem(classIndex);					
					IRPStatechart irpStatechart = irpClass.getStatechart();
					
					Statechart statechart = new Statechart(irpStatechart);
					statechart.initialize();
					controlStatechart(statechart);	
				}
			}			
		}
		else if(selected.getIsOfMetaClass("Statechart") == 1)
		{
			/* Control the strategies for only selected statechart */
			
			IRPStatechart irpStatechart = (IRPStatechart)selected;
			
			/* Create and initialize Statechart class object */
			Statechart statechart = new Statechart(irpStatechart);
			statechart.initialize();
			controlStatechart(statechart);								
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
		
		antiPattern = new _5_ISAntiPattern();
		antiPatterns.add(antiPattern);
		
		antiPattern = new _6_URSAntiPattern();
		antiPatterns.add(antiPattern);
		
		antiPattern = new _7_NCAntiPattern();
		antiPatterns.add(antiPattern);		
		
		antiPattern = new _8_UNSAntiPattern();
		antiPatterns.add(antiPattern);
	}
	
	public void controlStatechart(Statechart statechart)
	{
		Iterator<AntiPatternBase> iter = antiPatterns.iterator();
		
		while(iter.hasNext())
		{
			AntiPatternBase strategy = iter.next();
			strategy.control(statechart);
		}
	}
}
