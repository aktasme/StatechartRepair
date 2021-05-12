package apps;

import java.io.File;
import com.ibm.rhapsody.apps.*;
import com.telelogic.rhapsody.core.*;

public class MainApp extends App 
{
	final String ExportPath = "D:\\GitHub\\StatechartRepair\\doc\\exports\\";
	final String ExportExt = ".emf";
	
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
		
		if(selected.getIsOfMetaClass("Project") == 1)
		{
			IRPProject irpProject = (IRPProject)selected;
			
			IRPCollection irpPackages = irpProject.getPackages();
			for(int packageIndex = 1; packageIndex <= irpPackages.getCount(); packageIndex++)
			{
				IRPPackage irpPackage = (IRPPackage)irpPackages.getItem(packageIndex);
				System.out.printf("Package:%s\n", irpPackage.getName());
				
				IRPCollection irpClasses = irpPackage.getClasses();
				for(int classIndex = 1; classIndex <= irpClasses.getCount(); classIndex++)
				{
					IRPClass irpClass = (IRPClass)irpClasses.getItem(classIndex);					
					IRPStatechart irpStatechart = irpClass.getStatechart();
					
					String folderPath = ExportPath + irpPackage.getName(); 
					String exportPath = folderPath + "\\" + irpClass.getName() + ExportExt;
					
					File folder = new File(folderPath);
					if(!folder.exists())
					{
						folder.mkdirs();
					}
					
					irpStatechart.getPicture(exportPath);
					System.out.printf("  Class:%s file:%s\n", irpClass.getName(), exportPath);
				}
			}			
		}
		else if(selected.getIsOfMetaClass("Statechart") == 1)
		{
			IRPStatechart irpStatechart = (IRPStatechart)selected;
			
			/* Create and initialize Statechart class object */
			Statechart statechart = new Statechart(irpStatechart);
			statechart.initialize();
			
			String statechartName = irpStatechart.getName();
			irpStatechart.getPicture(ExportPath + statechartName + ExportExt);
					
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
}
