package edu.hm.cs.modsim.studienarbeit2;

public class Arrival extends AbstractEvent{

	int timeUntilNextEvent;

	public AbstractEvent(int timeUntilNextEvent){
		super(timeUntilNextEvent);
	}
}


