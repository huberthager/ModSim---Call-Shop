package edu.hm.cs.modsim.studienarbeit2;

public class Scheduler {
	private EventList eventList;
	private double clock;
	private Queue queue;
	private Server server;
	private double endSimTime;
	private StatisticDataCollector sdc;
	private int inHours = 3600;
	private double TOL=0.01;
	private boolean steadyStateYN;
	private double steadyState;
	
	

	public Scheduler(double endSimTime, int maxSize) {
		endSimTime *= inHours;
		this.steadyStateYN=false;
		this.steadyState=0;
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

	/* Methode die die eig simulaton durchfuehrt */
	public void run() {
		Event currentEvent;

		// while(EventList.size()!=0 & simTime<endSimTime)
//		int iters = 0;
		double lengthQueueBefore = 0;
		while (!eventList.isEmpty() && clock < endSimTime) {
			// System.out.println(eventList.toString());
			currentEvent = eventList.getFirst();
			clock = currentEvent.getEventTime();// hole dir das event mit der
												// kleinesten Zeit
			currentEvent.processEvent(queue, server, eventList, clock, sdc);
			eventList.removeFirst();
			eventList.sortEventList();
			
			
//			double lengthNewQueue = sdc.getQueueLenghtI(iters1);
//			if(steadyStateYN==false){
//				sdc.getQueueLenghtI(iters)
//			}
//			
//			
//			iters++;
		}

		// fuehre das event aus
		// loesche das event aus der eventListe

	}

	public double getSimTime() {
		return clock;
	}
	
	public StatisticDataCollector getStatisticDataCollector() {
		return sdc;
	}

}
