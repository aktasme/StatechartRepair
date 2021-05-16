package apps;

import java.util.Iterator;
import java.util.Vector;
import com.telelogic.rhapsody.core.*;

public class State extends Node
{
	IRPState irpState;
	boolean isRoot;
	boolean isDefault;
	
	int depth = -1;
	
	public State(Statechart statechart, IRPState irpState)
	{
		super(statechart, irpState, NodeTypeEnum.NodeType_state);
		this.irpState = irpState;
		this.isRoot = (irpState.isRoot() == 1);
		this.isDefault = false;
	}

	/* Wrapper Functions */
	public Vector<State> getSubStates()
	{
		Vector<State> subStates = new Vector<State>();
		
		IRPCollection irpSubStates = irpState.getSubStates();
		for(int index = 1; index <= irpSubStates.getCount(); index++)
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
		for(int index = 1; index <= irpTransitions.getCount(); index++)
		{
			IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(index);
			Transition transition = statechart.getTransition(irpTransition.getName());
			
			if(transition != null)
			{
				inTransitions.add(transition);
			}
			else
			{
				System.out.printf("State:%s Transition:%s getInTransitions() null pointer\n", irpState.getName(), irpTransition.getName());
			}
		}	
		
		return inTransitions;
	}
	
	public Vector<Transition> getOutTransitions()
	{
		Vector<Transition> outTransitions = new Vector<Transition>();
		
		IRPCollection irpTransitions =  irpState.getOutTransitions();
		for(int index = 1; index <= irpTransitions.getCount(); index++)
		{
			IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(index);
			Transition transition = statechart.getTransition(irpTransition.getName());
			if(transition != null)
			{
				outTransitions.add(transition);
			}
			else
			{
				System.out.printf("State:%s Transition:%s getOutTransitions() null pointer\n", irpState.getName(), irpTransition.getName());
			}				
		}	
		
		return outTransitions;
	}
	
	public Vector<Transition> getInternalTransitions()
	{
		Vector<Transition> internalTransitions = new Vector<Transition>();
		
		IRPCollection irpTransitions =  irpState.getInternalTransitions();
		for(int index = 1; index <= irpTransitions.getCount(); index++)
		{
			IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(index);
			Transition transition = statechart.getTransition(irpTransition.getName());

			if(transition != null)
			{
				internalTransitions.add(transition);
			}
			else
			{
				System.out.printf("State:%s Transition:%s getInternalTransitions() null pointer\n", irpState.getName(), irpTransition.getName());
			}				
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
	
	public void deleteTransitions()
	{
		Vector<Transition> internalTransitions = getInternalTransitions();
		Vector<Transition> inTransitions = getInTransitions();
		Vector<Transition> outTransitions = getOutTransitions();
		
		deleteTransitions(internalTransitions);
		deleteTransitions(inTransitions);
		deleteTransitions(outTransitions);
	}
	
	public void deleteTransitions(Vector<Transition> transitions)
	{
		Iterator<Transition> iter = transitions.iterator();
		while(iter.hasNext())
		{
			Transition transition = iter.next();
			irpState.deleteTransition(transition.getIrpTransition());
			statechart.deleteTransition(transition);
		}
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

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) 
	{
		this.isRoot = isRoot;
	}

	public IRPState getIrpState() 
	{
		return irpState;
	}

	public void setIrpState(IRPState irpState) 
	{
		this.irpState = irpState;
	}

	public boolean isDefault() 
	{
		return isDefault;
	}

	public void setDefault(boolean isDefault) 
	{
		this.isDefault = isDefault;
	}
}
