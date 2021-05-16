package apps;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author mehmetaktas
 * 
 * Unreachable State
 *
 */
public class _5_URSAntiPattern extends AntiPatternBase
{
	Vector<State> statesFound;
	
	public _5_URSAntiPattern()
	{
		statesFound = new Vector<State>();
	}

	@Override
	public void run(Statechart statechart) 
	{
		statesFound.clear();
		super.run(statechart);
	}

	@Override
	public boolean control(Statechart statechart) 
	{
		boolean bReturn = false;
		
		Vector<State> states = statechart.getStates();
		Iterator<State> iter = states.iterator();
		
		while(iter.hasNext())
		{
			State state = iter.next();	
			Vector<Transition> inTransitions = state.getInTransitions();
			if(!state.isRoot() && !state.isDefault && inTransitions.size() == 0)
			{
				statesFound.add(state);
				bReturn = true;
			}
		}
		
		statechart.setURS(bReturn);
		
		return bReturn;
	}

	@Override
	public boolean repair(Statechart statechart) 
	{
		System.out.printf(" Repaired!\n");
		boolean bReturn = false;
		
		Iterator<State> iter = statesFound.iterator();
		while(iter.hasNext())
		{
			State state = iter.next();
			state.deleteTransitions();
			statechart.deleteState(state);
		}

		return bReturn;
	}

}
