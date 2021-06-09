package apps;

import java.util.Iterator;
import java.util.Vector;
import com.telelogic.rhapsody.core.*;

import apps.Node.NodeTypeEnum;

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
		name = this.getClass().getSimpleName();
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
			Node sourceNode = transition.getItsSource();
			if(irpGuard != null && irpTrigger == null && sourceNode.getType() != NodeTypeEnum.NodeType_condition)
			{
				transitionsFound.add(transition);
				bReturn = true;
				hitCountTransition++;
			}			
		}
		
		if(bReturn)
		{
			hitCountStatechart++;
			statechart.setTWCWOE(true);
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
