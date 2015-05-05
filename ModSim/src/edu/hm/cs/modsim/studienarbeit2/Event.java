package edu.hm.cs.modsim.studienarbeit2;

//ABC fuer alle events
abstract class Event {

	int timeUntilNextEvent;
	Client client;

	public Event(int timeUntilNextEvent){
		this.timeUntilNextEvent = timeUntilNextEvent;
	}

  abstract int eventTime(){
  	return 0;
  } // Schnittstelle fuer die Zeiten des jeweiligen
                            // events

  abstract void processEvent();// veraenderung des Systemzustands

}
