package edu.hm.cs.modsim.studienarbeit2;

public class Main {

  public static void main(String[] args) {
		//Kommentar
	  //tobi war hier
	  //Hubert
    //endtest
	  //neuer Kommentar
	  //comment
		Client cl = new Client();
		cl.printClientMessage();
		
		Queue<Client> myQueue = new Queue<>();
		myQueue.pushFront(cl);
		myQueue.front().printClientMessage();
		
	}
}
