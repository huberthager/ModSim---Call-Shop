package edu.hm.cs.modsim.studienarbeit2;

import java.util.*;

/**
 * @author jules
 *
 */

public class Scheduler {
	
	private int modelTime;
	private int nextArrival;
	Queue q;
	Server s;
	Client c;
	Client d;
	Client e;
	LinkedList<Integer> arrivals = new LinkedList<Integer>();

	public Scheduler(int modelTime){
		this.modelTime = modelTime;
		this.q = new Queue(10);
		this.s = new Server();
		c = createNewClient();
		for(int i = 0;i<10;i++){
			arrivals.add(5);
		}

		addToQueue(c);

		nextArrival = 15;
	}
	
	/** Generates a new Client Object and sets its serving time 
	 *  (aka the time the Client will talk on the phone)
	 * 
	 * @param none
	 * @return new Client with a certain ArrivingTime
	 */
	private Client createNewClient(){
		return new Client(generateServingTime());
	}
	
	/**
	 * @param c
	 */
	private void addToQueue(Client c){
		q.add(c);
	}
	/**
	 * @param c
	 */
	private void moveToServer(Client c){
		s.setActiveClient(c);
	}
	

	public void step(){
		Client c = q.getNextClient();
		int servingTime = c.getServingTime();
		moveToServer(c);
		s.processClient(q);
		this.modelTime = modelTime - servingTime;
		if(timeForNextArrival(servingTime)){
			adjustArrivals(servingTime);
			for(int i = 0;i<3;i++){
				arrivals.addLast(generateNextArrivalTime());
			}
			
		}
		else {
			nextArrival = nextArrival - servingTime;
			System.out.println("no client added: time until next client arrives: " + nextArrival);
		}
		System.out.println("\n the remaining simulation time is " + modelTime+
						   "\nthe queue size is: " + q.getSize()+ "\n\n");
		
	}
	
	/**method checks if the servingTime of the current activeClient is longer than the
	 * arrival time of the next Client therefore indicating if a new Client arrives while the 
	 * current active Client is being served.
	 * @param waitingTime
	 * @return true if waitingTime is longer false otherwise
	 */
	private boolean timeForNextArrival(int servingTime) {
		if (servingTime >= nextArrival) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void adjustArrivals(int servingTime){
		while(servingTime - arrivals.getFirst() > 0){
			addToQueue(createNewClient());
			arrivals.poll();
			servingTime = servingTime-arrivals.getFirst();
		}
		int nextArrival = arrivals.poll();
		nextArrival = nextArrival-servingTime;
		arrivals.offerFirst(nextArrival);
		
	}

	/**
	 * @return
	 */
	public int generateServingTime(){
		return 15; 
	}
	
	public int generateNextArrivalTime(){
		return 5;
	}

	// diverse Statistiken


}
