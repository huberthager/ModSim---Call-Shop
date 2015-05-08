package edu.hm.cs.modsim.studienarbeit2;

import java.util.*;

public class Queue {
	
	private int maxSize;
	private LinkedList<Client> queue;

	public Queue(int maxSize) {
		this.setMaxSize(maxSize);
		this.queue = new LinkedList<Client>();
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public int getSize(){
		return queue.size();
	}
	
	public void add(Client c) {
		queue.add(c);
	}
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public boolean isFull(){
		return queue.size() == maxSize;
	}
	
	public Client getNextClient(){
		return queue.poll();
	}
	
	public void incrementWaitingTime(int time) {
		Iterator<Client> it = queue.iterator();
		while(it.hasNext()){
			Client c = it.next();
			c.setWaitingTime(c.getWaitingTime()+time);
			System.out.println("waiting Time for Clients in Queue is: " + c.getWaitingTime());
		}
	}
	

}
