package apps;

import java.util.Iterator;
import java.util.Vector;

import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPGuard;
import com.telelogic.rhapsody.core.IRPTransition;

import apps.Node.NodeTypeEnum;

/**
 * @author mehmetaktas
 * 
 * Cascaded Conditions
 *
 */
public class APCascadedConditions extends AntiPatternBase
{
	Vector<Transition> transitionsFound;

	public APCascadedConditions() 
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

			Node sourceNode = transition.getItsSource();
			Node targetNode = transition.getItsTarget();
			
			if(sourceNode != null && targetNode != null && 
			   sourceNode.getType() == NodeTypeEnum.NodeType_condition && 
			   targetNode.getType() == NodeTypeEnum.NodeType_condition)
			{
				transitionsFound.add(transition);
				bReturn = true;
				hitCountTransition++;
			}			
		}
		
		if(bReturn)
		{
			hitCountStatechart++;
			statechart.setCascadedConditions(true);
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
			
			Condition sourceCondition = (Condition)transition.getItsSource();
			Condition targetCondition = (Condition)transition.getItsTarget();

			IRPGuard guard = transition.getItsGuard();
			String guardString = guard.getBody();
			
			if(guardString.equals("else"))
			{
				Vector<Transition> sourceConditionOutTransitions = sourceCondition.getOutTransitions();
				Iterator<Transition> sourceIterOut = sourceConditionOutTransitions.iterator();
				guardString = "";
				
				while(sourceIterOut.hasNext())
				{
					Transition sourceTransitionOut = sourceIterOut.next();
					if(sourceTransitionOut != transition)
					{
						if(!guardString.isEmpty())
						{
							guardString += " && ";
						}
						
						guardString += sourceTransitionOut.getItsGuard().getBody();
					}
				}
				
				guardString = "!(" + guardString + ")";
			}
			
			Vector<Transition> outTransitions = targetCondition.getOutTransitions();
			Vector<Transition> inTransitions = targetCondition.getInTransitions();

			statechart.deleteCondition(targetCondition);
			
			Iterator<Transition> iterIn = inTransitions.iterator();
			while(iterIn.hasNext())
			{
				Transition transitionIn = iterIn.next();
				statechart.deleteTransition(transitionIn);
			}
						
			Iterator<Transition> iterOut = outTransitions.iterator();
			while(iterOut.hasNext())
			{
				Transition transitionOut = iterOut.next();
				IRPGuard guardOut = transitionOut.getItsGuard();
				String guardOutString = guardOut.getBody();
				
				String repairString;
				if(guardOutString.equals("else"))
				{
					repairString = guardString;
				}
				else
				{
					repairString = "(" + guardString + ") && (" + guardOutString + ")";					
				}														
				
				Node targetNode = transitionOut.getItsTarget();
				Transition newTransition = sourceCondition.addTransition(targetNode);
				newTransition.setItsGuard(repairString);
				newTransitions.addItem(newTransition.getIrpTransition());
				
				statechart.deleteTransition(transitionOut);
			}
		}
		
		IRPCollection relationTypes = irpApplication.createNewCollection();
		relationTypes.setSize(1);
		relationTypes.setString(1, "AllRelations");
		
		statechart.getIrpStatechart().populateDiagram(newTransitions, relationTypes, "fromto");
		
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
			String nameLineString = "  Cascaded Transition: " + transition.toString() + "\n";
			
			statisticsString += nameLineString;
		}

		return statisticsString;
	}
}
