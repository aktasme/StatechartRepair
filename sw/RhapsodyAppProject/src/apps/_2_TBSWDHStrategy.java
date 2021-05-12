package apps;

import java.util.Iterator;
import java.util.Vector;
import apps.Node.NodeTypeEnum;

/**
 * @author mehmetaktas
 * 
 * Transition Between States with Different Hierarchy
 *
 */
public class _2_TBSWDHStrategy implements StrategyBase 
{
	Vector<Transition> transitionsFound;
	
	public _2_TBSWDHStrategy() 
	{
		transitionsFound = new Vector<Transition>();
	}

	@Override
	public boolean control(Statechart statechart) 
	{
		System.out.printf("  [Control] Transition Between States with Different Hierarchy:");
		
		boolean bReturn = false;
		Vector<Transition> transitions = statechart.getTransitions();
		Iterator<Transition> iter = transitions.iterator();
		
		while(iter.hasNext())
		{
			Transition transition = iter.next();
			
			if(transition.isDefaultTransition() == 0)
			{
				Node sourceNode = transition.getItsSource();
				Node targetNode = transition.getItsTarget();
				
				if(sourceNode.getType() == NodeTypeEnum.NodeType_state && targetNode.getType() == NodeTypeEnum.NodeType_state)
				{
					State sourceState = (State)sourceNode;
					State targetState = (State)targetNode;
					
					if(sourceState.getDepth() != targetState.getDepth())
					{
						transitionsFound.add(transition);
						bReturn = true;
					}
				}
			}
		}
		
		if(bReturn)
		{
			System.out.printf("Found! (%d)\n", transitionsFound.size());		
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

}
