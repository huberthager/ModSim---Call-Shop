package edu.hm.cs.modsim.studienarbeit2;


public class Scheduler {
	private EventList eventList;
	private int simTime;
	


	private int endSimTime;

	public Scheduler(int endSimTime) {
		this.simTime = 0;
		this.endSimTime = endSimTime;
		
	}

	/* Methode die die eig simulaton durchfuehrt */
	public void run() {
		// while(EventList.size()!=0 & simTime<endSimTime)
		// hole dir das event mit der kleinesten Zeit
		// erhoehe die Zeit simeTime um die eventTime
		// fuehre das event aus
		// loesche das event aus der eventListe

	}
	
	public int getSimTime() {
		return simTime;
	}
}
