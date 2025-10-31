package AirbnbPet.Pets;

import java.util.ArrayList;
import java.util.List;

public class Rabbit extends Pet {
    // identify by eaten food
    private String foodType;

    public Rabbit() {}

    public Rabbit(
        String id,
        boolean requiresNightSupervision,
        String name,
        double weightKg,
        int ageYears,
        int ageMonths,
        String foodType
    ) {
        super.id = id;
        super.requiresNightSupervision = requiresNightSupervision;
        super.name = name;
        super.weightKg = weightKg;
        super.ageYears = ageYears;
        super.ageMonths = ageMonths;
        this.foodType = foodType;
    }

    public String getFoodType() {return foodType;}

    public void setFoodType(String foodType) {this.foodType = foodType;}

    @Override
    public List<String> getData() {
        List<String> res = new ArrayList<>();
        return res;
    }
}
