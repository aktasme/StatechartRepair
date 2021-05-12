package apps;

import java.util.Vector;
import java.util.Iterator;
import com.ibm.rhapsody.apps.*;
import com.telelogic.rhapsody.core.*;

public class MainApp extends App 
{
	Vector<StrategyBase> strategies;
	
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
		strategies = new Vector<StrategyBase>();
		StrategyBase strategy = null;
		
		strategy = new _1_CSDStrategy();
		strategies.add(strategy);
		
		strategy = new _2_TBSWDHStrategy();
		strategies.add(strategy);	
	
		strategy = new _3_TWCWOEStrategy();
		strategies.add(strategy);	
	}
	
	public void controlStatechart(Statechart statechart)
	{
		Iterator<StrategyBase> iter = strategies.iterator();
		
		while(iter.hasNext())
		{
			StrategyBase strategy = iter.next();
			strategy.control(statechart);
		}
	}
}
