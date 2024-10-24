package domain;

import java.util.ArrayList;

public class DigestiveSymptom extends Symptom{
	private static DigestiveSymptom ds;

	private DigestiveSymptom(String name, int covidImpact, int severityIndex) {
		super(name, covidImpact, severityIndex);
	}
	
	public static DigestiveSymptom getInstance(String symptomName, int index, int impact) {
		if(ds==null)
			ds=new DigestiveSymptom(symptomName, index, impact);
		
		return ds;
	}

}
