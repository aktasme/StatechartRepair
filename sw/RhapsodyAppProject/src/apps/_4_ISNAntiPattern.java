package apps;

import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author mehmetaktas
 * 
 * Invalid State Name
 *
 */
public class _4_ISNAntiPattern implements AntiPatternBase 
{
	Vector<State> statesFound;
	
	final String RegularExpression = "state_";
	
	public _4_ISNAntiPattern()
	{
		statesFound = new Vector<State>();
	}

	@Override
	public boolean control(Statechart statechart) 
	{
		System.out.printf("  [Control] Invalid State Name: ");

		boolean bReturn = false;
		
		Vector<State> states = statechart.getStates();
		Iterator<State> iter = states.iterator();
		
		while(iter.hasNext())
		{
			State state = iter.next();		
			String stateName = state.getName();
			
			Pattern pattern = Pattern.compile(RegularExpression);
			Matcher matcher = pattern.matcher(stateName);
			boolean matchFound = matcher.find();	
			if(matchFound)
			{
				statesFound.add(state);
				bReturn = true;
			}
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