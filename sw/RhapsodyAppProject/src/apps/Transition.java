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
		this.name = irpTransition.getName();
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
		Node node = statechart.getNode(irpSource.getName());
		return node;
	}
	
	public Node getItsTarget()
	{
		IRPStateVertex irpTarget = irpTransition.getItsTarget();
		Node node = statechart.getNode(irpTarget.getName());
		return node;
	}
	
	public IRPGuard getItsGuard()
	{
		return irpTransition.getItsGuard();
	}
	
	public IRPTrigger getItsTrigger()
	{
		return irpTransition.getItsTrigger();
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
