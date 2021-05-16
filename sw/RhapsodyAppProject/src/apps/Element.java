package apps;

import log.CommonLog;
import com.telelogic.rhapsody.core.IRPModelElement;

public class Element extends CommonLog
{
	String name;
	
	public Element(IRPModelElement irpModelElement)
	{
		this.name = irpModelElement.getName();
	}	
}
