package edu.hm.cs.modsim.studienarbeit2;

public abstract class AbstractEvent implements EventInterface{

	int timeUntilNextEvent;

	public AbstractEvent(int timeUntilNextEvent){
		this.timeUntilNextEvent = timeUntilNextEvent;
	}
}


