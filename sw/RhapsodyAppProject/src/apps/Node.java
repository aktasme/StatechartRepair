package apps;

import java.util.Vector;

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
	
	boolean isDefault = false;
	
	public Node(Statechart statechart, IRPStateVertex irpStateVertex, NodeTypeEnum type)
	{
		super(irpStateVertex);
		this.statechart = statechart;
		this.irpStateVertex = irpStateVertex;
		this.type = type;
	}
	
	/* Wrapper Functions */
	public Vector<Transition> getInTransitions()
	{
		Vector<Transition> inTransitions = new Vector<Transition>();
		
		IRPCollection irpTransitions =  irpStateVertex.getInTransitions();
		for(int index = 1; index <= irpTransitions.getCount(); index++)
		{
			IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(index);
			Transition transition = statechart.getTransition(irpTransition.getGUID());
			
			if(transition != null)
			{
				inTransitions.add(transition);
			}
			else
			{
				System.out.printf("State:%s Transition:%s getInTransitions() null pointer\n", irpStateVertex.getName(), irpTransition.getName());
			}
		}	
		
		return inTransitions;
	}
		
	public Vector<Transition> getOutTransitions()
	{
		Vector<Transition> outTransitions = new Vector<Transition>();
		
		IRPCollection irpTransitions =  irpStateVertex.getOutTransitions();
		for(int index = 1; index <= irpTransitions.getCount(); index++)
		{
			IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(index);
			Transition transition = statechart.getTransition(irpTransition.getGUID());
			if(transition != null)
			{
				outTransitions.add(transition);
			}
			else
			{
				System.out.printf("State:%s Transition:%s getOutTransitions() null pointer\n", irpStateVertex.getName(), irpTransition.getName());
			}				
		}	
		
		return outTransitions;
	}
	
	Transition addTransition(Node targetNode)
	{
		IRPStateVertex targetIRPStateVertex = targetNode.getIrpStateVertex();
		
		IRPTransition newIRPTransition = irpStateVertex.addTransition(targetIRPStateVertex);
		
		Transition newTransition = statechart.createTransition(newIRPTransition, false);	
		
		return newTransition;
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

	public boolean isDefault() 
	{
		return isDefault;
	}

	public void setDefault(boolean isDefault) 
	{
		this.isDefault = isDefault;
	}

	public IRPStateVertex getIrpStateVertex() 
	{
		return irpStateVertex;
	}

	public void setIrpStateVertex(IRPStateVertex irpStateVertex) 
	{
		this.irpStateVertex = irpStateVertex;
	}
}
