package apps;

import java.util.Vector;
import java.util.HashMap;
import com.telelogic.rhapsody.core.*;

public class Statechart
{
	IRPStatechart statechart;
	IRPState root;
	IRPCollection elements;
	
	HashMap<String ,State> states;
	Vector<Condition> conditions;
	Vector<Node> nodes;
	Vector<Transition> transitions;

	float complexity = 0;
	
	public Statechart(IRPStatechart statechart)
	{
		this.statechart = statechart;
		this.root = statechart.getRootState();
		this.elements = statechart.getElementsInDiagram();		
		
		states = new HashMap<String, State>();
		conditions = new Vector<Condition>();
		nodes = new Vector<Node>();
		transitions = new Vector<Transition>();
	}
	
	public void initialize()
	{
		findElements();
		initializeStates();
		
		print();
	}
	
	public void findElements()
	{		
		for(int index = 1; index <= elements.getCount(); index++)
		{
			IRPModelElement element = (IRPModelElement)elements.getItem(index);
			if(element.getIsOfMetaClass("State") == 1)
			{
				IRPState irpState = (IRPState)element;
				State state = new State(this, irpState);
				states.put(irpState.getName(), state);
				nodes.add(state);							
			}
			else if(element.getIsOfMetaClass("Condition") == 1)
			{
				IRPConnector irpConnector = (IRPConnector)element;
				Condition condition = new Condition(irpConnector);
				conditions.add(condition);
				nodes.add(condition);								
			}
			else if(element.getIsOfMetaClass("Transition") == 1)
			{
				IRPTransition irpTransition = (IRPTransition)element;
				Transition transition = new Transition(irpTransition);
				transitions.add(transition);
			}
			else
			{
				/* Do not count other type of elements for now */
			}						
		}	
	}
	
	public void initializeStates()
	{
		Vector<State> queue = new Vector<State>();
		
		State rootState = states.get("ROOT");
		queue.add(rootState);
		rootState.setDepth(0);
		
		while(!queue.isEmpty())
		{
			State state = queue.firstElement();
			queue.remove(0);
			
			Vector<State> subStates = state.getSubStates();
			for(int index = 0; index < subStates.size(); index++)
			{
				State child = subStates.get(index);
				child.setDepth(state.getDepth() + 1);
				queue.add(child);
			}
		}
	}
	
	/* Wrapper Functions */
	public State getState(String stateName)
	{
		State state = states.get(stateName);
		return state;
	}
	
	/* Logging Functions */
	public void print()
	{
		System.out.printf("Statechart %s:\n", statechart.getName());
		System.out.printf("  #Nodes: %d\n", nodes.size());
		System.out.printf("  #States: %d\n", states.size());
		System.out.printf("  #Conditions: %d\n", conditions.size());
		System.out.printf("  #Transitions: %d\n", transitions.size());
	}
	
	/* Getters and Setters */
	public int getStateCount() 
	{
		return states.size();
	}
		
	public int getTransitionCount() 
	{
		return transitions.size();
	}
	
	public float getComplexity() 
	{
		return complexity;
	}

	public void setComplexity(float complexity) 
	{
		this.complexity = complexity;
	}

}
