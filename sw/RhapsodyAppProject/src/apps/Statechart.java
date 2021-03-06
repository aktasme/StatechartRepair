package apps;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPConnector;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPackage;
import com.telelogic.rhapsody.core.IRPProject;
import com.telelogic.rhapsody.core.IRPState;
import com.telelogic.rhapsody.core.IRPStateVertex;
import com.telelogic.rhapsody.core.IRPStatechart;
import com.telelogic.rhapsody.core.IRPTransition;

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
	IRPProject irpProject;
	
	Vector<State> states;
	HashMap<String, State> stateMap;
	
	Vector<Condition> conditions;
	HashMap<String, Condition> conditionMap;
	
	Vector<Node> nodes;
	HashMap<String, Node> nodeMap;
	
	Vector<Transition> transitions;
	Vector<Transition> internalTransitions;
	Vector<Transition> externalTransitions;
	HashMap<String, Transition> transitionMap;

	float complexity = 0;
	boolean isIncludeAndState = false;
	
	String className;
	
	private boolean isCrossLevelTransition = false;
	private boolean isMissingEvent = false;
	private boolean isGenericStateName = false;
	private boolean isUnreachable = false;
	private boolean isCascadedConditions = false;
	private boolean isIsolated = false;
	private boolean isComplex = false;
	private boolean isAnyAntipatternExists = false;
	private boolean isAnyRepairableAntipatternExists = false;
	
	private boolean isHideStatechartName = false;
	
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
		this.irpProject = (IRPProject)rhapsody.getProjects().getItem(1);
				
		states = new Vector<State>();
		stateMap = new HashMap<String, State>();
		
		conditions = new Vector<Condition>();
		conditionMap = new HashMap<String, Condition>();
		
		nodes = new Vector<Node>();
		nodeMap = new HashMap<String, Node>();
		
		transitions = new Vector<Transition>();
		internalTransitions = new Vector<Transition>();
		externalTransitions = new Vector<Transition>();
		transitionMap = new HashMap<String, Transition>();
	}
	
	public void initialize()
	{
		findElements();
		initializeStates();
		//print();
		//export();
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
		for(int index = 1; index < irpElements.getCount() + 1; index++)
		{
			IRPModelElement element = (IRPModelElement)irpElements.getItem(index);
			if(element.getIsOfMetaClass("State") == 1)
			{
				IRPState irpState = (IRPState)element;
				State state = new State(this, irpState);
				//state.print();
				
				states.add(state);
				stateMap.put(irpState.getGUID(), state);
				
				nodes.add(state);
				nodeMap.put(irpState.getGUID(), state);
								
				/* Internal transitions are not included in elements */
				/* Create extra transitions for them */
				IRPCollection irpTransitions =  irpState.getInternalTransitions();
				for(int tIndex = 1; tIndex < irpTransitions.getCount() + 1; tIndex++)
				{
					IRPTransition irpTransition = (IRPTransition)irpTransitions.getItem(tIndex);
					createTransition(irpTransition, true);
				}
			}
			else if(element.getIsOfMetaClass("Condition") == 1)
			{
				IRPConnector irpConnector = (IRPConnector)element;
				Condition condition = new Condition(this, irpConnector);
				
				conditions.add(condition);
				conditionMap.put(irpConnector.getGUID(), condition);
				
				nodes.add(condition);		
				nodeMap.put(irpConnector.getGUID(), condition);
			}
			else if(element.getIsOfMetaClass("Transition") == 1)
			{
				IRPTransition irpTransition = (IRPTransition)element;
				createTransition(irpTransition, false);
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
		
		Iterator<State> iter = states.iterator();
		
		while(iter.hasNext())
		{
			State rootState = iter.next();
			if(rootState != null && rootState.getName().equals("ROOT"))
			{
				rootState.setDepth(0);		
				rootState.setDefault(true);
				queue.add(rootState);
				
				while(!queue.isEmpty())
				{
					State state = queue.firstElement();
					queue.remove(0);
					
					if(state.isAnd())
					{
						isIncludeAndState = true;
					}
					
					/* If the state has default transition, it is default state */
					Transition defaultTransition = state.getDefaultTransition(); 
					if(defaultTransition != null)
					{
						Node subNode = (Node)defaultTransition.getItsTarget();
						
						if(subNode != null)
						{
							subNode.setDefault(true);
						}
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
		}
	}
		
	/* Helper Functions */
	public void export()
	{
		String folderName = ExportPath + irpProject.getName() + "\\" + irpPackage.getName(); 
		String exportName = folderName + "\\" + irpClass.getName() + ExportExt;
		
		File folder = new File(folderName);
		if(!folder.exists())
		{
			folder.mkdirs();
		}
		
		irpStatechart.getPicture(exportName);
		//System.out.printf("  Export %s to %s\n", irpClass.getName(), exportName);	
	}
	
	public boolean isAnyAntipatternExists()
	{
		isAnyAntipatternExists = isCrossLevelTransition || isMissingEvent || isGenericStateName ||
								 isUnreachable || isCascadedConditions || isIsolated || isComplex;
		
		return isAnyAntipatternExists;
	}
	
	public boolean isAnyRepairableAntipatternExists()
	{
		isAnyRepairableAntipatternExists = isCrossLevelTransition || isMissingEvent || isGenericStateName ||
									   	   isUnreachable || isCascadedConditions || isIsolated;
		
		return isAnyRepairableAntipatternExists;
	}
	
	/* Wrapper Functions */
	public State getState(String guid)
	{
		State state = stateMap.get(guid);
		return state;
	}
	
	public Condition getCondition(String guid)
	{
		Condition condition = conditionMap.get(guid);
		return condition;
	}
	
	public Node getNode(String guid)
	{
		Node node = nodeMap.get(guid);
		return node;
	}	
	
	public Transition getTransition(String guid)
	{
		Transition transition = transitionMap.get(guid);
		return transition;
	}
	
	public void deleteState(State state)
	{
		states.remove(state);
		stateMap.remove(state.getGUID());
		irpStatechart.deleteState(state.getIrpState());
	}
	
	public void deleteCondition(Condition condition)
	{
		conditions.remove(condition);
		conditionMap.remove(condition.getGUID());
		IRPStateVertex irpStateVertex = condition.getIrpStateVertex();
		irpStateVertex.deleteFromProject();
	}
	
	public void deleteTransition(Transition transition)
	{
		transitions.remove(transition);
		transitionMap.remove(transition.getGUID());
		IRPTransition irpTransition = transition.getIrpTransition();
		irpTransition.deleteFromProject();
	}
	
	public void createGraphics()
	{
		irpStatechart.createGraphics();
	}
	
	Transition createTransition(IRPTransition irpTransition, boolean isIntenal)
	{
		Transition transition = new Transition(this, irpTransition, isIntenal);
		
		transitions.add(transition);
		transitionMap.put(irpTransition.getGUID(), transition);
		
		if(isIntenal)
		{
			internalTransitions.add(transition);
		}
		else
		{
			externalTransitions.add(transition);
		}
		
		//System.out.printf("createTransition:%s %s\n", transition.toString(), irpTransition.getGUID());

		return transition;
	}
		
	/* Logging Functions */
	@Override
	public String toPrintableString() 
	{
		String statechartName = irpClass.getName();
		int statechartNameLen = statechartName.length();
		int publicCharacterLen = 3;
		if(isHideStatechartName && statechartNameLen > publicCharacterLen)
		{
			statechartName = statechartName.substring(0, publicCharacterLen) + new String(new char[statechartNameLen-publicCharacterLen]).replace("\0", "*");
		}
		
		String mainProperties = String.format("%-60s: %4d %4d %4d %4d(%4d:%4d)", statechartName, nodes.size(), states.size(), conditions.size(), transitions.size(), externalTransitions.size(), internalTransitions.size());
		String antiPatternProperties = String.format(" | %s %s %s %s %s %s %s", toString(isCrossLevelTransition), toString(isMissingEvent), toString(isGenericStateName), toString(isUnreachable), toString(isCascadedConditions), toString(isIsolated), toString(isComplex));
		String extraProperties = String.format(" | %10f", complexity);
		printableString = mainProperties + antiPatternProperties + extraProperties + "\n";
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
	
	public int getNodesCount()
	{
		return nodes.size();
	}
	
	public int getConditionsCount()
	{
		return conditions.size();
	}
	
	public int getInternalTransitionCount() 
	{
		return internalTransitions.size();
	}
	
	public int getExternalTransitionCount() 
	{
		return externalTransitions.size();
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

	public boolean isCrossLevelTransition()
	{
		return isCrossLevelTransition;
	}

	public void setCrossLevelTransition(boolean isCrossLevelTransition) 
	{
		this.isCrossLevelTransition = isCrossLevelTransition;
	}

	public boolean isMissingEvent() 
	{
		return isMissingEvent;
	}

	public void setMissingEvent(boolean isMissingEvent) 
	{
		this.isMissingEvent = isMissingEvent;
	}

	public boolean isIsolated() 
	{
		return isIsolated;
	}

	public void setIsolated(boolean isIsolated) 
	{
		this.isIsolated = isIsolated;
	}

	public boolean isUnreachable() 
	{
		return isUnreachable;
	}

	public void setUnreachable(boolean isUnreachable) 
	{
		this.isUnreachable = isUnreachable;
	}

	public boolean isCascadedConditions() 
	{
		return isCascadedConditions;
	}

	public void setCascadedConditions(boolean isCascadedConditions) 
	{
		this.isCascadedConditions = isCascadedConditions;
	}

	public boolean isGenericStateName() 
	{
		return isGenericStateName;
	}

	public void setGenericStateName(boolean isGenericStateName) 
	{
		this.isGenericStateName = isGenericStateName;
	}

	public boolean isIncludeAndState() 
	{
		return isIncludeAndState;
	}

	public boolean isComplex() 
	{
		return isComplex;
	}

	public void setComplex(boolean isComplex) 
	{
		this.isComplex = isComplex;
	}
	
	public void setIncludeAndState(boolean hasAndState) 
	{
		this.isIncludeAndState = hasAndState;
	}

	public IRPStatechart getIrpStatechart() 
	{
		return irpStatechart;
	}

	public void setIrpStatechart(IRPStatechart irpStatechart) 
	{
		this.irpStatechart = irpStatechart;
	}

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}
}
