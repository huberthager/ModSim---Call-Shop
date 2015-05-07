package edu.hm.cs.modsim.studienarbeit2;

//ABC fuer alle events
abstract class Event implements Comparable<Event> {

//	protected double processTime;
//	protected double arrivalTime; // Simulations-Zeitpunkt wann Kunde ankommt
	protected double eventTime;

	@Override
	public int compareTo(Event other) {
		return Double.compare(this.eventTime, other.eventTime);
	}

	public double getEventSimTime() {
		return eventTime;
	}

	abstract void processEvent();// veraenderung des Systemzustands

}
