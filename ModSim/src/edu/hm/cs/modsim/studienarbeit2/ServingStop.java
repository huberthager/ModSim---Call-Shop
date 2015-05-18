package edu.hm.cs.modsim.studienarbeit2;

public class ServingStop extends Event {

	public ServingStop(double eventTime) {
		this.eventTime = eventTime;
	}

	@Override
	public void processEvent(Queue queue, Server server, EventList eventList, double clock) {
		if(!(queue.size() == 0)) {
			eventList.addEvent(new ServingStart(clock));
			
			queue.removeClient();
		} else {
			server.setOccupied(false);
		}
	}

}
