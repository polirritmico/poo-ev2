package AirbnbPet.Pets;

public class Rabbit extends Pet {
    // identify by eaten food

    public Rabbit() {}

    public Rabbit(
        String id,
        boolean requiresNightSupervision,
        String name,
        double weightKg,
        int ageYears,
        int ageMonths
    ) {
        super.id = id;
        super.requiresNightSupervision = requiresNightSupervision;
        super.name = name;
        super.weightKg = weightKg;
        super.ageYears = ageYears;
        super.ageMonths = ageMonths;
    }

    @Override
    public String getData() {
        return "";
    }
}
