package apps;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author mehmetaktas
 * 
 * Unreachable State
 *
 */
public class _6_URSAntiPattern implements AntiPatternBase
{
	Vector<State> statesFound;
	
	public _6_URSAntiPattern()
	{
		statesFound = new Vector<State>();
	}

	@Override
	public boolean control(Statechart statechart) 
	{
		System.out.printf("  [Control] Unreachable State: ");

		boolean bReturn = false;
		
		Vector<State> states = statechart.getStates();
		Iterator<State> iter = states.iterator();
		
		while(iter.hasNext())
		{
			State state = iter.next();		
		}
		
		if(bReturn)
		{
			System.out.printf("Found! (%d)\n", statesFound.size());		
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
