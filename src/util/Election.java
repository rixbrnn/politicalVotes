package util;

import java.util.ArrayList;
import java.util.Collections;

import utilComparators.AgeComparator;
import utilComparators.NameComparator;
import utilComparators.PoliticalPartyComparator;
import utilComparators.VotesComparator;

public class Election {
	
	ArrayList<Candidate> candidates = new ArrayList<>();
	
	public ArrayList<Candidate> getCandidates(){
		return candidates;
	}
	
	public void addCandidate(Candidate cand) {
		candidates.add(cand);
		sortByName();
	}
	
	public boolean removeCandidate(String name) {
		for(Candidate i : candidates) {
			if(i.getName().equalsIgnoreCase(name)) {
				candidates.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Candidate whoIsYounger() {
		Candidate youngest = candidates.get(0);
		for(Candidate i : candidates) {
			if(i.getAge()<youngest.getAge())
				youngest = i;
		}
		return youngest;
	}
	
	public Candidate whoIsOlder() {
		Candidate oldest = candidates.get(0);
		for(Candidate i : candidates) {
			if(i.getAge()>oldest.getAge())
				oldest = i;
		}
		return oldest;
	}
	
	public Candidate moreVoted() {
		Candidate mostVoted = candidates.get(0);
		for(Candidate i : candidates) {
			if(i.getVotes()>mostVoted.getVotes())
				mostVoted = i;
		}
		return mostVoted;
	}
	
	public Candidate lessVoted() {
			Candidate lessVoted = candidates.get(0);
			for(Candidate i : candidates) {
				if(i.getVotes()<lessVoted.getVotes())
					lessVoted = i;
			}
			return lessVoted;
	}
	
	public int totalVotes() {
		int sum=0;
		for(Candidate i : candidates) {
			sum += i.getVotes();
		}
		return sum;
	}
	
	public double averageVoteByCandidate(Candidate candidate) {
		Double totalVotes = (double) totalVotes();
		return (candidate.getVotes()/ totalVotes)*100;
	}
	
	public void sortByName() {
		Collections.sort(candidates, new NameComparator());
	}
	
	public void sortByAge() {
		Collections.sort(candidates, new AgeComparator());
	}
	
	public void sortByVotes() {
		Collections.sort(candidates, new VotesComparator());
	}
	
	public void sortByParty() {
		Collections.sort(candidates, new PoliticalPartyComparator());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Candidate i : candidates) {
			sb.append(i);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public boolean isEmpty() {
		if(candidates.isEmpty())
			return true;
		return false;
	}
	
	
	
}
