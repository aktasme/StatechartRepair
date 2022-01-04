package apps;

public class CommonLog 
{
	protected String printableString = "";
	
	public CommonLog()
	{
		
	}
	
	public String toPrintableString()
	{
		String log = "";
		return log;
	}
	
	public String toStatisticsString()
	{
		String log = "";
		return log;	
	}

	public String toString()
	{
		String string = "";
		return string;
	}
	
	protected String toString(boolean condition)
	{
		String string = "-";		
		
		if(condition)
		{
			string = "+";
		}

		return string;
	}
	
	public void print()
	{
		System.out.print(toPrintableString());
	}
	
	public void printStatistics()
	{
		System.out.print(toStatisticsString());
	}
}
