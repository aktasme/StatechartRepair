package apps;

import java.util.Vector;
import java.io.File;
import java.util.HashMap;
import com.telelogic.rhapsody.core.*;

public class Statechart
{
	final String ExportPath = "D:\\GitHub\\StatechartRepair\\doc\\exports\\";
	final String ExportExt = ".emf";

	
	IRPPackage irpPackage;
	IRPClass irpClass;
	IRPStatechart irpStatechart;
	IRPState irpRoot;
	IRPCollection irpElements;
	
	Vector<State> states;
	HashMap<String, State> stateMap;
	
	Vector<Condition> conditions;
	HashMap<String, Condition> conditionMap;
	
	Vector<Node> nodes;
	HashMap<String, Node> nodeMap;
	
	Vector<Transition> transitions;
	HashMap<String, Transition> transitionMap;

	float complexity = 0;
	
	public Statechart(IRPStatechart irpStatechart)
	{
		this.irpStatechart = irpStatechart;
		this.irpRoot = irpStatechart.getRootState();
		this.irpElements = irpStatechart.getElementsInDiagram();
		this.irpClass = (IRPClass)irpStatechart.getItsClass();
		this.irpPackage = (IRPPackage)irpClass.getOwner();
				
		states = new Vector<State>();
		stateMap = new HashMap<String, State>();
		
		conditions = new Vector<Condition>();
		conditionMap = new HashMap<String, Condition>();
		
		nodes = new Vector<Node>();
		nodeMap = new HashMap<String, Node>();
		
		transitions = new Vector<Transition>();
		transitionMap = new HashMap<String, Transition>();
	}
	
	public void initialize()
	{
		findElements();
		initializeStates();
		export();
		print();
	}
	
	public void findElements()
	{		
		for(int index = 1; index <= irpElements.getCount(); index++)
		{
			IRPModelElement element = (IRPModelElement)irpElements.getItem(index);
			if(element.getIsOfMetaClass("State") == 1)
			{
				IRPState irpState = (IRPState)element;
				State state = new State(this, irpState);
				
				states.add(state);
				stateMap.put(irpState.getName(), state);
				
				nodes.add(state);
				nodeMap.put(irpState.getName(), state);
			}
			else if(element.getIsOfMetaClass("Condition") == 1)
			{
				IRPConnector irpConnector = (IRPConnector)element;
				Condition condition = new Condition(this, irpConnector);
				
				conditions.add(condition);
				conditionMap.put(irpConnector.getName(), condition);
				
				nodes.add(condition);		
				nodeMap.put(irpConnector.getName(), condition);
			}
			else if(element.getIsOfMetaClass("Transition") == 1)
			{
				IRPTransition irpTransition = (IRPTransition)element;
				Transition transition = new Transition(this, irpTransition);
				
				transitions.add(transition);
				transitionMap.put(irpTransition.getName(), transition);
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
		
		State rootState = stateMap.get("ROOT");
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
	
	/* Helper Functions */
	public void export()
	{
		String folderName = ExportPath + irpPackage.getName(); 
		String exportName = folderName + "\\" + irpClass.getName() + ExportExt;
		
		File folder = new File(folderName);
		if(!folder.exists())
		{
			folder.mkdirs();
		}
		
		irpStatechart.getPicture(exportName);
		System.out.printf("  Export %s to %s\n", irpClass.getName(), exportName);	
	}
	
	/* Wrapper Functions */
	public State getState(String name)
	{
		State state = stateMap.get(name);
		return state;
	}
	
	public Condition getCondition(String name)
	{
		Condition condition = conditionMap.get(name);
		return condition;
	}
	
	public Node getNode(String name)
	{
		Node node = nodeMap.get(name);
		return node;
	}	
	
	public Transition getTransition(String name)
	{
		Transition transition = transitionMap.get(name);
		return transition;
	}
	
	/* Logging Functions */
	public void print()
	{
		System.out.printf("\nStatechart %s:\n", irpClass.getName());
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

	public Vector<State> getStates() {
		return states;
	}

	public void setStates(Vector<State> states) 
	{
		this.states = states;
	}

	public Vector<Transition> getTransitions() 
	{
		return transitions;
	}

	public void setTransitions(Vector<Transition> transitions) 
	{
		this.transitions = transitions;
	}
	
	

}
