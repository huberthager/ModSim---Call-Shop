package edu.hm.cs.modsim.studienarbeit2;

public class Client {
	
	private int waitingTime;
	private  int servingTime;
	
	public Client(int servingTime){
		this.servingTime = servingTime;
	}
	
	public void setWaitingTime(int waitingTime){
		this.waitingTime = waitingTime;
	}
	
	public int getWaitingTime(){
		return waitingTime;
	}
	
	public void setServingTime(int remainingTime){
		this.servingTime = remainingTime;
	}
	
	public int getServingTime(){
		return servingTime;
	}
	
	public void waitOneSec(){
		waitingTime++;
	}

}
