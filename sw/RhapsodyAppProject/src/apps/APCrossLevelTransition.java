package apps;

import java.util.Iterator;
import java.util.Vector;

import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPTransition;

import apps.Node.NodeTypeEnum;

/**
 * @author mehmetaktas
 * 
 * Cross Level Transition
 *
 */
public class APCrossLevelTransition extends AntiPatternBase 
{
	Vector<Transition> transitionsFound;
	
	public APCrossLevelTransition() 
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
			
			if(transition.isDefaultTransition() == 0)
			{
				Node sourceNode = transition.getItsSource();
				Node targetNode = transition.getItsTarget();
				
				if(sourceNode != null && targetNode != null && 
				   sourceNode.getType() == NodeTypeEnum.NodeType_state && 
				   targetNode.getType() == NodeTypeEnum.NodeType_state)
				{
					State sourceState = (State)sourceNode;
					State targetState = (State)targetNode;
					
					if(sourceState.getDepth() != targetState.getDepth())
					{
						transitionsFound.add(transition);
						bReturn = true;
						hitCountTransition++;
					}
				}
			}
		}
		
		if(bReturn)
		{
			hitCountStatechart++;
			statechart.setCrossLevelTransition(true);
		}
		
		return bReturn;
	}

	@Override
	public boolean repair(IRPApplication irpApplication, Statechart statechart) 
	{
		boolean bReturn = true;
		
		IRPCollection newTransitions = irpApplication.createNewCollection();

		Iterator<Transition> iter = transitionsFound.iterator();
		while(iter.hasNext())
		{
			Transition transition = iter.next();
			
			State sourceState = (State)transition.getItsSource();
			State targetState = (State)transition.getItsTarget();
			
			if(sourceState.getDepth() > targetState.getDepth())
			{
				State parentOfSource = sourceState.getParentState();
				Transition newTransition = parentOfSource.addTransition(targetState);		
				newTransitions.addItem(newTransition.getIrpTransition());
				
				if(transition.getItsGuard() != null)
				{
					newTransition.setItsGuard(transition.getItsGuard().getBody());
				}
				
				if(transition.getItsAction() != null)
				{
					newTransition.setItsAction(transition.getItsAction().getBody());
				}
				
				if(transition.getItsTrigger() != null)
				{
					newTransition.setItsTrigger(transition.getItsTrigger().getBody());
				}
			}
			else if(sourceState.getDepth() < targetState.getDepth() && targetState.isDefault())
			{
				State parentOfDest = targetState.getParentState();
				Transition newTransition = sourceState.addTransition(parentOfDest);		
				newTransitions.addItem(newTransition.getIrpTransition());
				
				if(transition.getItsGuard() != null)
				{
					newTransition.setItsGuard(transition.getItsGuard().getBody());
				}
				
				if(transition.getItsAction() != null)
				{
					newTransition.setItsAction(transition.getItsAction().getBody());
				}
				
				if(transition.getItsTrigger() != null)
				{
					newTransition.setItsTrigger(transition.getItsTrigger().getBody());
				}
			}
			else
			{
				/* No automatic repairing */
			}
		}
		
		iter = transitionsFound.iterator();
		while(iter.hasNext())
		{
			Transition transition = iter.next();
			statechart.deleteTransition(transition);
		}
		
		IRPCollection relationTypes = irpApplication.createNewCollection();
		relationTypes.setSize(1);
		relationTypes.setString(1, "AllRelations");
		
		statechart.getIrpStatechart().populateDiagram(newTransitions, relationTypes, "fromto");		
		
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
			String nameLineString = "  Cross Level Transition: " + transition.toString() + "\n";
			statisticsString += nameLineString;
		}

		return statisticsString;
	}
}
