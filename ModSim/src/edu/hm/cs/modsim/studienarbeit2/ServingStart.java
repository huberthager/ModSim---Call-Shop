package edu.hm.cs.modsim.studienarbeit2;

public class ServingStart extends Event {

	
	
	public ServingStart(double clock) {
		eventTime=clock;
	}

	@Override
	void processEvent(Queue queue, Server server, EventList eventList, double clock) {
		eventList.addEvent(new ServingStop(clock + serviceTime()));
		server.setOccupied(true);
	}
	
	public double serviceTime() {
		return 3.0;
	}


}
