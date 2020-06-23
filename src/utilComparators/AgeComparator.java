package utilComparators;

import java.util.Comparator;

import util.Candidate;

public class AgeComparator implements Comparator<Candidate> {

	@Override
	public int compare(Candidate o1, Candidate o2) {
		if (o1.getAge() < o2.getAge())
			return -1;
		if (o1.getAge() > o2.getAge())
			return 1;
		else
			return 0;
	}

}
