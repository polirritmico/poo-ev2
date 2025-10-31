package AirbnbPet.Pets;

import java.util.ArrayList;
import java.util.List;

public class Rabbit extends Pet {
    // identify by eaten food
    private String foodType;

    public Rabbit() {}

    public Rabbit(String id, String name, double weightKg, int ageYears, int ageMonths, boolean requiresNightSupervision, String foodType) {
        super(id, name, weightKg, ageYears, ageMonths, requiresNightSupervision);
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
