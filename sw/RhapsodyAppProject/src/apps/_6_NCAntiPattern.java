package apps;

import java.util.Iterator;
import java.util.Vector;

import apps.Node.NodeTypeEnum;

/**
 * @author mehmetaktas
 * 
 * Nested Conditions
 *
 */
public class _6_NCAntiPattern implements AntiPatternBase
{
	Vector<Transition> transitionsFound;

	public _6_NCAntiPattern() 
	{
		transitionsFound = new Vector<Transition>();
	}

	@Override
	public boolean control(Statechart statechart) 
	{
		System.out.printf("  [Control] Nested Conditions: ");

		boolean bReturn = false;
		Vector<Transition> transitions = statechart.getTransitions();
		Iterator<Transition> iter = transitions.iterator();
		
		while(iter.hasNext())
		{
			Transition transition = iter.next();

			Node sourceNode = transition.getItsSource();
			Node targetNode = transition.getItsTarget();
			
			if(sourceNode.getType() == NodeTypeEnum.NodeType_condition && targetNode.getType() == NodeTypeEnum.NodeType_condition)
			{
				transitionsFound.add(transition);
				bReturn = true;				
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
