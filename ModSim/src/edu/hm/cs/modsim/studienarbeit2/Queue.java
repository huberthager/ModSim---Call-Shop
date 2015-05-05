package edu.hm.cs.modsim.studienarbeit2;

import java.util.*;

public class Queue {

  private PriorityQueue<Clients> clientList;
  private int maxSize;

  public Queue(int maxSize) {
    clientQueue = new PriorityQueue<>();
    this.maxSize = maxSize;
  }

  public boolean addClient(Client client) {
    if (clientList.size() < maxSize) {
      clientQueue.add(client);
      return true;

    }
    else {
      return false;
    }
  }

  public Client removeClient() {
    return clientList.pop();
  }

  public int size() {
    return clientList.size();
  }
}
