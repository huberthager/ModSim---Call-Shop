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
import edu.hm.cs.modsim.studienarbeit2.StatisticDataCollector;

public class ClientTest {

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
	//test the Client class
	@Test
	public void testClient() {
		c = new Client(0);
		assertEquals(0,c.getInQueueTime(),0);
	}
}
