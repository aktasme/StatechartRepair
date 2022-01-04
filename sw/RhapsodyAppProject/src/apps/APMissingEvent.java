package apps;

import java.util.Iterator;
import java.util.Vector;
import com.telelogic.rhapsody.core.*;

import apps.Node.NodeTypeEnum;

/**
 * @author mehmetaktas
 * 
 * Missing Event
 *
 */
public class APMissingEvent extends AntiPatternBase
{
	Vector<Transition> transitionsFound;

	public APMissingEvent() 
	{
		name = this.getClass().getSimpleName();
		transitionsFound = new Vector<Transition>();
	}

	@Override
	public boolean control(IRPApplication irpApplication, Statechart statechart) 
	{
		boolean bReturn = false;
		
		transitionsFound.clear();
		
		Vector<Transition> transitions = statechart.getTransitions();
		Iterator<Transition> iter = transitions.iterator();
		
		while(iter.hasNext())
		{
			Transition transition = iter.next();
			
			IRPGuard irpGuard = transition.getItsGuard();
			IRPTrigger irpTrigger = transition.getItsTrigger();
			Node sourceNode = transition.getItsSource();
			if( (irpGuard != null && !irpGuard.getBody().isEmpty()) && irpTrigger == null && sourceNode.getType() != NodeTypeEnum.NodeType_condition )
			{
				transitionsFound.add(transition);
				bReturn = true;
				hitCountTransition++;
			}			
		}
		
		if(bReturn)
		{
			hitCountStatechart++;
			statechart.setMissingEvent(true);
		}
		
		return bReturn;
	}

	@Override
	public boolean repair(IRPApplication irpApplication, Statechart statechart) 
	{
		boolean bReturn = true;
		Iterator<Transition> iter = transitionsFound.iterator();
		
		while(iter.hasNext())
		{
			Transition transition = iter.next();			
			State sourceState = (State)transition.getItsSource();
			State targetState = (State)transition.getItsTarget();
			
			/* New event name constructed */
			String triggerString = "ev" + sourceState.getName() + "to" + targetState.getName();
			
			transition.setItsTrigger(triggerString);			
			IRPGuard irpGuard = transition.getItsGuard();
			
			/* Guard deleted */
			String guardString = irpGuard.getBody();
			irpGuard.setBody("");
			
			/* GEN code added to end of the entry action */
			String entryAction = sourceState.getEntryAction();
			String repairEntryAction = entryAction;
			repairEntryAction += "\n";
			repairEntryAction = repairEntryAction + "if(" + guardString + ")\n{\n\tGEN(" + triggerString + ");\n}";
						
			sourceState.setEntryAction(repairEntryAction);
		}
		
		transitionsFound.clear();
		return bReturn;
	}
	
	@Override
	public boolean highlight(IRPApplication irpApplication, Statechart statechart)
	{
		boolean bReturn = false;
		
		Iterator<Transition> iter = transitionsFound.iterator();
		while(iter.hasNext())
		{
			Transition transition = iter.next();
			IRPTransition irpTransition = transition.getIrpTransition();
			irpTransition.highLightElement();
			bReturn = true;
		}
		
		return bReturn;
	}

	@Override
	public String toPrintableString()
	{
		String statisticsString = "";
		
		Iterator<Transition> iter = transitionsFound.iterator();
		while(iter.hasNext())
		{
			Transition transition = iter.next();
			String nameLineString = "  Missing Event Transition: " + transition.toString() + "\n";
			
			statisticsString += nameLineString;
		}

		return statisticsString;
	}
}
