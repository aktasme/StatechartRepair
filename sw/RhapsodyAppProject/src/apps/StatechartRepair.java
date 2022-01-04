package apps;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.telelogic.rhapsody.core.IRPProject;
import com.telelogic.rhapsody.core.IRPStatechart;
import com.telelogic.rhapsody.core.IRPStatechartDiagram;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPackage;
import com.telelogic.rhapsody.core.RPUserPlugin;

public class StatechartRepair extends RPUserPlugin
{
	private IRPProject irpProject;
	private IRPApplication irpApplication;
	private IRPModelElement irpSelected;
	
	private Vector<Statechart> statecharts;
	private Vector<AntiPatternBase> antiPatterns;
	
	private JFrame mainframe;
	private JTable table;
	private TableModelStatechart tableModel;
	private JScrollPane scrollPane;
	private JTable tableAntipattern;
	
	private int statechartCount = 0;
	private int nodeCount = 0;
	private int stateCount = 0;
	private int conditionCount = 0;
	private int transitionCount = 0;
	
	private float complexityMax = 0.0f;
	private int stateMaxCount = 0;
	private int conditionMaxCount = 0;
	private int transitionMaxCount = 0;

	private String statechartMostComplex = "-";
	private String statechartWithMostStates = "-";
	private String statechartWithMostConditions = "-";
	private String statechartWithMostTransitions = "-";
	
	public StatechartRepair()
	{
		createStrategies();
	}

	@Override
	public void RhpPluginInit(IRPApplication rpyApplication)
	{
		irpApplication = rpyApplication;
		irpProject = irpApplication.activeProject();

		if(statecharts == null)
		{
			statecharts = new Vector<Statechart>();
		}
		
		initialize();		
	}

	@Override
	public void RhpPluginInvokeItem()
	{
		irpApplication.writeToOutputWindow("Log", "RhpPluginInvokeItem\n");
		throw new UnsupportedOperationException("Not supported yet!");
	}

	@Override
	public void OnMenuItemSelect(String menuItem)
	{
		irpSelected = irpApplication.getSelectedElement();
		runAntiPattern(irpSelected);
		createSwingGUI();
		
		String stringFinish = "Statechart Repair finished detection of defected statecharts.\n";
		stringFinish += "See Statechart Repair GUI for further details.";
		irpApplication.writeToOutputWindow("Log", stringFinish);
	}

	@Override
	public void OnTrigger(String trigger)
	{
		irpApplication.writeToOutputWindow("Log", "OnTrigger\n");
		throw new UnsupportedOperationException("Not supported yet!");
	}

	@Override
	public boolean RhpPluginCleanup()
	{
		irpApplication.writeToOutputWindow("Log", "RhpPluginCleanup\n");
		throw new UnsupportedOperationException("Not supported yet!");
	}

	@Override
	public void RhpPluginFinalCleanup()
	{
		irpApplication.writeToOutputWindow("Log", "RhpPluginFinalCleanup\n");
		throw new UnsupportedOperationException("Not supported yet!");
	}
	
	/* Helper functions */
	public void printUsage()
	{
		irpApplication.writeToOutputWindow("Log", "Please select any of these model elements from IBM Rational Rhapsody Model Browser!\n");
		irpApplication.writeToOutputWindow("Log", "* Project\n");
		irpApplication.writeToOutputWindow("Log", "* Package\n");
		irpApplication.writeToOutputWindow("Log", "* Class\n");
		irpApplication.writeToOutputWindow("Log", "* Statechart\n");		
	}
	
	public void initialize()
	{
		statecharts.clear();
		
		statechartCount = 0;
		nodeCount = 0;
		stateCount = 0;
		conditionCount = 0;
		transitionCount = 0;
		
		complexityMax = 0.0f;
		stateMaxCount = 0;
		conditionMaxCount = 0;
		transitionMaxCount = 0;

		statechartMostComplex = "-";
		statechartWithMostStates = "-";
		statechartWithMostConditions = "-";
		statechartWithMostTransitions = "-";	
		
		Iterator<AntiPatternBase> iter = antiPatterns.iterator();
		
		while(iter.hasNext())
		{
			AntiPatternBase antiPattern = iter.next();
			antiPattern.initialize();
		}
	}
	
	public void createStrategies()
	{
		antiPatterns = new Vector<AntiPatternBase>();
		AntiPatternBase antiPattern = null;
		
		antiPattern = new APCrossLevelTransition();
		antiPatterns.add(antiPattern);	
	
		antiPattern = new APMissingEvent();
		antiPatterns.add(antiPattern);
		
		antiPattern = new APGenericStateName();
		antiPatterns.add(antiPattern);
		
		antiPattern = new APUnreachableState();
		antiPatterns.add(antiPattern);
		
		antiPattern = new APCascadedConditions();
		antiPatterns.add(antiPattern);		
		
		antiPattern = new APIsolatedState();
		antiPatterns.add(antiPattern);
		
		antiPattern = new APComplexStatechartDiagram();
		antiPatterns.add(antiPattern);		
	}
	
	public void runAntiPattern(IRPModelElement selected)
	{
		print();
		
		//System.out.printf("runAntiPattern selected:%s metaclass:%s\n", selected.getFullPathName(), selected.getMetaClass());

		if(selected == null)
		{
			printUsage();
		}
		else if(selected.getMetaClass().equals("Project"))
		{		
			IRPProject irpProject = (IRPProject)selected;
			runAntiPattern(irpProject, AntiPatternBase.RunOption.RUN_CONTROL);
		}
		else if(selected.getMetaClass().equals("Package"))
		{
			IRPPackage irpPackage = (IRPPackage)selected;
			runAntiPattern(irpPackage, AntiPatternBase.RunOption.RUN_CONTROL);
		}
		else if(selected.getMetaClass().equals("Class"))
		{
			IRPClass irpClass = (IRPClass)selected;	
			runAntiPattern(irpClass, AntiPatternBase.RunOption.RUN_CONTROL);
		}
		else if(selected.getMetaClass().equals("Statechart"))
		{
			/* Control the strategies for only selected statechart */
			IRPStatechart irpStatechart = (IRPStatechart)selected;
			runAntiPattern(irpStatechart, AntiPatternBase.RunOption.RUN_CONTROL);
		}
		else
		{
			String selectedElementString = String.format("Selected model element: %s %s\n", selected.getMetaClass(), selected.getName());
			irpApplication.writeToOutputWindow("Log", selectedElementString);
			printUsage();
		}
		
		printStatistics();		
	}

	public void runAntiPattern(IRPProject irpProject, AntiPatternBase.RunOption option)
	{
		if(irpProject != null)
		{
			//System.out.printf("Project: %s\n", irpProject.getName());
			IRPCollection irpPackages = irpProject.getPackages();
			for(int packageIndex = 1; packageIndex < irpPackages.getCount() + 1; packageIndex++)
			{
				IRPPackage irpPackage = (IRPPackage)irpPackages.getItem(packageIndex);				
				runAntiPattern(irpPackage, option);
			}
		}
	}	
	
	public void runAntiPattern(IRPPackage irpPackage, AntiPatternBase.RunOption option)
	{
		if(irpPackage != null)
		{
			//System.out.printf("  Package: %s\n", irpPackage.getName());
			IRPCollection irpClasses = irpPackage.getClasses();
			for(int classIndex = 1; classIndex < irpClasses.getCount() + 1; classIndex++)
			{
				IRPClass irpClass = (IRPClass)irpClasses.getItem(classIndex);					
				//System.out.printf("    Class:%s ", irpClass.getName());				
				IRPStatechart irpStatechart = irpClass.getStatechart();
				runAntiPattern(irpStatechart, option);
			}
			
			IRPCollection irpPackages = irpPackage.getPackages();
			for(int packageIndex = 1; packageIndex < irpPackages.getCount() + 1; packageIndex++)
			{
				IRPPackage irpSubPackage = (IRPPackage)irpPackages.getItem(packageIndex);				
				runAntiPattern(irpSubPackage, option);
			}
		}
	}	
	
	public void runAntiPattern(IRPClass irpClass, AntiPatternBase.RunOption option)
	{
		if(irpClass != null)
		{
			IRPStatechart irpStatechart = irpClass.getStatechart();
			runAntiPattern(irpStatechart, option);		
		}
	}
	
	public void runAntiPattern(IRPStatechart irpStatechart, AntiPatternBase.RunOption option)
	{
		if(irpStatechart != null)
		{
			/* Create and initialize Statechart class object */
			//System.out.printf("Statechart:%s\n", irpStatechart.getName());
			Statechart statechart = new Statechart(irpApplication, irpStatechart);
			statechart.initialize();
			runAntiPattern(statechart, option);
		}
		else
		{
			//System.out.printf("has no any statechart\n");
		}
	}
	
	public void runAntiPattern(Statechart statechart, AntiPatternBase.RunOption option)
	{
		if(option == AntiPatternBase.RunOption.RUN_CONTROL)
		{
			this.statechartCount++;
			this.nodeCount += statechart.getNodesCount();
			this.stateCount += statechart.getStateCount();
			this.conditionCount += statechart.getConditionsCount();
			this.transitionCount += statechart.getTransitionCount();
		}
		
		Iterator<AntiPatternBase> iter = antiPatterns.iterator();
		
		while(iter.hasNext())
		{
			AntiPatternBase antiPattern = iter.next();
			antiPattern.run(irpApplication, statechart, option);
		}
		
		if(option == AntiPatternBase.RunOption.RUN_CONTROL)
		{
			/* Show only statecharts with any antipattern */
			if(statechart.isAnyAntipatternExists())
			{
				statecharts.add(statechart);
				statechart.print();
				
				/* For logging */
				iter = antiPatterns.iterator();
				while(iter.hasNext())
				{
					AntiPatternBase antiPattern = iter.next();
					antiPattern.print();
				}		
			}
			
			if(this.complexityMax < statechart.getComplexity())
			{
				this.complexityMax = statechart.getComplexity();
				statechartMostComplex = statechart.getClassName();
			}
			
			if(this.stateMaxCount < statechart.getStateCount())
			{
				this.stateMaxCount = statechart.getStateCount();
				this.statechartWithMostStates = statechart.getClassName();
			}
			
			if(this.conditionMaxCount < statechart.getConditionsCount())
			{
				this.conditionMaxCount = statechart.getConditionsCount();
				this.statechartWithMostConditions = statechart.getClassName();
			}
	
			if(this.transitionMaxCount < statechart.getExternalTransitionCount())
			{
				this.transitionMaxCount = statechart.getExternalTransitionCount();
				this.statechartWithMostTransitions = statechart.getClassName();
			}		
		}
	}	
	
	/* GUI Functions */
	public void createSwingGUI()
	{
		mainframe = new JFrame();	
		tableModel = new TableModelStatechart(statecharts);
		table = new JTable(tableModel);
		scrollPane = new JScrollPane(table);
		
		TableColumnModel tableColumnModelStatechart = table.getColumnModel();
		int firstColumnIndex = 0;
		tableColumnModelStatechart.getColumn(firstColumnIndex).setMinWidth(200);
		
		for(int columnIndex = firstColumnIndex + 1; columnIndex < tableColumnModelStatechart.getColumnCount(); columnIndex++)
		{
			tableColumnModelStatechart.getColumn(columnIndex).setPreferredWidth(80);
		}
		
		IRPModelElement irpSelected = irpApplication.getSelectedElement();
		
		FlowLayout layoutProject = new FlowLayout();
		JPanel panelProject = new JPanel();
		panelProject.setLayout(layoutProject);
		String stringProjectName = irpProject.getName();
		String stringSelectedElement = irpSelected.getFullPathNameIn();
		panelProject.setBorder(BorderFactory.createTitledBorder(stringProjectName + ": " + stringSelectedElement));
		
		BorderLayout layoutColumn = new BorderLayout();
		JPanel panelFirstColumn = new JPanel();
		panelFirstColumn.setLayout(layoutColumn);
		panelProject.add(panelFirstColumn);
		
		/* Processed Elements Statistics */
		GridLayout gridLayoutElements = new GridLayout(0, 2);
		JPanel panelElements = new JPanel();	
		panelElements.setLayout(gridLayoutElements);
		panelElements.setBorder(BorderFactory.createTitledBorder("Processed Elements"));
		panelFirstColumn.add(panelElements, BorderLayout.PAGE_START);
		
		JLabel labelStatechartCountString = new JLabel("Statecharts: ", SwingConstants.LEFT);
		JLabel labelStatechartCountValue = new JLabel(String.valueOf(statechartCount));
		panelElements.add(labelStatechartCountString);
		panelElements.add(labelStatechartCountValue);
		
		JLabel labelStateCountString = new JLabel("States: ", SwingConstants.LEFT);
		JLabel labelStateCountValue = new JLabel(String.valueOf(stateCount));
		panelElements.add(labelStateCountString);
		panelElements.add(labelStateCountValue);
		
		JLabel labelConditionCountString = new JLabel("Conditions: ", SwingConstants.LEFT);
		JLabel labelConditionCountValue = new JLabel(String.valueOf(conditionCount));
		panelElements.add(labelConditionCountString);
		panelElements.add(labelConditionCountValue);
		
		JLabel labelTransitionCountString = new JLabel("Transitions: ", SwingConstants.LEFT);
		JLabel labelTransitionCountValue = new JLabel(String.valueOf(transitionCount));
		panelElements.add(labelTransitionCountString);
		panelElements.add(labelTransitionCountValue);
		
		/* Statistics */
		GridLayout gridLayoutStatistics = new GridLayout(0, 2);
		JPanel panelStatistics = new JPanel();
		panelStatistics.setLayout(gridLayoutStatistics);
		panelStatistics.setBorder(BorderFactory.createTitledBorder("Statechart Statistics"));
		panelFirstColumn.add(panelStatistics, BorderLayout.CENTER);

		JLabel labelMaxComplexityString = new JLabel("Most Complex: ");
		JLabel labelMaxComplexityStatechart = new JLabel(statechartMostComplex + " (" + String.valueOf(complexityMax) + ")");
		panelStatistics.add(labelMaxComplexityString);
		panelStatistics.add(labelMaxComplexityStatechart);
		
		JLabel labelMaxStatesString = new JLabel("Maximum State Count: ");
		JLabel labelMaxStatesValueStatechart = new JLabel(statechartWithMostStates + " (" + String.valueOf(stateMaxCount) + ")");
		panelStatistics.add(labelMaxStatesString);
		panelStatistics.add(labelMaxStatesValueStatechart);
		
		JLabel labelMaxConditionsString = new JLabel("Maximum Condition Count: ");
		JLabel labelMaxConditionsStatechart = new JLabel(statechartWithMostConditions + " (" + String.valueOf(conditionMaxCount) + ")");
		panelStatistics.add(labelMaxConditionsString);
		panelStatistics.add(labelMaxConditionsStatechart);
		
		JLabel labelMaxTransitionsString = new JLabel("Maximum Transition Count: ");
		JLabel labelMaxTransitionsStatechart = new JLabel(statechartWithMostTransitions + " (" + String.valueOf(transitionMaxCount) + ")");
		panelStatistics.add(labelMaxTransitionsString);
		panelStatistics.add(labelMaxTransitionsStatechart);
			
		/* Anti-pattern Statistics */
		JPanel panelAntipatterns = new JPanel();
		panelAntipatterns.setBorder(BorderFactory.createTitledBorder("Detected Anti-patterns"));
		panelProject.add(panelAntipatterns);
		
		TableModelAntipattern tableModelAntipattern = new TableModelAntipattern(antiPatterns);
		tableAntipattern = new JTable(tableModelAntipattern);
		tableAntipattern.setPreferredScrollableViewportSize(new Dimension(600, 120));
		JScrollPane scrollPaneAntipattern = new JScrollPane(tableAntipattern);
		panelAntipatterns.add(scrollPaneAntipattern);		
	
		TableColumnModel tableColumnModelAntipattern = tableAntipattern.getColumnModel();
		firstColumnIndex = 0;
		tableColumnModelAntipattern.getColumn(firstColumnIndex).setMinWidth(200);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		for(int columnIndex = firstColumnIndex + 1; columnIndex < tableColumnModelAntipattern.getColumnCount(); columnIndex++)
		{
			tableColumnModelAntipattern.getColumn(columnIndex).setPreferredWidth(80);
			tableColumnModelAntipattern.getColumn(columnIndex).setCellRenderer(centerRenderer);
		}
	
		/* Buttons */
		FlowLayout flowLayoutButtons = new FlowLayout();
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(flowLayoutButtons);
		
		/* Navigate Button */
	    JButton buttonNavigate = new JButton("Navigate");
	    panelButtons.add(buttonNavigate);
	    buttonNavigate.addActionListener(new ActionListener()
	    {
			@Override
			public void actionPerformed(ActionEvent e){buttonNavigatePressed(e);}
		});

		/* Repair Button */
	    JButton buttonRepair = new JButton("Repair");
	    panelButtons.add(buttonRepair);
	    buttonRepair.addActionListener(new ActionListener()
	    {
			@Override
			public void actionPerformed(ActionEvent e){buttonRepairPressed(e);}
		});

		/* Refresh Button */
	    JButton buttonRefresh = new JButton("Refresh");
	    panelButtons.add(buttonRefresh);
	    buttonRefresh.addActionListener(new ActionListener()
	    {
			@Override
			public void actionPerformed(ActionEvent e){buttonRefreshPressed(e);}
		});
       
	    mainframe.setTitle("Statechart Repair Tool (" + Version.VERSION + ")");
	    
	    mainframe.add(panelProject, BorderLayout.PAGE_START);
	    mainframe.add(panelButtons, BorderLayout.PAGE_END);
	    mainframe.add(scrollPane);
	    
	    mainframe.setSize(1000, 800);
	    mainframe.pack();
	    mainframe.setVisible(true);
	}
	
	public void buttonRefreshPressed(ActionEvent e)
	{
		initialize();
		runAntiPattern(irpSelected);
		tableAntipattern.repaint();
		table.repaint();
	}

	public void buttonNavigatePressed(ActionEvent e)
	{
		int row = table.getSelectedRow();
		Statechart selectedStatechart = statecharts.get(row);
		
		if(selectedStatechart != null)
		{
			IRPStatechart irpStatechart = selectedStatechart.getIrpStatechart();
			IRPStatechartDiagram irpStatechartDiagram = irpStatechart.getStatechartDiagram();	
			irpStatechart.locateInBrowser();
			irpStatechartDiagram.openDiagram();
			runAntiPattern(selectedStatechart, AntiPatternBase.RunOption.RUN_REFRESH);
			runAntiPattern(selectedStatechart, AntiPatternBase.RunOption.RUN_HIGHLIGHT);
		}
	}
	
	public void buttonRepairPressed(ActionEvent e)
	{
		int row = table.getSelectedRow();
		Statechart selectedStatechart = statecharts.get(row);
		
		if(selectedStatechart != null)
		{
			runAntiPattern(selectedStatechart, AntiPatternBase.RunOption.RUN_REPAIR);
		}
	}
	
	/* Logging functions */
	public void print()
	{
		System.out.printf("%-60s:   #N   #S   #C   #T(  #E:  #I) | 1 2 3 4 5 6 7 | %-10s\n", "[Name]", "Complexity");
	}
	
	public void printStatistics()
	{
		System.out.printf("\n[Total number of processed elements]\n");
		System.out.printf("#SM:%d\n", statechartCount);
		System.out.printf("#N:%d\n", nodeCount);
		System.out.printf("#S:%d\n", stateCount);
		System.out.printf("#C:%d\n", conditionCount);
		System.out.printf("#T:%d\n", transitionCount);
		
		System.out.printf("\n%-30s %4s %4s %4s\n", "[AntiPattern Hits]", "#SM", "#S", "#T");
		
		Iterator<AntiPatternBase> iter = antiPatterns.iterator();
		
		while(iter.hasNext())
		{
			AntiPatternBase antiPattern = iter.next();
			antiPattern.printStatistics();
		}	
	}
}
