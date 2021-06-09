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
public class _4_ISNAntiPattern extends AntiPatternBase 
{
	Vector<State> statesFound;
	
	final String RegularExpression = "state_\\d{1,}";
	
	public _4_ISNAntiPattern()
	{
		name = this.getClass().getSimpleName();
		statesFound = new Vector<State>();
	}

	@Override
	public boolean control(Statechart statechart) 
	{
		boolean bReturn = false;
		
		if(!statechart.isIncludeAndState())
		{
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
					state.print();
					hitCountState++;
				}
			}
		}
		
		if(bReturn)
		{
			hitCountStatechart++;
			statechart.setISN(true);
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
