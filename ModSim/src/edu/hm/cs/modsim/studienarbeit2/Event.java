/*
@author Tobias Höfer, Julian Bauer
*/
package edu.hm.cs.modsim.studienarbeit2;

//ABC fuer alle events
public abstract class Event {
	

//	protected double processTime;
//	protected double arrivalTime; // Simulations-Zeitpunkt wann Kunde ankommt
	protected double eventTime;
	
	/*
	 * Gib die event 
	 */
	public double getEventTime() {
		return eventTime;
	}

	/*Methode processEvent 
	 * 
	 */
	abstract void processEvent(Queue queue, Server server, EventList eventList, double simTime, StatisticDataCollector sdc);
	

}
