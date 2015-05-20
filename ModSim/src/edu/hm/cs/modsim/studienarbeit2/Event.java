package edu.hm.cs.modsim.studienarbeit2;

//ABC fuer alle events
public abstract class Event {
	

//	protected double processTime;
//	protected double arrivalTime; // Simulations-Zeitpunkt wann Kunde ankommt
	protected double eventTime;
	
	public double getEventTime() {
		return eventTime;
	}

	abstract void processEvent(Queue queue, Server server, EventList eventList, double simTime, StatisticDataCollector sdc);
	
	
	
	public String toString() {
		return "" + this.eventTime + " "+ this.getClass().getSimpleName();
	}

}
