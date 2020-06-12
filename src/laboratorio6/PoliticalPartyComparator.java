package laboratorio6;

import java.util.Comparator;

public class PoliticalPartyComparator implements Comparator<Candidate> {

	@Override
	public int compare(Candidate o1, Candidate o2) {
		return o1.getPoliticalParty().compareTo(o2.getPoliticalParty());
	}

}
