package edu.hm.cs.modsim.studienarbeit2;

public abstract class AbstractEvent implements EventInterface{

	int eventTime;

	public AbstractEvent(int timeUntilEvent){
		this.eventTime = timeUntilEvent;
	}

	public int getTime(){
		return timeUntilEvent;
	}
}


