package edu.hm.cs.modsim.studienarbeit2;

public class Scheduler {
  public int simTime;


  EventList eventList;

  public Scheduler(int simTime) {
    this.simTime = simTime;
    eventList = new EventList();
  }

  /** 
    Methode die die eigentliche simulaton durchfuehrt
  - Die evenliste 'unendlich' voll machen mit events beider Art.
  - Dann während der Simulation die Zeiten der einzelnen Event anpassen (Zeit des gerade laufenden Events abziehen)
  - Außerdem Zeit des nächsten Events von der gesamten Simulationszeit abziehen
  - Simulation vorbei wenn simTime = 0
  **/
  
  public void run() {
    // while(EventList.size()!=0 & simTime<endSimTime)
    // hole dir das event mit der kleinesten Zeit
    // erhoehe die Zeit simeTime um die eventTime
    // fuehre das event aus
    // loesche das event aus der eventListe

  }

  private void fillEventList(){
    //fill eventlist with 100 events
    for(int i = 0; i < 100; i++){
      AbstractEvent a = new Arrival(1000);
    }
    eventList.add(a);
  }

  public void adjustSimTime(int time);

}
