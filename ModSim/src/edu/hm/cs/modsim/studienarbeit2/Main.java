package edu.hm.cs.modsim.studienarbeit2;

public class Main {

  public static void main(String[] args) {

    Client cl = new Client();

    Queue queue = new Queue(2);
    System.out.println(queue.size());
    queue.addClient(cl);
    queue.addClient(new Client());
    System.out.println(queue.addClient(new Client()));
    System.out.println(queue.size());

  }
}
