package apps;

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
	
	public void run(Statechart statechart)
	{
		if(control(statechart))
		{
			//repair(statechart);
		}
	}
	
	public boolean control(Statechart statechart)
	{
		return false;
	}
	
	public boolean repair(Statechart statechart)
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
