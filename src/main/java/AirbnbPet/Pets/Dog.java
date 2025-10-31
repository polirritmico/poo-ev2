package AirbnbPet.Pets;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dog extends Pet {
    private int dailyExerciseSessions = 0;
    private LocalDate lastExerciseDate;

    public Dog() {}

    public Dog(String id, String name, double weightKg, int ageYears, int ageMonths, boolean requiresNightSupervision, int dailyExerciseSessions) {
        super(
            id,
            name,
            weightKg,
            ageYears,
            ageMonths,
            requiresNightSupervision
        );
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
        res.add("[Dog Data]");
        res.add("ID:\t" + getId());
        res.add("Name:\t" + getName());
        res.add("Weight:\t" + getWeightKg() + " kg");
        res.add("Age:\t" + getAgeYears() + " years, " + getAgeMonths() + " months");
        res.add("Exercise sessions today:\t" + getDailyExerciseSessions());
        res.add("Requires night supervision:\t" + requiresNightSupervision());
        return res;
    }
}
