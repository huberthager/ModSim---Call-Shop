package test.hm.cs.modsim.studienarbeit2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import edu.hm.cs.modsim.studienarbeit2.*;


public class EventListTest {
	
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
	//Test EventList
	@Test
	public void testEventList(){
		assertTrue(eventList.isEmpty());
		
		
		Event a = new Arrival(5);
		eventList.addEvent(a);
		assertFalse(eventList.isEmpty());
		assertEquals(a,eventList.getFirst());
		
		Event s = new ServingStart(0);
		eventList.addEvent(s);
		assertEquals(a,eventList.getFirst());
		eventList.sortEventList();
		assertEquals(s,eventList.getFirst());
		eventList.removeFirst();
		assertEquals(a,eventList.getFirst());
		
		
	}


}
