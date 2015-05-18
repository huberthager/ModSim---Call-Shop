package edu.hm.cs.modsim.studienarbeit2;

import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    //SimSetup mit Parameter : Simulationsdauer , maximale Warteschlangenl�nge
	  Scheduler s = new Scheduler(12,100);
	  s.run();
	  OutputWriter ow = new OutputWriter("Pfad");//Pfad spezifizieren
	  try {
		ow.writeOutput("Schreibe Output in FIle".toString());
		ow.writeOutput("Ich schreibe erneut in mein OutputFile");
	} catch (IOException e) {
		// 
		e.printStackTrace();
	}
	  
	  

  }
}
