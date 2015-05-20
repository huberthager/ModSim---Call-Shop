package edu.hm.cs.modsim.studienarbeit2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//Modellannahmen 
		int month = 720; // Simulationsdauer in Stunden entspricht 1 Monat
		int quarter = 720*3; //Simulationsdauer in Stunden entspricht ein 4. Jahr
		int queueSize = 20; // Schlangenlänge
		// Statistische Daten:
		
		// Clock wenn ein Kunde sich anstellt/Schlange verlässt + derzeitige
		// Schlangenlänge
		List<Double> queueLengths;
		// Clock wenn Kunde Shop betritt/Shop verlässt + derzeitige Anzahl von
		// Kunden in Shop
		List<Double> numberOfClientsInShop;
		//Wartezeit der Clients in Schlange
		List<Double> mwt = new ArrayList<Double>();
		//Verweilzeiten der Kunden im Shop
		List<Double> timeOfClientInShop = new ArrayList<Double>();
//		double serverBusyTime;
		

		// SimSetup mit Parameter : Simulationsdauer , maximale
		// Warteschlangenlï¿½nge
		Scheduler s = new Scheduler(month, queueSize);
		s.run();
		queueLengths = s.getStatisticDataCollector().getQueueLengths();
		numberOfClientsInShop = s.getStatisticDataCollector().getShopClientState();
		mwt = s.getStatisticDataCollector().getMeanWaitingTimes();
		timeOfClientInShop = s.getStatisticDataCollector().getListTimeOfClientInShop();
//		serverBusyTime = (s.getStatisticDataCollector().getServerBusyTimes())/(simTime*3600);
		
	
		

		
		 OutputWriter ow1 = new OutputWriter("Warteschlangenlänge");
		 ow1.writeOutputToFile(queueLengths.toString());
		

		 OutputWriter ow2 = new OutputWriter("AnzahlKundenShop");
		 ow2.writeOutputToFile(numberOfClientsInShop.toString());
		 
		 
		 OutputWriter ow3 = new OutputWriter("Anstehzeit");
		 ow3.writeOutputToFile(mwt.toString());
		 
		 
		 OutputWriter ow4 = new OutputWriter("Verweildauer");
		 ow4.writeOutputToFile(timeOfClientInShop.toString());
		

	}

}

