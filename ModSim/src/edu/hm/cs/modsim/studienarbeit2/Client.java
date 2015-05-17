package edu.hm.cs.modsim.studienarbeit2;

public class Client {
	
	double waitingTime;
	
	public Client(){
		this.waitingTime = 0;
	}

	public void addWaitingTime(double time) {
		this.waitingTime += time;
	}

}
