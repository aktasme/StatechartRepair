package apps;

import java.util.Iterator;
import java.util.Vector;
import com.telelogic.rhapsody.core.*;

public class State extends Node
{
	protected IRPState irpState;
	protected IRPStatechart irpNestedStatechart;
	protected boolean isRoot = false;
	protected boolean isUnreachable = false;
	protected boolean isAnd = false;
	protected boolean isLeaf = false;
	protected boolean isCompound = false;
	protected boolean isIncludeNestedStatechart = false;
	
	int depth = -1;
	
	public State(Statechart statechart, IRPState irpState)
	{
		super(statechart, irpState, NodeTypeEnum.NodeType_state);
		this.irpState = irpState;
		this.isRoot = (irpState.isRoot() == 1);
		this.isDefault = false;
		this.isAnd = (irpState.isAnd() == 1);
		this.isLeaf = (irpState.isLeaf() == 1);
		this.isCompound = (irpState.isCompound() == 1);
		this.irpNestedStatechart = irpState.getNestedStatechart();
		
		if(irpNestedStatechart != null)
		{
			this.isIncludeNestedStatechart = true;
		}
	}

	/* Wrapper Functions */
	public Vector<State> getSubStates()
	{
		Vector<State> subStates = new Vector<State>();
		
		IRPCollection irpSubStates = irpState.getSubStates();
		for(int index = 1; index <= irpSubStates.getCount(); index++)
		{
			IRPState irpState = (IRPState)irpSubStates.getItem(index);
			State state = statechart.getState(irpState.getGUID());
			subStates.add(state);
		}
		
		return subStates;
	}
		
	public Vector<Transition> getInternalTransitions()
	{
		Vector<Transition> internalTransitions = new Vector<Transition>();
		
		IRPCollection irpTransitions =  irpState.getInternalTransitions();
		for(int index = 1; index <= irpTransitions.getCount(); index++)
		{
			IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(index);
			Transition transition = statechart.getTransition(irpTransition.getGUID());

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
	
	public Transition getDefaultTransition()
	{
		Transition defaultTransition = null;
		
		IRPTransition irpTransition = irpState.getDefaultTransition();
		if(irpTransition != null)
		{
			defaultTransition = statechart.getTransition(irpTransition.getGUID());
		}
		
		return defaultTransition;
	}
	
	public String getEntryAction()
	{
		return irpState.getEntryAction();
	}
	
	public void setEntryAction(String entryActionString)
	{
		irpState.setEntryAction(entryActionString);
	}
	
	public String getExitAction()
	{
		return irpState.getExitAction();
	}
	
	public void setExitAction(String exitActionString)
	{
		irpState.setExitAction(exitActionString);
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
			statechart.deleteTransition(transition);
			irpState.deleteTransition(transition.getIrpTransition());
		}
	}
	
	State getParentState()
	{
		IRPState irpParentState = irpState.getParent();
		
		State parentState = statechart.getState(irpParentState.getGUID());
		
		return parentState;
	}
	
	/* Logging Functions */
	@Override
	public void print() 
	{
		System.out.printf("State:%s depth:%d isIncludeNestedStatechart:%b, isCompound:%b %s\n", irpState.getFullNameInStatechart(), depth, isIncludeNestedStatechart, isCompound, irpState.getGUID());
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

	public boolean isRoot() 
	{
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

	public boolean isUnreachable() 
	{
		return isUnreachable;
	}

	public void setUnreachable(boolean isUnreachable) 
	{
		this.isUnreachable = isUnreachable;
	}

	public boolean isAnd() 
	{
		return isAnd;
	}

	public void setAnd(boolean isAnd) 
	{
		this.isAnd = isAnd;
	}

	public boolean isLeaf() 
	{
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) 
	{
		this.isLeaf = isLeaf;
	}

	public boolean isCompound() 
	{
		return isCompound;
	}

	public void setCompound(boolean isCompound) 
	{
		this.isCompound = isCompound;
	}

	public boolean isIncludeNestedStatechart()
	{
		return isIncludeNestedStatechart;
	}

	public void setIncludeNestedStatechart(boolean isIncludeNestedStatechart)
	{
		this.isIncludeNestedStatechart = isIncludeNestedStatechart;
	}
}
