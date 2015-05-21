package test.hm.cs.modsim.studienarbeit2;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.hm.cs.modsim.studienarbeit2.Arrival;
import edu.hm.cs.modsim.studienarbeit2.Client;
import edu.hm.cs.modsim.studienarbeit2.EventList;
import edu.hm.cs.modsim.studienarbeit2.Queue;
import edu.hm.cs.modsim.studienarbeit2.Server;
import edu.hm.cs.modsim.studienarbeit2.StatisticDataCollector;

public class QueueTest {
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

	@After
	public void tearDown() throws Exception {
	}
	//test Queue class
	@Test
	public void testQueue() {
		c = new Client(0);
		queue = new Queue(MAXSIZE);
		//test addClient()
		queue.addClient(c);
		assertEquals(new Integer(1),queue.size(),1);
		
		//test removeClient() and size()
		Client c2 = queue.removeClient();
		assertEquals(c,c2);
		assertTrue(queue.size() == 0);
	}
	

}
