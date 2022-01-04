package apps;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.ibm.rhapsody.apps.App;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPModelElement;

public class MainApp extends App
{
	private StatechartRepair plugin = null;
	
	/*
	* This method is called on invoking an app inside Rhapsody.
	* rhapsody - Instance of an active Rhapsody application 
	* selected - Selected element in Rhapsody
	*/
	public void execute(IRPApplication rhapsody, IRPModelElement selected)
	{
		if(plugin == null)
		{
			plugin = new StatechartRepair();
			
			try
			{
				System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("StatechartRepairOutput.txt")), true));
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String stringStartup = "Statechart Repair (" + Version.VERSION  + ") is starting.\n";
		rhapsody.writeToOutputWindow("Log", stringStartup);
		plugin.RhpPluginInit(rhapsody);
		plugin.OnMenuItemSelect((rhapsody.getSelectedElement()).getName());
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
