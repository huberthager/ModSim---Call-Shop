package test.hm.cs.modsim.studienarbeit2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.hm.cs.modsim.studienarbeit2.Scheduler;

public class SchedulerTest {

	//test Scheduler
	@Test
	public void testScheduler() {
		//test getSimTime()
		Scheduler sched = new Scheduler(100, 10);
		assertEquals(0,sched.getSimTime(),0);
	}
}
