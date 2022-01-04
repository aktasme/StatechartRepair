package apps;

import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPStatechart;

public class AntiPatternBase extends CommonLog
{
	public enum RunOption
	{
		RUN_PRINT,
		RUN_CONTROL,
		RUN_REFRESH,
		RUN_REPAIR,
		RUN_HIGHLIGHT
	}
	
	protected String name;
	protected int hitCountStatechart = 0;
	protected int hitCountState = 0;
	protected int hitCountTransition = 0;
	
	final protected int REPAIR_ITERATION_COUNT = 5;
	
	
	public AntiPatternBase()
	{
	}
	
	public void run(IRPApplication irpApplication, Statechart statechart, RunOption option)
	{
		switch(option)
		{
			case RUN_PRINT:
			{
				statechart.print();
				break;
			}
			
			case RUN_CONTROL:
			case RUN_REFRESH:
			{
				control(irpApplication, statechart);
				break;
			}
			
			case RUN_REPAIR:
			{
				for(int iterationIndex = 0; iterationIndex < REPAIR_ITERATION_COUNT; iterationIndex++)
				{
					if(control(irpApplication, statechart))
					{
						repair(irpApplication, statechart);
					}
					else
					{
						break;
					}
				}
				
				break;
			}
			
			case RUN_HIGHLIGHT:
			{
				highlight(irpApplication, statechart);
				break;
			}
			
			default:
			{
				System.out.printf("Unexpected run option:%s\n", option.toString());
				break;
			}
		}		
	}
	
	public boolean control(IRPApplication irpApplication, Statechart statechart)
	{
		return false;
	}
	
	public boolean repair(IRPApplication irpApplication, Statechart statechart)
	{
		return false;
	}
	
	public boolean highlight(IRPApplication irpApplication, Statechart statechart)
	{
		IRPStatechart irpStatechart = statechart.getIrpStatechart();
		irpStatechart.highLightElement();
		return false;
	}
	
	public void initialize()
	{
		hitCountStatechart = 0;
		hitCountState = 0;
		hitCountTransition = 0;
	}
	
	@Override
	public String toPrintableString()
	{
		// TODO Auto-generated method stub
		return super.toPrintableString();
	}

	@Override
	public String toStatisticsString()
	{
		String printableString = String.format("%-30s %4d %4d %4d\n", name, hitCountStatechart, hitCountState, hitCountTransition);
		return printableString;
	}

	/* Getters and Setters */	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getHitCountStatechart()
	{
		return hitCountStatechart;
	}

	public void setHitCountStatechart(int hitCountStatechart)
	{
		this.hitCountStatechart = hitCountStatechart;
	}

	public int getHitCountState()
	{
		return hitCountState;
	}

	public void setHitCountState(int hitCountState)
	{
		this.hitCountState = hitCountState;
	}

	public int getHitCountTransition()
	{
		return hitCountTransition;
	}

	public void setHitCountTransition(int hitCountTransition)
	{
		this.hitCountTransition = hitCountTransition;
	}
}
