package task1lenguajes;

// Example of Class Name (Chapter 2 P.25)
public class Animal {

//Example of use Pronunceable Names(Chapter 2 P.21)
    private String kingdomeBelongs;
    private String scientificName;
    private String familyBelongs;
    private String habitatRegion;
    private double animalHeight;
    private double animalWeight;

    public Animal(String kingdomeBelongs, String scientificName, String familyBelongs, String habitatRegion, double animalHeight, double animalWeight) {
        this.kingdomeBelongs = kingdomeBelongs;
        this.scientificName = scientificName;
        this.familyBelongs = familyBelongs;
        this.habitatRegion = habitatRegion;
        this.animalHeight = animalHeight;
        this.animalWeight = animalWeight;
    }

    public String getKingdomeBelongs() {
        return kingdomeBelongs;
    }

    public void setKingdomeBelongs(String kingdomeBelongs) {
        this.kingdomeBelongs = kingdomeBelongs;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getFamilyBelongs() {
        return familyBelongs;
    }

    public void setFamilyBelongs(String familyBelongs) {
        this.familyBelongs = familyBelongs;
    }

    public String getHabitatRegion() {
        return habitatRegion;
    }

    public void setHabitatRegion(String habitatRegion) {
        this.habitatRegion = habitatRegion;
    }

    public double getAnimalHeight() {
        return animalHeight;
    }

    public void setAnimalHeight(double animalHeight) {
        this.animalHeight = animalHeight;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }

    public void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

}
