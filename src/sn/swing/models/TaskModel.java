package sn.swing.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import sn.swing.entities.Task;

public class TaskModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	public static final int OBJECT_COL = -1;

	private static String [] nomColumns = {
		"Référence", "Description", "Date d'écheance", "Criticité", 
	};
	
	private Vector<Object[]> rows = new Vector<>();
	private List<Task> tasks = new ArrayList<>();
	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return nomColumns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case OBJECT_COL:  return tasks.get(rowIndex);			
		default: return rows.get(rowIndex)[columnIndex];
			
		}
		
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return nomColumns[column];
	}
	
	public void add(Task task) {
		this.tasks.add(task);
		this.rows.add(new Object[] {
				task.getReference(),
				task.getDescription(),
				task.getDateEcheance(),
				task.getCriticite().getName()
		});
		
		// Rafraichir la table suite à une modification
		fireTableDataChanged();
	}
	
	public void LoadTasks(List<Task> tasks) {
		rows.clear();
		this.tasks.clear();
		
		for(Task task : tasks) {
			add(task);
		}
		
		fireTableDataChanged();
		
	}

}