package utilComparators;

import java.util.Comparator;

import util.Candidate;

public class NameComparator implements Comparator<Candidate>{

	@Override
	public int compare(Candidate o1, Candidate o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
