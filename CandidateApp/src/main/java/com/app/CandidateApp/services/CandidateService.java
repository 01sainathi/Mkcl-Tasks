package com.app.CandidateApp.services;

import com.app.CandidateApp.models.Candidate;
import com.app.CandidateApp.sources.DataStore;

public class CandidateService {
	
	public static Candidate findById(int id) {
		
		for(int i=0; i<DataStore.list.size(); i++) {
			Candidate c = DataStore.list.get(i);
			if(c.getId()==id) {
				return c;
			}
		}
		
		return null;
	}
	
	public static void delete(int id) {
		
		for(int i=0; i<DataStore.list.size(); i++) {
			Candidate c = DataStore.list.get(i);
			if(c.getId()==id) {
				DataStore.list.remove(c);
			}
		}
	}
	
	public static void update(Candidate cand) {
		
		for(int i=0; i<DataStore.list.size(); i++) {
			Candidate c = DataStore.list.get(i);
			if(c.getId()==cand.getId()) {
				DataStore.list.remove(c);
			}
		}
		
		DataStore.list.add(cand);
	}
	
}
