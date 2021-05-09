package apps;

import com.telelogic.rhapsody.core.*;

public class Condition extends Node
{
	Statechart statechart;
	IRPConnector connector;
	
	public Condition(Statechart statechart, IRPConnector connector)
	{
		super(statechart, connector, NodeTypeEnum.NodeType_condition);
		this.statechart = statechart;
		this.connector = connector;
	}
}
