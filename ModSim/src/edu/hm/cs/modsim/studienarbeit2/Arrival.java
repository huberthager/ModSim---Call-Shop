package edu.hm.cs.modsim.studienarbeit2;

public class Arrival extends Event {
	
	
	
	public Arrival(double clock) {
		eventTime = clock + interArrivalTime();
	}

	@Override
	
	public void processEvent(Queue queue, Server server, EventList eventList, double clock, StatisticDataCollector sdc) {
		if(server.isOccupied()) {
			queue.addClient(new Client(eventTime));
			sdc.addQueueEntry(eventTime, queue.size());
			sdc.addClientSystem(eventTime, queue.size()+1); //am server steht einer
			
		} else {
			eventList.addEvent(new ServingStart(clock));
			sdc.addClientSystem(eventTime, 1); //Kunde kommt in leeres System
		}
	}
	
	// private helper method for constructor
	private double interArrivalTime() {
		double lambda = 1000;
		double u = Math.random();
		return Math.log(1-u)/(-1)*lambda;
	}
	
	
	
	
	

}
