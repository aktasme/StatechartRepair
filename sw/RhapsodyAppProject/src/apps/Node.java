package apps;

import com.telelogic.rhapsody.core.*;

public class Node extends Element
{
	public enum NodeTypeEnum
	{
		NodeType_state,
		NodeType_condition,
		NodeTypeCount
	}
	
	Statechart statechart;
	IRPStateVertex irpStateVertex;
	NodeTypeEnum type;
	
	public Node(Statechart statechart, IRPStateVertex irpStateVertex, NodeTypeEnum type)
	{
		super(irpStateVertex);
		this.statechart = statechart;
		this.irpStateVertex = irpStateVertex;
		this.type = type;
	}
	
	/* Wrapper Functions */
	String getName()
	{
		return irpStateVertex.getName();
	}
	
	/* Getters and Setters */
	public NodeTypeEnum getType() 
	{
		return type;
	}

	public void setType(NodeTypeEnum type) 
	{
		this.type = type;
	}	
}
