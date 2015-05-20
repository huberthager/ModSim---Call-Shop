package edu.hm.cs.modsim.studienarbeit2;

public class ServingStart extends Event {

	
	
	public ServingStart(double clock) {
		eventTime=clock;
	}

	@Override
	public void processEvent(Queue queue, Server server, EventList eventList, double clock, StatisticDataCollector sdc) {
		double eventTimeOfServiceStop = clock + serviceTime();
		eventList.addEvent(new ServingStop(eventTimeOfServiceStop));
		server.setOccupied(true);
		sdc.addBusyTime(eventTimeOfServiceStop - clock);
	}
	
	public double serviceTime() {
		double lambda = 100;
		double u = Math.random();
		return Math.log(1-u)/(-1)*lambda;
	}

}
