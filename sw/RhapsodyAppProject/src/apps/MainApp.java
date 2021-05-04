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
				System.out.printf("Statechart is Complex!\n");
			}
			else
			{
				System.out.printf("Statechart is NOT Complex!\n");
			}
			
/*			IRPState root = statechart.getRootState();
						
			IRPCollection elements = statechart.getElementsInDiagram();
			IRPCollection triggers = statechart.getAllTriggers();
			IRPCollection graphicalElements = statechart.getGraphicalElements();
					
			System.out.printf("MainApp::execute(): Element count in diagram:%d\n", elements.getCount());
			System.out.printf("MainApp::execute(): Graphical Element count in diagram:%d\n", graphicalElements.getCount());
			System.out.printf("MainApp::execute(): Trigger count in diagram:%d\n", triggers.getCount());
			
			//graphicalElements.toList();
			
			for(int index = 1; index <= elements.getCount(); index++)
			{
				IRPModelElement element = (IRPModelElement)elements.getItem(index);
				System.out.printf("MainApp::execute(): All Elements [%d] %s:%s\n", index, element.getMetaClass(), element.getName());
			}
			
			IRPCollection rootElements = root.getSubStates();
			System.out.printf("MainApp::execute(): States under root count in diagram:%d\n", rootElements.getCount());
			
			for(int index = 1; index <= rootElements.getCount(); index++)
			{
				IRPModelElement element = (IRPModelElement)rootElements.getItem(index);
				System.out.printf("MainApp::execute(): Root Elements [%d] %s:%s\n", index, element.getMetaClass(), element.getName());
			}
*/			
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
