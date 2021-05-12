package apps;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author mehmetaktas
 * 
 * Transition with Condition without Event
 *
 */
public class _3_TWCWOEStrategy implements StrategyBase
{
	Vector<Transition> transitionsFound;

	@Override
	public boolean control(Statechart statechart) 
	{
		boolean bReturn = false;
		Vector<Transition> transitions = statechart.getTransitions();
		Iterator<Transition> iter = transitions.iterator();
		
		while(iter.hasNext())
		{
			Transition transition = iter.next();
			
			String condition = transition.getItsGuard().getBody();
			String event = transition.getItsTrigger().getBody();
			
			if(event.isEmpty() && !condition.isEmpty())
			{
				transitionsFound.add(transition);
				bReturn = true;				
			}
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
