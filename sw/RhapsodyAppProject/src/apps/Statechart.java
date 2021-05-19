package apps;

import java.util.Vector;
import java.io.File;
import java.util.HashMap;
import com.telelogic.rhapsody.core.*;

public class Statechart extends Element
{
	final String ExportPath = "D:\\GitHub\\StatechartRepair\\doc\\exports\\";
	final String ExportExt = ".emf";

	IRPApplication rhapsody;
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
	
	String className;
	
	boolean isCSD = false;
	boolean isTBSWDH = false;
	boolean isTWCWOE = false;
	boolean isISN = false;
	boolean isURS = false;
	boolean isNC = false;
	boolean isUNS = false;
	
	public Statechart(IRPApplication rhapsody, IRPStatechart irpStatechart)
	{
		super(irpStatechart);
		
		this.rhapsody = rhapsody;
		this.irpStatechart = irpStatechart;
		this.irpRoot = irpStatechart.getRootState();
		this.irpElements = irpStatechart.getElementsInDiagram();
		this.irpClass = (IRPClass)irpStatechart.getItsClass();
		this.irpPackage = (IRPPackage)irpClass.getOwner();
		this.className = irpClass.getName();
				
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
		//print();
		export();
	}
	
	public void reset()
	{
		states.clear();
		stateMap.clear();
		conditions.clear();
		conditionMap.clear();
		nodes.clear();
		nodeMap.clear();
		transitions.clear();
		transitionMap.clear();
		
		findElements();
		initializeStates();
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
				
				/* Internal transitions are not included in elements */
				/* Create extra transitions for them */
				IRPCollection irpTransitions =  irpState.getInternalTransitions();
				for(int tIndex = 1; tIndex < irpTransitions.getCount() + 1; tIndex++)
				{
					IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(tIndex);
					Transition transition = new Transition(this, irpTransition);
					transitions.add(transition);
					transitionMap.put(irpTransition.getName(), transition);
				}
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
				//System.out.printf("findElements(): ignored element: MetaClass:%s Name:%s\n", element.getMetaClass(), element.getName());
				/* Do not count other type of elements for now */
			}						
		}	
	}
	
	public void initializeStates()
	{
		Vector<State> queue = new Vector<State>();
		
		State rootState = stateMap.get("ROOT");
		rootState.setDepth(0);		
		rootState.setDefault(true);
		queue.add(rootState);

		
		while(!queue.isEmpty())
		{
			State state = queue.firstElement();
			queue.remove(0);
			
			/* If the state has default transition, it is default state */
			Transition defaultTransition = state.getDefaultTransition(); 
			if(defaultTransition != null)
			{
				State subState = (State)defaultTransition.getItsTarget();
				subState.setDefault(true);
			}
			
			Vector<State> subStates = state.getSubStates();
			for(int index = 0; index < subStates.size(); index++)
			{
				State child = subStates.get(index);
				child.setDepth(state.getDepth() + 1);
				
				if(subStates.size() == 1)
				{
					/* If the state is only state of its parent, it is default state */
					child.setDefault(true);
				}
						
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
		//System.out.printf("  Export %s to %s\n", irpClass.getName(), exportName);	
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
	
	public void deleteState(State state)
	{
		irpStatechart.deleteState(state.getIrpState());
		states.remove(state);
		stateMap.remove(state.getName());
	}
	
	public void deleteTransition(Transition transition)
	{
		transitions.remove(transition);
		transitionMap.remove(transition.getName());
	}
		
	/* Logging Functions */
	@Override
	public String toPrintableString() 
	{
		String mainProperties = String.format("%-10s: %2d %2d %2d %2d", irpClass.getName(), nodes.size(), states.size(), conditions.size(), transitions.size());
		String antiPatternProperties = String.format(" | %s %s %s %s %s %s %s", toString(isCSD), toString(isTBSWDH), toString(isTWCWOE), toString(isISN), toString(isURS), toString(isNC), toString(isUNS));
		String extraProperties = String.format(" | %10f", complexity);
		printableString = mainProperties + antiPatternProperties + extraProperties;
		return printableString;
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

	public Vector<State> getStates() 
	{
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

	public boolean isCSD() 
	{
		return isCSD;
	}

	public void setCSD(boolean isCSD) 
	{
		this.isCSD = isCSD;
	}

	public boolean isTBSWDH()
	{
		return isTBSWDH;
	}

	public void setTBSWDH(boolean isTBSWDH) 
	{
		this.isTBSWDH = isTBSWDH;
	}

	public boolean isTWCWOE() 
	{
		return isTWCWOE;
	}

	public void setTWCWOE(boolean isTWCWOE) 
	{
		this.isTWCWOE = isTWCWOE;
	}

	public boolean isISN() 
	{
		return isISN;
	}

	public void setISN(boolean isISN) 
	{
		this.isISN = isISN;
	}

	public boolean isURS() 
	{
		return isURS;
	}

	public void setURS(boolean isURS) 
	{
		this.isURS = isURS;
	}

	public boolean isNC() 
	{
		return isNC;
	}

	public void setNC(boolean isNC) 
	{
		this.isNC = isNC;
	}

	public boolean isUNS() 
	{
		return isUNS;
	}

	public void setUNS(boolean isUNS) 
	{
		this.isUNS = isUNS;
	}
}
