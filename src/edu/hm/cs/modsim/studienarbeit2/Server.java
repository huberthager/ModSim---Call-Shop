package edu.hm.cs.modsim.studienarbeit2;
import java.util.*;

public class Server {
	
	private Client activeClient;
	
	public Server(){

	}
	
	public int servingTime(){
		return activeClient.getServingTime();
	}
	
	public boolean isBusy(){
		return activeClient != null;
	}
	
	public void setActiveClient(Client c){
		activeClient = c;
	}
	
	public void removeClientFromSystem(){
		activeClient = null;
	}
	
	public void processClient(Queue q){
		int waitingTime = activeClient.getServingTime();
		q.incrementWaitingTime(waitingTime);
		removeClientFromSystem();
	}
	
	

}
