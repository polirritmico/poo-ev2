package AirbnbPet.Pets;

/**
 * Abstract Pet class.
 * Each pet species admitted into AirbnbPet must inherit from this class.
 */
public abstract class Pet {
    protected String id;
    protected Boolean requiresNightSupervision;

    protected String name;
    protected double weightKg;
    protected int ageYears;
    protected int ageMonths;

    /**
     * Generate a string with all the pet meaningful data.
     */
    public abstract String getData();

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public Boolean getRequiresNightSupervision() {return requiresNightSupervision;}

    public void setRequiresNightSupervision(Boolean requiresNightSupervision) {
        this.requiresNightSupervision = requiresNightSupervision;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getWeightKg() {return weightKg;}

    public void setWeightKg(double weightKg) {this.weightKg = weightKg;}

    public int getAgeYears() {return ageYears;}

    public void setAgeYears(int ageYears) {this.ageYears = ageYears;}

    public int getAgeMonths() {return ageMonths;}

    public void setAgeMonths(int ageMonths) {this.ageMonths = ageMonths;}
}
