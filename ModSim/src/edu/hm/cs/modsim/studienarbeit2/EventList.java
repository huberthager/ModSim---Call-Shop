package edu.hm.cs.modsim.studienarbeit2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EventList {

  private List<Event> eventList;

  public EventList() {
    eventList = new LinkedList<>();
  }

  public void addEvent(Event e) {
    this.eventList.add(e);
  }

  public void removeFirst() {
    this.eventList.remove(0);
  }

  public void sortEventList() {
    Collections.sort(eventList, new EventComparator());
  }

  public boolean isEmpty() {
    return eventList.size() == 0;
  }

  public Event getFirst() {
    return eventList.get(0);
  }

  public String toString() {
    String out = "";
    for (Event e : eventList) {
      out += " " + e.toString();
    }
    return out;
  }
}
