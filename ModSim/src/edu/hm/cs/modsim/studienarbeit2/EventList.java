package edu.hm.cs.modsim.studienarbeit2;

import java.util.*

public class EventList {

	List<AbstractEvent> list;

	public EventList(){
		this.list = new ArrayList<>();
	}

	public void addEvent(Event e){
		list.add(e);
	}



}
