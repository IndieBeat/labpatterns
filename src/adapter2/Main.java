package adapter2;

import domain.Covid19Pacient;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient p1 = new Covid19Pacient("aitor", 35);

		p1.addSymptomByName("fiebre", 2);
		p1.addSymptomByName("nauseas", 1);
		p1.addSymptomByName("astenia", 3);

		ShowPacientTableGUI gui = new ShowPacientTableGUI(p1);
		gui.setSize(300, 200);
		gui.setVisible(true);

		Covid19Pacient p2 = new Covid19Pacient("ramon", 35);

		p2.addSymptomByName("tos seca", 1);
		p2.addSymptomByName("mareos", 3);
		p2.addSymptomByName("hemoptisis", 2);

		ShowPacientTableGUI gui2 = new ShowPacientTableGUI(p2);
		gui2.setSize(300, 200);
		gui2.setVisible(true);
	}

}
