package edu.hm.cs.modsim.studienarbeit2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Statistische Daten:
		
		// Clock wenn ein Kunde sich anstellt/Schlange verlässt + derzeitige
		// Schlangenlänge
		List<List<Double>> mqs = new ArrayList<List<Double>>();
		// Clock wenn Kunde Shop betritt/Shop verlässt + derzeitige Anzahl von
		// Kunden in Shop
		List<List<Double>> mcs = new ArrayList<List<Double>>();
		//Wartezeit der Clients in Schlange
		List<Double> mwt = new ArrayList<Double>();
		//Verweilzeiten der Kunden im Shop
		List<Double> timeOfClientInShop = new ArrayList<Double>();
		double serverBusyTime;
		
		int simTime = 4800;
		// SimSetup mit Parameter : Simulationsdauer , maximale
		// Warteschlangenlï¿½nge
		Scheduler s = new Scheduler(simTime, 10);
		s.run();
		mqs = s.getStatisticDataCollector().getMeanQueue();
		mcs = s.getStatisticDataCollector().getMeanClientsInSystem();
		mwt = s.getStatisticDataCollector().getMeanWaitingTimes();
		timeOfClientInShop = s.getStatisticDataCollector().getListTimeOfClientInShop();
		serverBusyTime = (s.getStatisticDataCollector().getServerBusyTime())/(simTime*3600);
		
		//Writer 
		String outputMQS = "";
		
		// iterate via "iterator loop"
		System.out.println("\n==> Clock, Warteschlangenlänge");
		Iterator<List<Double>> mqsIterator = mqs.iterator();
		while (mqsIterator.hasNext()) {
//			System.out.println(mqsIterator.next());
			outputMQS += mqsIterator.next();
			outputMQS += ",";
		}
		System.out.println(outputMQS);
		
		System.out.println("\n==> Clock, Anzahl Clients im System");
		Iterator<List<Double>> mcsIterator = mcs.iterator();
		while (mcsIterator.hasNext()) {
			System.out.println(mcsIterator.next());
		}
		
		System.out.println("\n==> Wartezeit i-ter Client in Schlange");
		Iterator<Double>mwtIterator =mwt.iterator();
		while (mwtIterator.hasNext()) {
			System.out.println(mwtIterator.next());
		}
		
		System.out.println("\n==> Verweildauer der Kunden im Shop");
		Iterator<Double>tocisIterator =timeOfClientInShop.iterator();
		while (tocisIterator.hasNext()) {
			System.out.println(tocisIterator.next());
		}
		
		System.out.println("\n==> Zeit in der Server besetzt ist");
		System.out.println(serverBusyTime);

		

//		 OutputWriter ow = new OutputWriter("MeanQueueSize");
//		 ow.writeOutputToFile(outputMQS);
//		
	}

	private static double interArrivalTime() {
		double lambda = 1000;
		double u = Math.random();
		return Math.log(1 - u) / (-1) * lambda;
	}

	private static String interArrivalsToString() {
		String out = "";
		for (int i = 0; i < 999; i++) {
			out += interArrivalTime();
			out += ",";
		}
		out += interArrivalTime();

		return out;
	}
}

