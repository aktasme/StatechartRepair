package apps;

/**
 * @author mehmetaktas
 *
 * Complex Statechart Diagram
 * 
 */
public class _1_CSDAntiPattern extends AntiPatternBase
{
	final float COMPLEXITY_THRESHOLD = 2;
	float complexity = 0;
	
	public _1_CSDAntiPattern()
	{
		name = this.getClass().getSimpleName();
	}
	
	@Override
	public boolean control(Statechart statechart) 
	{
		boolean bReturn = false;
		
		if(statechart.getStateCount() > 0)
		{
			complexity = (float)statechart.getExternalTransitionCount() / (float)statechart.getStateCount();
		
			if(complexity >= COMPLEXITY_THRESHOLD)
			{
				bReturn = true;
				hitCount++;
			}
		}
		
		statechart.setComplexity(complexity);
		statechart.setCSD(bReturn);
		
		return bReturn;
	}

	@Override
	public boolean repair(Statechart statechart) 
	{
		/* State machine optimization and minimization algorithm can be used for complex statechart diagrams. */
		/* In this work no solution is recommended for this type of diagrams. */
		return false;
	}

}
