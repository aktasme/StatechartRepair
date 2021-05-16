package apps;

import java.util.Iterator;
import java.util.Vector;
import com.telelogic.rhapsody.core.*;

/**
 * @author mehmetaktas
 * 
 * Transition with Condition without Event
 *
 */
public class _3_TWCWOEAntiPattern extends AntiPatternBase
{
	Vector<Transition> transitionsFound;

	public _3_TWCWOEAntiPattern() 
	{
		transitionsFound = new Vector<Transition>();
	}

	@Override
	public boolean control(Statechart statechart) 
	{
		boolean bReturn = false;
		Vector<Transition> transitions = statechart.getTransitions();
		Iterator<Transition> iter = transitions.iterator();
		
		while(iter.hasNext())
		{
			Transition transition = iter.next();
			
			IRPGuard irpGuard = transition.getItsGuard();
			IRPTrigger irpTrigger = transition.getItsTrigger();
			if(irpGuard != null && irpTrigger == null)
			{
				transitionsFound.add(transition);
				bReturn = true;				
			}			
		}
		
		statechart.setTWCWOE(bReturn);
		
		return bReturn;
	}

	@Override
	public boolean repair(Statechart statechart) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
