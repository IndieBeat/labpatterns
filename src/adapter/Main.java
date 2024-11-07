package adapter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import domain.Covid19Pacient;
import domain.Symptom;

public class Main {
	public static void main(String[] args) {
		InvertedIterator inv = new InvertedIteratorImplementation("Aitor", 24);

		((Covid19Pacient) inv).addSymptomByName("tos seca", 2);
		((Covid19Pacient) inv).addSymptomByName("fiebre", 1);
		((Covid19Pacient) inv).addSymptomByName("astenia", 3);
		((Covid19Pacient) inv).addSymptomByName("nauseas", 1);
		((Covid19Pacient) inv).addSymptomByName("congestion conjuntival", 2);
		((Covid19Pacient) inv).addSymptomByName("expectoracion", 3);

		Map<Symptom, Integer> map = new HashMap<Symptom, Integer>();
		System.out.println("Sintomas sin ordenar");
		for (Symptom s : ((Covid19Pacient) inv).getSymptoms()) {
			System.out.println(s.getName());
			map.put(s, s.getSeverityIndex());
		}

		System.out.println("/-------------/");
		System.out.println("Sintomas ordenados por nombre");
		Comparator<Object> comp1 = new NameComparator();
		Iterator it = Sorting.sortedIterator(inv, comp1);
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("/-------------/");
		System.out.println("Sintomas ordenados por severity");
		Comparator<Object> comp2 = new SeverityComparator();
		it = Sorting.sortedIterator(inv, comp2);
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
