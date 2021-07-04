package apps;

import java.util.Iterator;
import java.util.Vector;

import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPTrigger;

import apps.Node.NodeTypeEnum;

/**
 * @author mehmetaktas
 * 
 * Unnecessary State
 *
 */
public class _7_UNSAntiPattern extends AntiPatternBase
{
	Vector<State> statesFound;
	
	public _7_UNSAntiPattern()
	{
		name = this.getClass().getSimpleName();
		statesFound = new Vector<State>();
	}

	@Override
	public boolean control(IRPApplication irpApplication, Statechart statechart) 
	{
		boolean bReturn = false;

		if(!statechart.isIncludeAndState())
		{
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
				boolean isIncludeNestedStatechart = state.isIncludeNestedStatechart();
				boolean isCompound = state.isCompound();
						
				if(!state.isRoot() && hasNoAction && hasNoInternalTransition && isInTransitionsEventEmpty && isOutTransitionsEventEmpty && !isIncludeNestedStatechart && !isCompound)
				{
					statesFound.add(state);
					bReturn = true;
					hitCountState++;
					//state.print();
				}
				//state.print();
			}
		}
		
		if(bReturn)
		{
			hitCountStatechart++;
			statechart.setUNS(true);
		}
		
		return bReturn;
	}

	@Override
	public boolean repair(IRPApplication irpApplication, Statechart statechart) 
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
			Node sourceNode = transition.getItsSource();
			IRPTrigger irpTrigger = transition.getItsTrigger();
			
			if((sourceNode != null && sourceNode.getType() == NodeTypeEnum.NodeType_condition) || irpTrigger != null)
			{
				bReturn = false;
			}	
		}
		
		return bReturn;
	}

}
