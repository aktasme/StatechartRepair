package apps;

import log.CommonLog;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPUnit;

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
	
	public void setName(String name) 
	{
		this.name = name;
		irpModelElement.setName(name);
		
		IRPUnit irpUnit = irpModelElement.getSaveUnit();
		if(irpUnit != null)
		{
			irpUnit.save(0);
		}
	}

	public String getGUID()
	{
		return irpModelElement.getGUID();
	}
}
