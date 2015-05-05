package edu.hm.cs.modsim.studienarbeit2;

public class EventList {

	PriorityQueue<Events> eventList;

	public EventList(PriorityQueue<Clients> eventList) {
		this.eventList = eventList;
	}

	public void addEvent(Event e){
		eventList.add(e);
	}

}
