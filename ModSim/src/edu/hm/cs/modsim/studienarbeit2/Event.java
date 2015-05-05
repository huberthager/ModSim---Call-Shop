package edu.hm.cs.modsim.studienarbeit2;

//ABC fuer alle events
abstract class Event {

  abstract int eventTime(); // Schnittstelle fuer die Zeiten des jeweiligen
                            // events

  abstract void processEvent();// veraenderung des Systemzustands

}
