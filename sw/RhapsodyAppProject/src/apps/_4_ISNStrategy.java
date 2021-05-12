package apps;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author mehmetaktas
 * 
 * Invalid State Name
 *
 */
public class _4_ISNStrategy implements StrategyBase 
{
	Vector<State> statesFound;

	@Override
	public boolean control(Statechart statechart) 
	{
		boolean bReturn = false;
		
		Vector<State> states = statechart.getStates();
		Iterator<State> iter = states.iterator();
		
		while(iter.hasNext())
		{
			State state = iter.next();		
			String stateName = state.getName();
		}
		
		return bReturn;
	}

	@Override
	public boolean repair(Statechart statechart) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
