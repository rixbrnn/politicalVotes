package utilComparators;

import java.util.Comparator;

import util.Candidate;

public class PoliticalPartyComparator implements Comparator<Candidate> {

	@Override
	public int compare(Candidate o1, Candidate o2) {
		return o1.getPoliticalParty().compareTo(o2.getPoliticalParty());
	}

}
