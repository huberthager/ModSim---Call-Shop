package edu.hm.cs.modsim.studienarbeit2;

public class Main {

  public static void main(String[] args) {
    //SimSetup mit Parameter : Simulationsdauer , maximale Warteschlangenlänge
	  Scheduler s = new Scheduler(10,100);
	  s.run();
	  
	  
	  

  }
}
