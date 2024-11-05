package factory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.DigestiveSymptom;
import domain.NeuroMuscularSymptom;
import domain.RespiratorySymptom;
import domain.Symptom;

public class SymptomFactory {
	public Map<Symptom, Integer> symptoms = new HashMap<Symptom, Integer>();
	
	public static Symptom getDigestiveSymptom(String symptomName,int index, int impact) {
		return DigestiveSymptom.getInstance(symptomName, index, impact);
	}
	
	public static Symptom getNeuroMuscularSymptom(String symptomName,int index, int impact) {
		return NeuroMuscularSymptom.getInstance(symptomName, index, impact);
	}
	
	public static Symptom getRespiratorySymptom(String symptomName,int index, int impact) {
		return RespiratorySymptom.getInstance(symptomName, index, impact);
	}
	
	public static Symptom createSymptom(String symptomName) {
		List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia", "expectoracion");
		List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);
		List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea", "mialgia", "escalofrios");
		List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);
		List<String> impact1 = Arrays.asList("nauseas", "vómitos", "congestión nasal", "diarrea", "hemoptisis",
				"congestion conjuntival", "mareos");
		List<Double> index1 = Arrays.asList(5.0, 4.8, 3.7, 0.9, 0.8, 3.3, 4.6);

		List<String> digestiveSymptom = Arrays.asList("nauseas", "vómitos", "diarrea");
		List<String> neuroMuscularSymptom = Arrays.asList("fiebre", "astenia", "cefalea", "mialgia", "escalofrios", "mareos");
		List<String> respiratorySymptom = Arrays.asList("tos seca", "expectoracion", "disnea", "dolor de garganta",
				"congestión nasal", "hemoptisis", "congestion conjuntival");

		int impact = 0;
		double index = 0;
		if (impact5.contains(symptomName)) {
			impact = 5;
			index = index5.get(impact5.indexOf(symptomName));
		} else if (impact3.contains(symptomName)) {
			impact = 3;
			index = index3.get(impact3.indexOf(symptomName));
		} else if (impact1.contains(symptomName)) {
			impact = 1;
			index = index1.get(impact1.indexOf(symptomName));
		}

		if (impact != 0) {
			if (digestiveSymptom.contains(symptomName))
				return getDigestiveSymptom(symptomName, (int) index, impact);
			if (neuroMuscularSymptom.contains(symptomName))
				return getNeuroMuscularSymptom(symptomName, (int) index, impact);
			if (respiratorySymptom.contains(symptomName))
				return getRespiratorySymptom(symptomName, (int) index, impact);
		}
		//En vez de crear objeto y permitir duplicados usamos singleton y hacemos getInstance() y si aun no existe se crea.
		return null;
	}
}
