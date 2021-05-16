package apps;

public class AntiPatternBase 
{
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
}
