package apps;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModelStatechart extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -310515275448508502L;

	private final String[] ColumnNames = new String[]
	{
		"Statechart Name", 
	 	"Cross Level Transition",
	 	"Missing Event",
	 	"Generic State Name",
	 	"Unreachable State",
	 	"Cascaded State",
	 	"Isolated State",
	 	"Complex Statechart"
	};
    		
	Vector<Statechart> statecharts;

	public enum ColumnIndex
	{
		COLUMN_STATECHARTNAME,
		COLUMN_CROSS_LEVEL_TRANSITION,
		COLUMN_MISSING_EVENT,
		COLUMN_GENERIC_STATE_NAME,
		COLUMN_UNREACHABLE_STATE,
		COLUMN_CASCADED_STATE,
		COLUMN_ISOLATED_STATE,
		COLUMN_COMPLEX_STATECHART
	}

	public TableModelStatechart()
	{
		super();
		this.statecharts = new Vector<Statechart>();
	}
	
	public TableModelStatechart(Vector<Statechart> statecharts)
	{
		super();
		this.statecharts = statecharts;
	}
	
	public void add(Statechart statechart)
	{
		statecharts.add(statechart);
	}
	
	public void print()
	{
		Iterator<Statechart> iter = statecharts.iterator();
		
		while(iter.hasNext())
		{
			Statechart statechart = iter.next();
			statechart.print();
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
		return statecharts.size();
	}

	@Override
	public Object getValueAt(int row, int column)
	{
		Object returnObject = null;
		Statechart statechart = statecharts.get(row);
		
		ColumnIndex index = ColumnIndex.values()[column];
		switch(index)
		{
			case COLUMN_STATECHARTNAME:
			{
				returnObject = statechart.getClassName();
				break;
			}
			
			case COLUMN_CROSS_LEVEL_TRANSITION:
			{
				returnObject = statechart.isCrossLevelTransition();
				break;
			}
			
			case COLUMN_MISSING_EVENT:
			{
				returnObject = statechart.isMissingEvent();
				break;
			}
			
			case COLUMN_GENERIC_STATE_NAME:
			{
				returnObject = statechart.isGenericStateName();
				break;
			}
			
			case COLUMN_UNREACHABLE_STATE:
			{
				returnObject = statechart.isUnreachable();
				break;
			}
			
			case COLUMN_CASCADED_STATE:
			{
				returnObject = statechart.isCascadedConditions();
				break;
			}
			
			case COLUMN_ISOLATED_STATE:
			{
				returnObject = statechart.isIsolated();
				break;
			}
			
			case COLUMN_COMPLEX_STATECHART:
			{
				returnObject = statechart.isComplex();
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
