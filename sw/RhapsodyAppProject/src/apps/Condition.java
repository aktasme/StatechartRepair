package apps;

import com.telelogic.rhapsody.core.*;

public class Condition extends Node
{
	IRPConnector connector;
	
	public Condition(IRPConnector connector)
	{
		this.connector = connector;
	}
}
