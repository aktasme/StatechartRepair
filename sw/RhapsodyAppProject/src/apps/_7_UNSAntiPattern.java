package apps;

import java.util.Iterator;
import java.util.Vector;
import com.telelogic.rhapsody.core.IRPTrigger;

/**
 * @author mehmetaktas
 * 
 * Unnecessary State
 *
 */
public class _7_UNSAntiPattern implements AntiPatternBase
{
	Vector<State> statesFound;
	
	public _7_UNSAntiPattern()
	{
		statesFound = new Vector<State>();
	}

	@Override
	public boolean control(Statechart statechart) 
	{
		System.out.printf("  [Control] Unnecessary State: ");

		boolean bReturn = false;
		
		Vector<State> states = statechart.getStates();
		Iterator<State> iter = states.iterator();
		
		while(iter.hasNext())
		{
			State state = iter.next();
			
			Vector<Transition> inTransitions = state.getInTransitions();
			Vector<Transition> outTransitions = state.getOutTransitions();
			Vector<Transition> internalTransitions = state.getInternalTransitions();
			
			boolean hasNoAction = (state.getEntryAction().isEmpty() && state.getExitAction().isEmpty());
			boolean hasNoInternalTransition = (internalTransitions.size() == 0);
			boolean isInTransitionsEventEmpty = isTransitionsEventsEmpty(inTransitions);
			boolean isOutTransitionsEventEmpty = isTransitionsEventsEmpty(outTransitions);
					
			if(!state.isRoot() && hasNoAction && hasNoInternalTransition && isInTransitionsEventEmpty && isOutTransitionsEventEmpty)
			{
				statesFound.add(state);
				bReturn = true;
			}
		}
		
		if(bReturn)
		{
			System.out.printf("Found! (%d)\n", statesFound.size());		
		}
		else
		{
			System.out.printf("NOT Found!\n");
		}
		
		return bReturn;
	}

	@Override
	public boolean repair(Statechart statechart) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/* Helper Functions */
	public boolean isTransitionsEventsEmpty(Vector<Transition> transitions)
	{
		boolean bReturn = true;
		
		Iterator<Transition> iter = transitions.iterator();
		
		while(iter.hasNext())
		{
			Transition transition = iter.next();
			IRPTrigger irpTrigger = transition.getItsTrigger();
			if(irpTrigger != null)
			{
				bReturn = false;
			}	
		}
		
		return bReturn;
	}

}
