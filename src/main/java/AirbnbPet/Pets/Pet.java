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
}
