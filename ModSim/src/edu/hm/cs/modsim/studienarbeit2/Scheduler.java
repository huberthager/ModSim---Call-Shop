package edu.hm.cs.modsim.studienarbeit2;




public class Scheduler {
	private EventList eventList;
	private double clock;
	private Queue queue;
	private Server server;
	private double endSimTime;

	public Scheduler(double endSimTime, int maxSize) {
		this.clock = 0;
		this.endSimTime = endSimTime;
		queue = new Queue(maxSize);
		server = new Server();
		eventList = new EventList();
		Event arrivalEvent;
		double initClock=0.0;
		do{
			arrivalEvent=new Arrival(initClock);
			eventList.addEvent(arrivalEvent);
			initClock=arrivalEvent.getEventTime();
		}while(arrivalEvent.getEventTime()<endSimTime);
	}

	/* Methode die die eig simulaton durchfuehrt */
	public void run() {
		Event currentEvent;
		
		// while(EventList.size()!=0 & simTime<endSimTime)
		while(!eventList.isEmpty()&&clock < endSimTime) {
			System.out.println(eventList.toString());
			currentEvent = eventList.getFirst();
			clock = currentEvent.getEventTime();// hole dir das event mit der kleinesten Zeit
			currentEvent.processEvent(queue,server,eventList,clock);
			eventList.removeFirst();
			eventList.sortEventList();
			
		}
		
		// fuehre das event aus
		// loesche das event aus der eventListe

	}
	
	public double getSimTime() {
		return clock;
	}
	

}
