package edu.hm.cs.modsim.studienarbeit2;

public class Scheduler {
  public int simTime;
  public int endSimTime;

  public Scheduler(int endSimTime) {
    this.simTime = 0;
    this.endSimTime = endSimTime;

  }

  /* Methode die die eig simulaton durchfuehrt */
  public void run() {
    // while(EventList.size()!=0 & simTime<endSimTime)
    // hole dir das event mit der kleinesten Zeit
    // erhoehe die Zeit simeTime um die eventTime
    // fuehre das event aus
    // loesche das event aus der eventListe

  }
  private void addEvent(){
    Event event = new Event(1000);
  }

}
