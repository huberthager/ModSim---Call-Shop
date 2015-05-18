package edu.hm.cs.modsim.studienarbeit2;

public class ServingStart extends Event {

	
	
	public ServingStart(double clock) {
		eventTime=clock;
	}

	@Override
	public void processEvent(Queue queue, Server server, EventList eventList, double clock) {
		eventList.addEvent(new ServingStop(clock + serviceTime()));
		server.setOccupied(true);
	}
	
	private double serviceTime() {
		double lambda = 1;
		double u = Math.random();
		return Math.log(1-u)/(-1)*lambda;
	}

}
