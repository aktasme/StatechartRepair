package apps;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModelAntipattern extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3990504632536978793L;
	
	private final String[] ColumnNames = new String[]
	{
		"Anti-pattern Name", 
	 	"Statechart",
	 	"State",
	 	"Transition"
	};
	
	Vector<AntiPatternBase> antipatterns;
    		
	public enum ColumnIndex
	{
		COLUMN_ANTIPATTERNNAME,
		COLUMN_STATECHART,
		COLUMN_STATE,
		COLUMN_TRANSITION
	}

	public TableModelAntipattern()
	{
		super();
		this.antipatterns = new Vector<AntiPatternBase>();
	}
	
	public TableModelAntipattern(Vector<AntiPatternBase> antipatterns)
	{
		super();
		this.antipatterns = antipatterns;
	}
	
	public void add(AntiPatternBase antipattern)
	{
		antipatterns.add(antipattern);
	}
	
	public void print()
	{
		Iterator<AntiPatternBase> iter = antipatterns.iterator();
		
		while(iter.hasNext())
		{
			AntiPatternBase antipattern = iter.next();
			antipattern.print();
		}		
	}
	
    @Override
    public String getColumnName(int column)
    {
        return ColumnNames[column];
    }
	
	@Override
	public int getColumnCount()
	{
		return ColumnNames.length;
	}

    @Override
    public Class<?> getColumnClass(int column)
    {
        return getValueAt(0, column).getClass();
    }	
	
	@Override
	public int getRowCount()
	{
		return antipatterns.size();
	}

	@Override
	public Object getValueAt(int row, int column)
	{
		Object returnObject = null;
		AntiPatternBase antipattern = antipatterns.get(row);
		
		ColumnIndex index = ColumnIndex.values()[column];
		switch(index)
		{
			case COLUMN_ANTIPATTERNNAME:
			{
				returnObject = antipattern.getName();
				break;
			}
			
			case COLUMN_STATECHART:
			{
				returnObject = antipattern.getHitCountStatechart();
				break;
			}
			
			case COLUMN_STATE:
			{
				returnObject = antipattern.getHitCountState();
				break;
			}
			
			case COLUMN_TRANSITION:
			{
				returnObject = antipattern.getHitCountTransition();
				break;
			}
						
			default:
			{
				System.out.printf("Unexpected column:%s\n", index.toString());
				break;
			}
		}
		
		return returnObject;
	}
}
