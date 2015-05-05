package edu.hm.cs.modsim.studienarbeit2;

import java.util.LinkedList;

public class Queue {

  private LinkedList<Client> clientList;
  private int maxSize;

  public Queue(int maxSize) {
    clientList = new LinkedList<>();
    this.maxSize = maxSize;
  }

  public boolean addClient(Client client) {
    if (clientList.size() < maxSize) {
      clientList.add(client);
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
