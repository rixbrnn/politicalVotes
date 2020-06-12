package laboratorio6;

public class Candidate {

	private String name;
	private int age;
	private String politicalParty;
	private int votes;
	
	
	public Candidate(String name, int age, String politicalParty, int votes) {
		this.name = name;
		this.age = age;
		this.politicalParty = politicalParty;
		this.votes = votes;
	}
	
	@Override
	public String toString() {
		return "Candidate [name=" + name + ", age=" + age + ", politicalParty=" + politicalParty + ", votes=" + votes
				+ "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPoliticalParty() {
		return politicalParty;
	}
	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	

}
