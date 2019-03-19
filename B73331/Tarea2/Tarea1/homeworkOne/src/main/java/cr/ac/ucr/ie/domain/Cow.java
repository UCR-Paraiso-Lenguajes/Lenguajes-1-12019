package cr.ac.ucr.ie.domain;

public class Cow {
private int numberOfTheCow;
private int ageOfTheCow;
private String raceOfTheCow;

public Cow(int numberOfTheCow, int ageOfTheCow, String raceOfTheCow) {
	if(numberOfTheCow<0) throw new RuntimeException("The number of the cow must be greater than 0");
	if(ageOfTheCow<0) throw new RuntimeException("The age of the cow must be greater than 0");
	if(raceOfTheCow.trim().equals("")||raceOfTheCow.equals(null))throw new RuntimeException("The race of the cow is required");
	
	this.numberOfTheCow = numberOfTheCow;
	this.ageOfTheCow = ageOfTheCow;
	this.raceOfTheCow = raceOfTheCow;
}

public Cow() {
}

public int getNumberOfTheCow() {
	return numberOfTheCow;
}

public void setNumberOfTheCow(int numberOfTheCow) {
	this.numberOfTheCow = numberOfTheCow;
}

public int getAgeOfTheCow() {
	return ageOfTheCow;
}

public void setAgeOfTheCow(int ageOfTheCow) {
	this.ageOfTheCow = ageOfTheCow;
}

public String getRaceOfTheCow() {
	return raceOfTheCow;
}

public void setRaceOfTheCow(String raceOfTheCow) {
	this.raceOfTheCow = raceOfTheCow;
}

@Override
public String toString() {
	return "Cow [numberOfTheCow=" + numberOfTheCow + ", ageOfTheCow=" + ageOfTheCow + ", raceOfTheCow=" + raceOfTheCow
			+ "]";
}

}
