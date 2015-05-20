package edu.hm.cs.modsim.studienarbeit2;

public class ServingStop extends Event {
	
	private Client currentClient;
	private double waitingTime;
	
	public ServingStop(double eventTime) {
		this.eventTime = eventTime;
	}

	@Override
	public void processEvent(Queue queue, Server server, EventList eventList, double clock, StatisticDataCollector sdc) {
		if(!(queue.size() == 0)) {
			ServingStart ss = new ServingStart(clock);
			eventList.addEvent(ss);
			currentClient = queue.removeClient();
			waitingTime = eventTime - currentClient.getInQueueTime();
			sdc.addMeanWaitingTime(waitingTime);
			sdc.addTimeOfClientInShop(ss.serviceTime());
			sdc.addQueueEntry(eventTime, queue.size());
			sdc.addClientSystem(clock, queue.size()+1);
		} else {
			server.setOccupied(false);
			sdc.addClientSystem(clock, 0);
			
		}
	}

}
