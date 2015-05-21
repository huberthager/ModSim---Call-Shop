package test.hm.cs.modsim.studienarbeit2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.hm.cs.modsim.studienarbeit2.Arrival;
import edu.hm.cs.modsim.studienarbeit2.Client;
import edu.hm.cs.modsim.studienarbeit2.EventList;
import edu.hm.cs.modsim.studienarbeit2.Queue;
import edu.hm.cs.modsim.studienarbeit2.Server;
import edu.hm.cs.modsim.studienarbeit2.ServingStart;
import edu.hm.cs.modsim.studienarbeit2.ServingStop;
import edu.hm.cs.modsim.studienarbeit2.StatisticDataCollector;

public class EventsTest {


	static final double EVENT_TIME = 10;
	static final int MAXSIZE = 10;
	
	Arrival arrival;
	Queue queue;
	Server server;
	EventList eventList;
	Client c;
	StatisticDataCollector sdc;
	
	@Before
	public void setUp() throws Exception {
		arrival = new Arrival(EVENT_TIME);
		queue = new Queue(MAXSIZE);
		server = new Server();
		eventList = new EventList();
		sdc = new StatisticDataCollector();
	}

	
	//test events. first arrival
	@Test
	public void testArrival() {
		
		//test processEvent in Arrival
		assertEquals(0,queue.size());
		assertTrue(eventList.isEmpty());
		//case 1: server is not occupied
		arrival.processEvent(queue,server,eventList,EVENT_TIME,sdc);
		assertFalse(eventList.isEmpty());
		
		//Case 2: server is occupied
		server.setOccupied(true);
		arrival.processEvent(queue,server,eventList,EVENT_TIME,sdc);
		assertFalse(new Integer(queue.size()).equals(0));
	}
	
	//second servingStart7
	@Test
	public void testServingStart(){
		ServingStart e = new ServingStart(EVENT_TIME);
		queue = new Queue(MAXSIZE);
		server.setOccupied(false);
		eventList = new EventList();
		
		assertTrue(eventList.isEmpty());
		assertFalse(server.isOccupied());
		e.processEvent(queue, server, eventList, EVENT_TIME,sdc);
		assertFalse(eventList.isEmpty());
		assertTrue(server.isOccupied());
		
		
	}
	//third servingStop
	@Test
	public void testServingStop() {
		ServingStop e = new ServingStop(EVENT_TIME);
		queue = new Queue(MAXSIZE);
		server.setOccupied(false);
		eventList = new EventList();
		
		queue.addClient(new Client(0));
		assertEquals(1,queue.size(),0);
		assertTrue(eventList.isEmpty());
		e.processEvent(queue,server,eventList,EVENT_TIME,sdc);
		assertEquals(0,queue.size(),0);
		assertFalse(eventList.isEmpty());
		
	}
	
}
