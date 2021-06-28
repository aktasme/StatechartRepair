package apps;

import com.telelogic.rhapsody.core.*;

public class Transition extends Element
{
	protected Statechart statechart;
	protected IRPTransition irpTransition;	
	protected boolean isInternal = false;
	
	public Transition(Statechart statechart, IRPTransition irpTransition, boolean isInternal)
	{
		super(irpTransition);
		this.statechart = statechart;
		this.irpTransition = irpTransition;
		this.isInternal = isInternal;
	}
	
	/* Wrapper Functions */
	public int isDefaultTransition()
	{
		return irpTransition.isDefaultTransition();
	}
	
	public Node getItsSource()
	{
		IRPStateVertex irpSource = irpTransition.getItsSource();
		Node node = statechart.getNode(irpSource.getGUID());
		return node;
	}
	
	public Node getItsTarget()
	{
		IRPStateVertex irpTarget = irpTransition.getItsTarget();
		Node node = statechart.getNode(irpTarget.getGUID());
		return node;
	}
	
	public IRPGuard getItsGuard()
	{
		return irpTransition.getItsGuard();
	}

	public IRPGuard setItsGuard(String guardString)
	{
		return irpTransition.setItsGuard(guardString);
	}
	
	public IRPTrigger getItsTrigger()
	{
		return irpTransition.getItsTrigger();
	}
		
	IRPTrigger setItsTrigger(String triggerString)
	{
		return irpTransition.setItsTrigger(triggerString);
	}

	/* Getter and Setters */
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public IRPTransition getIrpTransition() 
	{
		return irpTransition;
	}

	public void setIrpTransition(IRPTransition irpTransition) 
	{
		this.irpTransition = irpTransition;
	}

	public boolean isInternal()
	{
		return isInternal;
	}

	public void setInternal(boolean isInternal)
	{
		this.isInternal = isInternal;
	}
	
	/* Logging Functions */
	@Override
	public void print() 
	{
		super.print();
		
		System.out.printf("Transition:%s\n", irpTransition.getName());
	}
}
