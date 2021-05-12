package apps;

public interface StrategyBase 
{
	public boolean control(Statechart statechart);	
	public boolean repair(Statechart statechart);
}
