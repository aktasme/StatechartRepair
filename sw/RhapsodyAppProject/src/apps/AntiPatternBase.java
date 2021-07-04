package apps;

import com.telelogic.rhapsody.core.IRPApplication;

import log.CommonLog;

public class AntiPatternBase extends CommonLog
{
	String name;
	int hitCountStatechart = 0;
	int hitCountState = 0;
	int hitCountTransition = 0;
	
	public AntiPatternBase()
	{
	}
	
	public void run(IRPApplication irpApplication, Statechart statechart)
	{
		if(control(irpApplication, statechart))
		{
			repair(irpApplication, statechart);
		}
	}
	
	public boolean control(IRPApplication irpApplication, Statechart statechart)
	{
		return false;
	}
	
	public boolean repair(IRPApplication irpApplication, Statechart statechart)
	{
		return false;
	}

	@Override
	public String toPrintableString()
	{
		String printableString = String.format("%-30s %4d %4d %4d", name, hitCountStatechart, hitCountState, hitCountTransition);
		return printableString;
	}
	
	
}
