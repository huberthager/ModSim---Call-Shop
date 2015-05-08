package edu.hm.cs.modsim.studienarbeit2;

public class Main {

  public static void main(String[] args) {
    Scheduler sched = new Scheduler(1000);
    
    for(int i = 0; i<10;i++){
    	sched.step();
    }
  }
}
