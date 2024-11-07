package adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Covid19Pacient;
import domain.Symptom;

public class InvertedIteratorImplementation extends Covid19Pacient implements InvertedIterator {
	private int index;
	
	public InvertedIteratorImplementation(String name, int years) {
		super(name, years);
		this.index=this.getSymptoms().size()-1;
	}
	
	@Override
	public Object previous() {
	  	List<Symptom> o = new ArrayList<Symptom>(this.getSymptoms());
	  	Symptom s=o.get(index);
	  	index--;
	  	return s;
	}

	@Override
	public boolean hasPrevious() {
		return this.index>=0;
	}

	@Override
	public void goLast() {
		this.index=this.getSymptoms().size()-1;
	}
}
