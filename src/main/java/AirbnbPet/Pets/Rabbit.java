package AirbnbPet.Pets;

import java.util.ArrayList;
import java.util.List;

public class Rabbit extends Pet {
    // identify by eaten food
    private String foodType;
    private boolean hasNeighbors;

    public Rabbit() {}

    public Rabbit(String id, String name, double weightKg, int ageYears, int ageMonths, boolean requiresNightSupervision, String foodType, boolean hasNeighbors) {
        super(id, name, weightKg, ageYears, ageMonths, requiresNightSupervision);
        this.foodType = foodType;
        this.hasNeighbors = hasNeighbors;
    }

    public String getFoodType() {return foodType;}

    public void setFoodType(String foodType) {this.foodType = foodType;}

    public boolean isHasNeighbors() {return hasNeighbors;}

    public void setHasNeighbors(boolean hasNeighbors) {this.hasNeighbors = hasNeighbors;}

    @Override
    public List<String> getData() {
        List<String> res = new ArrayList<>();
        res.add("[Rabbit Data]");
        res.add("ID:\t" + getId());
        res.add("Name:\t" + getName());
        res.add("Weight:\t" + getWeightKg() + " kg");
        res.add("Age:\t" + getAgeYears() + " years, " + getAgeMonths() + " months");
        res.add("Food type:\t" + getFoodType());
        res.add("Requires night supervision:\t" + requiresNightSupervision());
        return res;
    }

    @Override
    public int calculateValue(int days) {
        return 0;
    }
}
