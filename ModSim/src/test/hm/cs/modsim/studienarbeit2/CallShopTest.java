package test.hm.cs.modsim.studienarbeit2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.hm.cs.modsim.studienarbeit2.*;


public class CallShopTest {
	
	static final double EVENT_TIME = 10;
	static final int MAXSIZE = 10;
	
	Arrival arrival;
	Queue queue;
	Server server;
	EventList eventList;
	Client c;

	@Before
	public void setUp() throws Exception {
		arrival = new Arrival(EVENT_TIME);
		queue = new Queue(MAXSIZE);
		server = new Server();
		eventList = new EventList();
		c = new Client();
	}

	@After
	public void tearDown() throws Exception {
	}

	//test the Client class
	public void testClient() {
		

		assertEquals(0,c.getWaitingTime(),0);
		
		c.addWaitingTime(5);
		assertEquals(5,c.getWaitingTime(),0);
		
	}
	//test EventList class
	public void testEventList() {
		
		//test isEmpty()
		eventList = new EventList();
		Event e = new Arrival(EVENT_TIME);
		assertTrue(eventList.isEmpty());
		eventList.addEvent(e);
		assertFalse(eventList.isEmpty());
		
		//test sortEventList(and with it eventComparator)
		for(int i = 10;i>0;i--){
			eventList.addEvent(new Arrival(i));
		}
		//test getFirst()
		assertEquals(10,eventList.getFirst().getEventTime(),0);
		eventList.sortEventList();
		assertEquals(1,eventList.getFirst().getEventTime(),0);
		//test removeFirst()
		eventList.removeFirst();
		assertEquals(2,eventList.getFirst().getEventTime(),0);
		
	}
	//test Queue class
	public void testQueue() {
		c = new Client();
		queue = new Queue(MAXSIZE);
		//test addClient()
		queue.addClient(c);
		assertEquals(new Integer(0),not(queue.size()));
		
		//test removeClient() and size()
		Client c2 = queue.removeClient();
		assertEquals(c,c2);
		assertTrue(queue.size() == 0);
	}
	
	//test Server
	public void testServer() {
		
		//test setOccupied()
		assertFalse(server.isOccupied());
		server.setOccupied(true);
		assertTrue(server.isOccupied());
	}

	//testing of Events. first arrival
	@Test
	public void testArrival() {
		
		//test processEvent in Arrival
		assertEquals(0,queue.size());
		assertTrue(eventList.isEmpty());
		//case 1: server is not occupied
		arrival.processEvent(queue,server,eventList,EVENT_TIME);
		assertFalse(eventList.isEmpty());
		
		//Case 2: server is occupied
		server.setOccupied(true);
		arrival.processEvent(queue,server,eventList,EVENT_TIME);
		assertFalse(new Integer(queue.size()).equals(0));
	}
	//second servingStart
	public void testServingStart(){
		ServingStart e = new ServingStart(EVENT_TIME);
		queue = new Queue(MAXSIZE);
		server.setOccupied(false);
		eventList = new EventList();
		
		assertTrue(eventList.isEmpty());
		assertFalse(server.isOccupied());
		e.processEvent(queue, server, eventList, EVENT_TIME);
		assertFalse(eventList.isEmpty());
		assertTrue(server.isOccupied());
		
		
	}
	//third servingStop
	public void testServingStop() {
		ServingStop e = new ServingStop(EVENT_TIME);
		queue = new Queue(MAXSIZE);
		server.setOccupied(false);
		eventList = new EventList();
		
		queue.addClient(new Client());
		assertEquals(1,queue.size(),0);
		assertTrue(eventList.isEmpty());
		e.processEvent(queue,server,eventList,EVENT_TIME);
		assertEquals(0,queue.size(),0);
		assertFalse(eventList.isEmpty());
		
	}
	//test Scheduler
	public void testScheduler() {
		//test getSimTime()
		Scheduler sched = new Scheduler(100, 10);
		assertEquals(0,sched.getSimTime(),0);
	}
}


