package log;

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
		System.out.println(toPrintableString());
	}
}
