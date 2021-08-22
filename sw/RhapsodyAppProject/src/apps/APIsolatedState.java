package apps;

import java.util.Iterator;
import java.util.Vector;

import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPTrigger;

import apps.Node.NodeTypeEnum;

/**
 * @author mehmetaktas
 * 
 * Isolated State
 *
 */
public class APIsolatedState extends AntiPatternBase
{
	Vector<State> statesFound;
	
	public APIsolatedState()
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
		boolean bReturn = true;

		IRPCollection newTransitions = irpApplication.createNewCollection();
		
		Iterator<State> iter = statesFound.iterator();
		while(iter.hasNext())
		{
			State state = iter.next();
			
			Vector<Transition> inTransitions = state.getInTransitions();
			Vector<Transition> outTransitions = state.getOutTransitions();

			Iterator<Transition> iterTin = inTransitions.iterator();
			Iterator<Transition> iterTout = outTransitions.iterator();
			
			while(iterTin.hasNext())
			{
				Transition transitionIn = iterTin.next();
				
				while(iterTout.hasNext())
				{
					Transition transitionOut = iterTout.next();
					
					String guardString = "";
					if(transitionIn.getItsGuard() != null && transitionOut.getItsGuard() == null)
					{
						guardString = transitionIn.getItsGuard().getBody();
					}
					else if(transitionIn.getItsGuard() == null && transitionOut.getItsGuard() != null)
					{
						guardString = transitionOut.getItsGuard().getBody();
					}
					else if(transitionIn.getItsGuard() != null && transitionOut.getItsGuard() != null)
					{
						guardString = "(" + transitionIn.getItsGuard().getBody() + ") && (" + transitionOut.getItsGuard().getBody() + ")";
					}
					else
					{
						/* No action required. Empty string remains. */
					}

					String actionString = "";
					if(transitionIn.getItsAction() != null && transitionOut.getItsAction() == null)
					{
						actionString = transitionIn.getItsAction().getBody();
					}
					else if(transitionIn.getItsAction() == null && transitionOut.getItsAction() != null)
					{
						actionString = transitionOut.getItsAction().getBody();
					}
					else if(transitionIn.getItsAction() != null && transitionOut.getItsAction() != null)
					{
						actionString = transitionIn.getItsAction().getBody() + "\n\n" + transitionOut.getItsAction().getBody();
					}
					else
					{
						/* No action required. Empty string remains. */
					}
					
					State sourceState = (State)transitionIn.getItsSource();
					State targetState = (State)transitionOut.getItsTarget();
					
					Transition newTransition = sourceState.addTransition(targetState);
					newTransition.setItsGuard(guardString);
					newTransition.setItsAction(actionString);
					newTransitions.addItem(newTransition.getIrpTransition());
				}
				
				statechart.deleteState(state);
			}		
		}

		IRPCollection relationTypes = irpApplication.createNewCollection();
		relationTypes.setSize(1);
		relationTypes.setString(1, "AllRelations");
		
		statechart.getIrpStatechart().populateDiagram(newTransitions, relationTypes, "fromto");		
		
		statesFound.clear();
		return bReturn;
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
