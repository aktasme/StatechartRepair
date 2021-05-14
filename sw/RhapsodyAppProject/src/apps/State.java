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
		for(int index = 1; index < irpSubStates.getCount() + 1; index++)
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
		
		IRPCollection irpTransitions =  irpState.getInTransitions();
		for(int index = 1; index < irpTransitions.getCount() + 1; index++)
		{
			IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(index);
			Transition transition = statechart.getTransition(irpTransition.getName());
			inTransitions.add(transition);
		}	
		
		return inTransitions;
	}
	
	public Vector<Transition> getOutTransitions()
	{
		Vector<Transition> outTransitions = new Vector<Transition>();
		
		IRPCollection irpTransitions =  irpState.getOutTransitions();
		for(int index = 1; index < irpTransitions.getCount() + 1; index++)
		{
			IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(index);
			Transition transition = statechart.getTransition(irpTransition.getName());
			outTransitions.add(transition);
		}	
		
		return outTransitions;
	}
	
	public Vector<Transition> getInternalTransitions()
	{
		Vector<Transition> internalTransitions = new Vector<Transition>();
		
		IRPCollection irpTransitions =  irpState.getInternalTransitions();
		for(int index = 1; index < irpTransitions.getCount() + 1; index++)
		{
			IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(index);
			Transition transition = statechart.getTransition(irpTransition.getName());
			internalTransitions.add(transition);
		}	
		
		return internalTransitions;
	}
	
	public String getEntryAction()
	{
		return irpState.getEntryAction();
	}
	
	public String getExitAction()
	{
		return irpState.getExitAction();
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
