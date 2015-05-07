package edu.hm.cs.modsim.studienarbeit2;

import java.util.LinkedList;
import java.util.List;

public class EventList {
	
	private List<Event> eventList = new LinkedList<Event>();
	
	public EventList() {
		
	}
	
	public void addEvent(Event e) {
		this.eventList.add(e);
	}
	
	public void removeEvent() {
		
	}
	
}
