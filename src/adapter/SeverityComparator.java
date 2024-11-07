package adapter;

import java.util.Comparator;

import domain.Symptom;

public class SeverityComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		return ((Symptom)o1).getSeverityIndex() - ((Symptom)o2).getSeverityIndex();
	}

}
