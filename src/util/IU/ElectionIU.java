package util.IU;

import java.util.InputMismatchException;
import java.util.Scanner;

import util.Candidate;
import util.Election;

public class ElectionIU {
	
	Scanner sc = new Scanner(System.in);
	private Election election;
	
	public ElectionIU(Election election) {
		this.election = election;
	}
	
	public void addCandidate() {
		System.out.println("Type it the name");
		
		String name = sc.next();
		sc.nextLine();
		boolean validName = false;
		while(!validName) {
			if(nameIsValid(name)) {
				validName = true;
			}else {
				System.out.println("Type it a valid name!");
				name = sc.nextLine();
			}
		}
		
		System.out.println("Type it the age");
		int age = -1;
		boolean validAge = false;
		while(!validAge) {
			try {
				age = Integer.parseInt(sc.nextLine().replaceAll("\\D",""));
				if(18>age || age>110)
					throw new InputMismatchException();
				validAge = true;
			}catch(InputMismatchException | NumberFormatException e) {
				System.out.println("Type it a valid age!");
			}
		}
		System.out.println("Type it the political party");
		String party = sc.nextLine();
		boolean validParty = false;
		while(!validParty) {
			try {
				if(party.length()<2 || party.isEmpty())
					throw new InputMismatchException();
				validParty = true;
			}catch(InputMismatchException e) {
				System.out.println("Type it a valid political party!");
				party = sc.nextLine();
			}
		}
		System.out.println("Type the number of votes");
		int votes = Integer.parseInt(sc.nextLine().replaceAll("\\D",""));
		boolean validVote = false;
		while(!validVote) {
			try {
				if(votes<0)
					throw new InputMismatchException();
				validVote = true;
			}catch(InputMismatchException e) {
				System.out.println("Type it a valid number of votes!");
				votes = Integer.parseInt(sc.nextLine().replaceAll("\\D",""));
			}
		}
		Candidate cand = new Candidate(name,age,party,votes);
		election.addCandidate(cand);	
		System.out.println("Candidate successfully added!");
		System.out.println("-----------------------------");
	}

	private boolean nameIsValid(String name) {
		if(name.length()<3 || name.matches(".*[0-9].*"))
			return false;
		return true;
	}
	
	public void removeCandidate() {
		if(!election.isEmpty()) {
			System.out.println("Type the candidate name to be removed");
			String name = sc.nextLine();
			if(!election.removeCandidate(name))
				System.out.println("Candidate not found!");
			else
				System.out.println("Candidate successfully removed!");
		}else {
			noCandidates();
		}
	}
	
	private void noCandidates() {
			System.out.println("There is no candidates registered");
			System.out.println("---------------------------------");
	}
	public void showCandidates() {
		if(election.isEmpty()) {
			noCandidates();
		}else
			System.out.println(election);
	}
	
	public void sortList() {
		if(election.isEmpty()) {
			noCandidates();
		}else {
			System.out.println("SORT OPTIONS");
			System.out.println("[1] By votes");
			System.out.println("[2] By age");
			System.out.println("[3] By political party");
			System.out.println("[4] By name");
			System.out.println("[5] Cancel");
			
			int option = -1;
			boolean optionIsValid = false;
			
			while(!optionIsValid) {
				try {
					option = sc.nextInt();
					if(option<1 || option>5)
						throw new InputMismatchException();
					optionIsValid = true;
				}catch(InputMismatchException e) {
					System.out.println("Type a valid option!");
				}
			}
			
			if(option==1)
				election.sortByVotes();
			if(option==2)
				election.sortByAge();
			if(option==3)
				election.sortByParty();
			if(option==4)
				election.sortByName();
		}
	}
	
	public void showStats() {
		if(election.isEmpty()) {
			noCandidates();
		}else {
			StringBuilder sb = new StringBuilder();
			sb.append("\nELECTION STATS:");
			sb.append(String.format("\n%-20s | %2s | %9s | %5s","Name","Age","Pol.Party","Votes"));
			sb.append("\nYoungest:       ");
			sb.append(election.whoIsYounger());
			sb.append("\nOldest:         ");
			sb.append(election.whoIsOlder());
			sb.append("\nMore voted:     ");
			sb.append(election.moreVoted());
			sb.append("\nLess voted:     ");
			sb.append(election.lessVoted());
			sb.append("\nTotal votes:    ");
			sb.append(election.totalVotes());
			sb.append("\n-------------");
			sb.append("\nPercent Stats\n");
			for(Candidate i : election.getCandidates()) {
				sb.append(i.getName());
				sb.append("=> ");
				sb.append(String.format("%.2f",election.averageVoteByCandidate(i)));
				sb.append("%\n");
			}
			System.out.println(sb.toString());
		}	
	}
}
