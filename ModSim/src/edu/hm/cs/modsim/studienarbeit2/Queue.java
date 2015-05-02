package edu.hm.cs.modsim.studienarbeit2;
import java.util.LinkedList;



public class Queue<Client> {
	
	private LinkedList<Client> myList;
	
	public Queue() {
		myList = new LinkedList<>();
	}
	
	public void pushFront(Client client) {
		myList.add(client);
	}
	
	public Client front() {
		return myList.peekFirst();
	}
	
}
