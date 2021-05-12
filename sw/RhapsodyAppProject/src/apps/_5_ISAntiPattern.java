package apps;

import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mehmetaktas
 * 
 * Isolated State
 *
 */
public class _5_ISAntiPattern implements AntiPatternBase
{
	Vector<State> statesFound;
	
	public _5_ISAntiPattern()
	{
		statesFound = new Vector<State>();
	}

	@Override
	public boolean control(Statechart statechart) 
	{
		System.out.printf("  [Control] Isolated State: ");

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
