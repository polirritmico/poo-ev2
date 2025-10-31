package AirbnbPet.Pets;

import AirbnbPet.AccommodationFees;

import java.util.List;


/**
 * Abstract Pet class.
 * Each pet species admitted into AirbnbPet must inherit from this class.
 */
public abstract class Pet implements AccommodationFees {
    protected String id;
    protected String name;
    protected double weightKg;
    protected int ageYears;
    protected int ageMonths;
    protected boolean requiresNightSupervision;

    public Pet() {}

    public Pet(String id, String name, double weightKg, int ageYears, int ageMonths, boolean requiresNightSupervision) {
        this.id = id;
        this.name = name;
        this.weightKg = weightKg;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.requiresNightSupervision = requiresNightSupervision;
    }

    /**
     * Generate a list of strings with all the pet meaningful data.
     */
    public abstract List<String> getData();

    public abstract int calculateValue(int days);

    // -------------------------------------------------------------------------


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(int ageYears) {
        this.ageYears = ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(int ageMonths) {
        this.ageMonths = ageMonths;
    }

    public boolean requiresNightSupervision() {
        return requiresNightSupervision;
    }

    public void setRequiresNightSupervision(boolean requiresNightSupervision) {
        this.requiresNightSupervision = requiresNightSupervision;
    }
}
