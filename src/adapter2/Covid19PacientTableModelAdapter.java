package adapter2;

import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
	protected Covid19Pacient pacient;
	protected String[] columnNames = new String[] { "Symptom", "Weight" };

	public Covid19PacientTableModelAdapter(Covid19Pacient p) {
		this.pacient = p;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int i) {
		if (i >= 0 && i < columnNames.length) {
			return columnNames[i];
		}
		return "";
	}

	public int getRowCount() {
		return pacient.getSymptoms().size();
	}

	public Object getValueAt(int row, int col) {
		Symptom symptom = null;
		Iterator<Symptom> it=pacient.getSymptoms().iterator();
		
		for (int i = 0; i <= row && it.hasNext(); i++) {
			symptom = it.next();
		}
		
		if(symptom != null) {			
			if (col == 0) {
				return symptom.getName();
			} else if (col == 1) {
				return pacient.getWeight(symptom);
			}
		}

		return null;
	}
}
