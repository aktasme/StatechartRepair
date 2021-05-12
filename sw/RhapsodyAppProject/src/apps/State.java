package apps;

import java.util.Vector;

import com.telelogic.rhapsody.core.*;

public class State extends Node
{
	Statechart statechart;
	IRPState irpState;
	
	int depth = -1;
	
	public State(Statechart statechart, IRPState irpState)
	{
		super(statechart, irpState, NodeTypeEnum.NodeType_state);
		this.statechart = statechart;
		this.irpState = irpState;		
	}

	/* Wrapper Functions */
	public Vector<State> getSubStates()
	{
		Vector<State> subStates = new Vector<State>();
		
		IRPCollection irpSubStates = irpState.getSubStates();
		for(int index = 1; index < irpSubStates.getCount()+1; index++)
		{
			IRPState irpState = (IRPState)irpSubStates.getItem(index);
			State state = statechart.getState(irpState.getName());
			subStates.add(state);
		}
		
		return subStates;
	}
	
	public Vector<Transition> getInTransitions()
	{
		Vector<Transition> inTransitions = new Vector<Transition>();
		
		return inTransitions;
	}
	
	/* Logging Functions */
	@Override
	public void print() 
	{
		super.print();
		
		System.out.printf("State:%s depth:%d\n", irpState.getName(), depth);
	}
	
	/* Getters and Setters */
	public int getDepth() 
	{
		return depth;
	}

	public void setDepth(int depth) 
	{
		this.depth = depth;
	}
}
