package laboratorio6;

import java.util.Comparator;

public class VotesComparator implements Comparator<Candidate> {

	@Override
	public int compare(Candidate o1, Candidate o2) {
		if (o1.getVotes() < o2.getVotes())
			return -1;
		if (o1.getVotes() > o2.getVotes())
			return 1;
		else
			return 0;
	}
	
	

}
