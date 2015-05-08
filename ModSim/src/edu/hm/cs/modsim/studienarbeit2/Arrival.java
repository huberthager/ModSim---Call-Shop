package edu.hm.cs.modsim.studienarbeit2;

public class Arrival extends Event {
	
	public Arrival(double clock) {
		eventTime = clock + interArrivalTime();
	}

	@Override
	void processEvent(Queue queue, Server server, EventList eventList, double clock) {
		if(server.isOccupied()) {
			queue.addClient(new Client());
		} else {
			eventList.addEvent(new ServingStart(clock));
		}
	}
	
	public double interArrivalTime() {
		return 2;
	}
	
	
	

}
