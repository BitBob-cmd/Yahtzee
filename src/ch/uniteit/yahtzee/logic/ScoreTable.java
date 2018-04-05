package ch.uniteit.yahtzee.logic;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreTable extends JPanel {
	protected JTable table;
	protected JTableHeader tableHeader;

	private ListSelectionModel cellSelectionModel;
	private Rules regeln;

	public ScoreTable(Rules regeln) {
		super(new GridLayout(1, 0));
		this.tableHeader = new JTableHeader();
		this.regeln = regeln;

		TableModel tm = new TableModel();
		this.table = new JTable(tm);
		this.table.setCellSelectionEnabled(true);
		this.cellSelectionModel = table.getSelectionModel();
		this.cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addSelectionListener();

		this.table.setFillsViewportHeight(true);

		// für was isch das??
		// this.table.setSelectionMode(1);

		Dimension td = new Dimension(600, 540);
		this.table.setPreferredSize(td);
		this.table.setRowHeight(30);
		// this.table.setShowGrid(false);

	}

	public void addSelectionListener() {

		this.cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				if(!e.getValueIsAdjusting()) {
					
					
				
				int selectedData = 0;

		        int[] selectedRow = table.getSelectedRows();
		        int[] selectedColumns = table.getSelectedColumns();

		        for (int i = 0; i < selectedRow.length; i++) {
		          for (int j = 0; j < selectedColumns.length; j++) {
		            selectedData = (int) table.getValueAt(selectedRow[i], selectedColumns[j]);
		          }
		        }
		        System.out.println("Selected: " + selectedData);
		      }

			}});
			
	}

	public JTable gibTabelle() {
		if (table != null)
			return table;
		else
			return null;

	}

}
