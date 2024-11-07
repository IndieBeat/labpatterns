package adapter2;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.TableModel;

import domain.Covid19Pacient;
import domain.Symptom;


public class ShowPacientTableGUI extends JFrame{
	
	JTable table;
	Covid19Pacient pacient;
	
  
  public ShowPacientTableGUI(Covid19Pacient pacient ) {
	  	this.setTitle("Covid Symptoms "+pacient.getName());
	  	
	  	this.pacient=pacient;
	  	
	  	setFonts();
	    
	  	Set<Symptom> s=pacient.getSymptoms();
	  	List<Symptom> it=new ArrayList<Symptom>(s);
	  	System.out.println("S: "+ it);
		
		System.out.println("Syntoms: "+ it.size());
		for (Symptom ss:it) {
			System.out.println("Syntoms: "+ss.getName());
		}
	  	
	  	TableModel tm=new Covid19PacientTableModelAdapter(pacient);
		table = new JTable(tm);
	    table.setRowHeight(36);
	    JScrollPane pane = new JScrollPane(table);
	    pane.setPreferredSize(new Dimension(300, 200));
	    this.getContentPane().add(pane);
	    
	    this.pack();
	    table.revalidate();
	    table.repaint();
  }

  private static void setFonts() {
    Font font = new Font("Dialog", Font.PLAIN, 18);
    UIManager.put("Table.font", font);
    UIManager.put("TableHeader.font", font);
  }
}
