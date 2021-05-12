package apps;

import com.telelogic.rhapsody.core.*;

public class Transition extends Element
{
	Statechart statechart;
	IRPTransition irpTransition;
	
	public Transition(Statechart statechart, IRPTransition irpTransition)
	{
		this.statechart = statechart;
		this.irpTransition = irpTransition;
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
		IRPStateVertex irpSource = irpTransition.getItsTarget();
		Node node = statechart.getNode(irpSource.getName());
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
	
	/* Logging Functions */
	@Override
	public void print() 
	{
		super.print();
		
		System.out.printf("Transition:%s\n", irpTransition.getName());
	}

}
