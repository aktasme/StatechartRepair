package apps;

import com.telelogic.rhapsody.core.IRPModelElement;

public class Element 
{
	String name;
	
	public Element(IRPModelElement irpModelElement)
	{
		this.name = irpModelElement.getName();
	}
	
	public void print()
	{
	}
}
