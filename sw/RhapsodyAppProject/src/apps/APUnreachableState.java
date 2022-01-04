package apps;

import java.util.Iterator;
import java.util.Vector;

import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPState;

/**
 * @author mehmetaktas
 * 
 * Unreachable State
 *
 */
public class APUnreachableState extends AntiPatternBase
{
	Vector<State> statesFound;
	
	public APUnreachableState()
	{
		name = this.getClass().getSimpleName();
		statesFound = new Vector<State>();
	}

	@Override
	public boolean control(IRPApplication irpApplication, Statechart statechart) 
	{
		boolean bReturn = false;
		
		statesFound.clear();
		
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
			statechart.setUnreachable(true);
		}
		
		return bReturn;
	}

	@Override
	public boolean repair(IRPApplication irpApplication, Statechart statechart) 
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

	@Override
	public boolean highlight(IRPApplication irpApplication, Statechart statechart)
	{
		boolean bReturn = false;
		
		Iterator<State> iter = statesFound.iterator();
		while(iter.hasNext())
		{
			State state = iter.next();
			IRPState irpState = state.getIrpState();
			irpState.highLightElement();
			bReturn = true;
		}
		
		return bReturn;
	}
	
	@Override
	public String toPrintableString()
	{
		String statisticsString = "";
		
		Iterator<State> iter = statesFound.iterator();
		while(iter.hasNext())
		{
			State state = iter.next();
			String nameLineString = "  Unreachable State: " + state.getName() + "\n";
			statisticsString += nameLineString;
		}

		return statisticsString;
	}
}
