package apps;

import com.telelogic.rhapsody.core.IRPConnector;

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
