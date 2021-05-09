package apps;

import com.ibm.rhapsody.apps.*;
import com.telelogic.rhapsody.core.*;

public class MainApp extends App 
{
	
	/*
	* This method is called on invoking an app inside Rhapsody.
	* rhapsody - Instance of an active Rhapsody application 
	* selected - Selected element in Rhapsody
	*/
	public void execute(IRPApplication rhapsody, IRPModelElement selected)
	{
		System.out.printf("MainApp::execute(): Enter!\n");
		System.out.printf("MainApp::execute(): Selected:%s\n", selected.getName());
		System.out.printf("MainApp::execute(): SelectedMetaClass:%s\n", selected.getMetaClass());
		
		if(selected.getIsOfMetaClass("Statechart") == 1)
		{
			IRPStatechart irpStatechart = (IRPStatechart)selected;
			
			Statechart statechart = new Statechart(irpStatechart);
			statechart.initialize();
					
			_1_CSDStrategy strategyCSD = new _1_CSDStrategy();
			if(strategyCSD.control(statechart))
			{
				System.out.printf("Statechart is Complex! (%f)\n", statechart.getComplexity());
			}
			else
			{
				System.out.printf("Statechart is NOT Complex! (%f)\n", statechart.getComplexity());
			}	
			
			_2_TBSWDHStrategy strategyTBSWDH = new _2_TBSWDHStrategy();
			if(strategyTBSWDH.control(statechart))
			{
				System.out.printf("Transition Between States with Different Hierarchy found!\n");
			}
			else
			{
				System.out.printf("Transition Between States with Different Hierarchy NOT found!\n");
			}	
		
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
}
