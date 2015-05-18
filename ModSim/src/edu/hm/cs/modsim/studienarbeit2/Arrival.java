package edu.hm.cs.modsim.studienarbeit2;

public class Arrival extends Event {
	
	public Arrival(double clock) {
		eventTime = clock + interArrivalTime();
	}

	@Override
	
	public void processEvent(Queue queue, Server server, EventList eventList, double clock) {
		if(server.isOccupied()) {
			queue.addClient(new Client());
		} else {
			eventList.addEvent(new ServingStart(clock));
		}
	}
	
	// private helper method for constructor
	private double interArrivalTime() {
		double lambda = 1;
		double u = Math.random();
		return Math.log(1-u)/(-1)*lambda;
	}
	
	
	
	
	

}
