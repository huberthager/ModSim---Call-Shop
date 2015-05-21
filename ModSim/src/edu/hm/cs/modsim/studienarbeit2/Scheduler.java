/*
@author Hubert Hager
*/
package edu.hm.cs.modsim.studienarbeit2;

public class Scheduler {
	private EventList eventList;
	private double clock;
	private Queue queue;
	private Server server;
	private double endSimTime;
	private StatisticDataCollector sdc;
	private int inHours = 3600;
	
	
	

	public Scheduler(double endSimTime, int maxSize) {
		endSimTime *= inHours;
		
		this.clock = 0;
		this.endSimTime = endSimTime;
		this.sdc = new StatisticDataCollector();
		queue = new Queue(maxSize);
		server = new Server();
		eventList = new EventList();
		Event arrivalEvent;
		double initClock = 0.0;
		do {
			arrivalEvent = new Arrival(initClock);
			eventList.addEvent(arrivalEvent);
			initClock = arrivalEvent.getEventTime();
		} while (arrivalEvent.getEventTime() < endSimTime);
	}

	/* Methode die die eigentliche Simulaton durchfuehrt. Holt sich in einer while - Schleife das 
	 * nächste Event aus unser future event list (eventlist)
	 * */
	public void run() {
		Event currentEvent;

		
		double lengthQueueBefore = 0;
		while (!eventList.isEmpty() && clock < endSimTime) {
			
			currentEvent = eventList.getFirst();
			clock = currentEvent.getEventTime();// hole dir das event mit der
												// kleinesten Zeit
			currentEvent.processEvent(queue, server, eventList, clock, sdc);
			eventList.removeFirst();
			eventList.sortEventList();
			
			
			
					
			
		}

		
	}

	public double getSimTime() {
		return clock;
	}
	
	public StatisticDataCollector getStatisticDataCollector() {
		return sdc;
	}

}
