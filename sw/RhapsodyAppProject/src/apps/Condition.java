package apps;

import com.telelogic.rhapsody.core.*;

public class Condition extends Node
{
	Statechart statechart;
	IRPConnector irpConnector;
	
	public Condition(Statechart statechart, IRPConnector irpConnector)
	{
		super(statechart, irpConnector, NodeTypeEnum.NodeType_condition);
		this.statechart = statechart;
		this.irpConnector = irpConnector;
	}
}
