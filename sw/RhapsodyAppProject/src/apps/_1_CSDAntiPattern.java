package apps;

/**
 * @author mehmetaktas
 *
 * Complex Statechart Diagram
 * 
 */
public class _1_CSDAntiPattern implements AntiPatternBase
{
	final float COMPLEXITY_THRESHOLD = 2;
	
	float complexity = 0;
	
	@Override
	public boolean control(Statechart statechart) 
	{
		System.out.printf("  [Control] Complex Statechart Diagram: ");

		boolean bReturn = false;
		
		complexity = (float)statechart.getTransitionCount() / (float)statechart.getStateCount();
		
		if(complexity >= COMPLEXITY_THRESHOLD)
		{
			bReturn = true;
			System.out.printf("True! (%f)\n", complexity);
		}
		else
		{
			System.out.printf("False! (%f)\n", complexity);			
		}
		
		statechart.setComplexity(complexity);
		
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