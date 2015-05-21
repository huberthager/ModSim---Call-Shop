/*
@author Tobias Höfer
*/
package edu.hm.cs.modsim.studienarbeit2;

import java.util.List;

public class ServingStart extends Event {

	
	
	public ServingStart(double clock) {
		eventTime=clock;
	}

	@Override
	public void processEvent(Queue queue, Server server, EventList eventList, double clock, StatisticDataCollector sdc) {
		double serviceTime = serviceTime();
		eventList.addEvent(new ServingStop(serviceTime + clock));
		server.setOccupied(true);
//		addAllServiceTimes(sdc.getServerBusyTimes(),serviceTime);
		
	}
	
	public double serviceTime() {
		double lambda = 100;
		double u = Math.random();
		return Math.log(1-u)/(-1)*lambda;
	}
	

}
