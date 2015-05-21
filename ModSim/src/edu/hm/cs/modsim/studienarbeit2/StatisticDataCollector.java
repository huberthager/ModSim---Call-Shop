/*
@author Hubert Hager, Julian Bauer
*/
package edu.hm.cs.modsim.studienarbeit2;

import java.util.ArrayList;
import java.util.List;

public class StatisticDataCollector {
	
	private List<Double> queueClocks = new ArrayList<Double>();
	private List<Double> queueLengths = new ArrayList<Double>();
	
	private List<Double> ShopClientState = new ArrayList<Double>();
	private List<Double> ShopClockState = new ArrayList<Double>();
	
	
	private List<Double> mwt = new ArrayList<Double>();
	private List<Double> timeOfClientInShop = new ArrayList<Double>();
	private List<Double> serverBusyTime = new ArrayList<Double>();
//	private double serverBusyTime = 0;

	public void addQueueEntry(double clock, double queueSize) {
		queueClocks.add(clock);
		queueLengths.add(queueSize);
	}

	public void addNumberOfClientsInSystem(double clock, double clientsInSystem) {
		ShopClockState.add(clock);
		ShopClientState.add(clientsInSystem);
	}

	public void addMeanWaitingTime(double d) {
		mwt.add(d);
	}

	public void addTimeOfClientInShop(double d) {
		timeOfClientInShop.add(d);
	}
	
	public void addServerBusyTimes(double d) {
		serverBusyTime.add(d);
	}
//	public void addBusyTime(double d) {
//		serverBusyTime += d;
//	}

//	public String toString() {
//		String out = "";
//		for (List<Double> e : queueClocks) {
//			for (double d : e) {
//				out += d + "|";
//			}
//		}
//		System.out.println(out);
//		return out;
//	}

	public List<Double> getQueueLengths() {
		List<Double> appended = queueLengths;
		appended.addAll(queueClocks);
		return appended;
	}


	public List<Double> getMeanWaitingTimes() {
		return mwt;
	}

	public List<Double> getListTimeOfClientInShop() {
		return timeOfClientInShop;
	}
	
	public List<Double> getServerBusyTimes() {
		return serverBusyTime;
	}
	
	public List<Double> getShopClientState() {
		List<Double> appended = ShopClientState;
		appended.addAll(ShopClockState);
		return appended;
	}
	
}
