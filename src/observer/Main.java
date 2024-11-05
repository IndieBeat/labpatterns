package observer;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Covid19Pacient p1=new Covid19Pacient("aitor", 35);
		new PacientObserverGUI (p1);
		new PacientSymptomGUI (p1);
		new PacientThermometerGUI(p1);
		Covid19Pacient p2=new Covid19Pacient("ramon", 28);
		new PacientObserverGUI (p2);
		new PacientSymptomGUI (p2);
		new PacientThermometerGUI(p2);
	}


}
