package apps;

import log.CommonLog;
import com.telelogic.rhapsody.core.IRPModelElement;

public class Element extends CommonLog
{
	String name;
	IRPModelElement irpModelElement;
	
	public Element(IRPModelElement irpModelElement)
	{
		this.irpModelElement = irpModelElement;
		this.name = irpModelElement.getName();	
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getGUID()
	{
		return irpModelElement.getGUID();
	}
}
