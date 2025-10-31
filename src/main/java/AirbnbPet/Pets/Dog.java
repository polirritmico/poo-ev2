package AirbnbPet.Pets;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dog extends Pet {
    private int dailyExerciseSessions = 0;
    private LocalDate lastExerciseDate;

    public Dog() {}

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

    private void resetExerciseRegistry(LocalDate today) {
        lastExerciseDate = today;
        dailyExerciseSessions = 0;
    }

    public int registerNewExerciseSession(LocalDate today) {
        if (lastExerciseDate == null || lastExerciseDate.isBefore(today)) {
            resetExerciseRegistry(today);
        }
        dailyExerciseSessions += 1;

        System.out.println(
            "[Exercising Dog] "
                + "Date: " + today
                + " | Session #: " + dailyExerciseSessions
                + " | Name: " + name
                + " | Id: " + id
        );
        return dailyExerciseSessions;
    }

    public int getDailyExerciseSessions() {return dailyExerciseSessions;}

    @Override
    public List<String> getData() {
        List<String> res = new ArrayList<>();
        return res;
    }
}
