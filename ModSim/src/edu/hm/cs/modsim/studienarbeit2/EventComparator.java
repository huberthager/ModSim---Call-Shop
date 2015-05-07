package edu.hm.cs.modsim.studienarbeit2;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

  @Override
  public int compare(Event e1, Event e2) {
    return e1.getEventSimTime() < e2.getEventSimTime() ? -1 : e1
        .getEventSimTime() == e2.getEventSimTime() ? 0 : 1;
  }

}
