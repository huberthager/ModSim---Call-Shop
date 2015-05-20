package edu.hm.cs.modsim.studienarbeit2;

import java.util.ArrayList;
import java.util.List;

public class StatisticDataCollector {

	private List<List<Double>> mqs = new ArrayList<List<Double>>();
	private List<List<Double>> mcs = new ArrayList<List<Double>>();
	private List<Double> mwt = new ArrayList<Double>();
	private List<Double> timeOfClientInShop = new ArrayList<Double>();
	private double serverBusyTime = 0;

	public void addQueueEntry(double clock, double queueSize) {
		List<Double> entry = new ArrayList<>();
		entry.add(clock);
		entry.add(queueSize);
		mqs.add(entry);
	}

	public void addClientSystem(double clock, double clientsInSystem) {
		List<Double> entry = new ArrayList<>();
		entry.add(clock);
		entry.add(clientsInSystem);
		mcs.add(entry);
	}

	public void addMeanWaitingTime(double d) {
		mwt.add(d);
	}

	public void addTimeOfClientInShop(double d) {
		timeOfClientInShop.add(d);
	}
	
	public void addBusyTime(double d) {
		serverBusyTime += d;
	}

	public String toString() {
		String out = "";
		for (List<Double> e : mqs) {
			for (double d : e) {
				out += d + "|";
			}
		}
		System.out.println(out);
		return out;
	}

	public List<List<Double>> getMeanQueue() {
		return mqs;
	}

	public List<List<Double>> getMeanClientsInSystem() {
		return mcs;
	}

	public List<Double> getMeanWaitingTimes() {
		return mwt;
	}

	public List<Double> getListTimeOfClientInShop() {
		return timeOfClientInShop;
	}
	
	public double getServerBusyTime() {
		return serverBusyTime;
	}
	
}
