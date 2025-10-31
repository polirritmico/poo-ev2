package AirbnbPet.Pets;

public class Dog extends Pet {
    private int dailyExerciseSessions;

    public Dog() {
        dailyExerciseSessions = 0;
    }

    public Dog(
        String id,
        boolean requiresNightSupervision,
        String name,
        double weightKg,
        int ageYears,
        int ageMonths,
        int dailyExerciseSessions
    ) {
        super.id = id;
        super.requiresNightSupervision = requiresNightSupervision;
        super.name = name;
        super.weightKg = weightKg;
        super.ageYears = ageYears;
        super.ageMonths = ageMonths;
        this.dailyExerciseSessions = dailyExerciseSessions;
    }

    @Override
    public String getData() {
        return "";
    }
}
