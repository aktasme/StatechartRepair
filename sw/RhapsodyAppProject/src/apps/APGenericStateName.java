package apps;

import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.telelogic.rhapsody.core.*;

/**
 * @author mehmetaktas
 * 
 * Generic State Name
 *
 */
public class APGenericStateName extends AntiPatternBase 
{
	Vector<State> statesFound;
	
	final String RegularExpression = "state_\\d{1,}";
	
	public APGenericStateName()
	{
		name = this.getClass().getSimpleName();
		statesFound = new Vector<State>();
	}

	@Override
	public void run(IRPApplication irpApplication, Statechart statechart) 
	{
		statesFound.clear();
		
		while(control(irpApplication, statechart))
		{
			repair(irpApplication, statechart);
		}
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
				String stateName = state.getName();
				
				Pattern pattern = Pattern.compile(RegularExpression);
				Matcher matcher = pattern.matcher(stateName);
				boolean matchFound = matcher.find();	
				if(matchFound)
				{
					statesFound.add(state);
					bReturn = true;
					//state.print();
					hitCountState++;
				}
			}
		}
		
		if(bReturn)
		{
			hitCountStatechart++;
			statechart.setISN(true);
		}
		
		return bReturn;
	}

	@Override
	public boolean repair(IRPApplication irpApplication, Statechart statechart) 
	{
		boolean bReturn = false;
		
		Iterator<State> iter = statesFound.iterator();
		while(iter.hasNext())
		{
			State state = iter.next();
			Vector<Transition> inTransitions = state.getInTransitions();

			if(state.isDefault())
			{
				IRPState irpState = state.getIrpState();
				IRPState irpParent = irpState.getParent();
				String oldName = irpState.getName();
				String newName = irpParent.getName() + "_Initial";
				state.setName(newName);
				System.out.printf("Change name from %s to %s\n", oldName, newName);
			}
			else if(inTransitions.size() > 0)
			{
				IRPState irpState = state.getIrpState();
				Transition transition = inTransitions.get(0);
				Node prevNode = transition.getItsSource();
				
				if(prevNode != null && !statesFound.contains(prevNode))
				{
					String oldName = irpState.getName();
					IRPTrigger irpTrigger = transition.getItsTrigger();
					String postName = "Default";
					
					if(irpTrigger != null)
					{
						postName = irpTrigger.getBody();
					}

					String newName = prevNode.getName() + "_" + postName;
					state.setName(newName);
					System.out.printf("Change name from %s to %s\n", oldName, newName);
				}
			}
			else
			{
				System.out.printf("No automatic repairing\n");
				/* No automatic repairing */
			}
		}
		
		statesFound.clear();
		return bReturn;
	}
}
