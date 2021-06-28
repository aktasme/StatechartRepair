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
		name = this.getClass().getSimpleName();
		statesFound = new Vector<State>();
	}

	@Override
	public void run(Statechart statechart) 
	{
		statesFound.clear();
		
		if(control(statechart))
		{
			//repair(statechart);
		}
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
				state.isUnreachable = true;
				statesFound.add(state);
			}
		}
		
		controlSubstates();
		
		iter = states.iterator();
		while(iter.hasNext())
		{
			State state = iter.next();
			if(!state.isUnreachable())
			{
				statesFound.remove(state);
			}
			else
			{
				//System.out.printf("Name: %s\n", state.getName());
			}
		}
		
		if(statesFound.size() > 0)
		{
			bReturn = true;
			hitCountStatechart++;
			hitCountState += statesFound.size();
			statechart.setURS(true);
		}
		
		return bReturn;
	}

	@Override
	public boolean repair(Statechart statechart) 
	{
		boolean bReturn = true;
		
		Iterator<State> iter = statesFound.iterator();
		while(iter.hasNext())
		{
			State state = iter.next();
			state.deleteTransitions();
			statechart.deleteState(state);
		}
		
		statesFound.clear();
		return bReturn;
	}
	
	public void controlSubstates()
	{
		Iterator<State> iter = statesFound.iterator();
		
		while(iter.hasNext())
		{
			State state = iter.next();
			if(isAnySubStateReachable(state))
			{
				state.setUnreachable(false);
			}
		}
	}
	
	public boolean isAnySubStateReachable(State state)
	{
		boolean bRet = false;
		
		if(!state.isUnreachable())
		{
			bRet = true;
		}
		else
		{
			Vector<State> subStates = state.getSubStates();
			Iterator<State> iter = subStates.iterator();
			while(iter.hasNext())
			{
				State substate = iter.next();
				if(isAnySubStateReachable(substate))
				{
					bRet = true;
					break;
				}
			}
		}

		return bRet;
	}
}
