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

    public boolean hasNeighbors() {return hasNeighbors;}

    public void setHasNeighbors(boolean hasNeighbors) {this.hasNeighbors = hasNeighbors;}

    @Override
    public List<String> getData() {
        List<String> res = new ArrayList<>();
        res.add("[Rabbit Data]");
        res.add("ID: " + getId());
        res.add("Name: " + getName());
        res.add("Weight: " + getWeightKg() + " kg");
        res.add("Age: " + getAgeYears() + " years, " + getAgeMonths() + " months");
        res.add("Food type: " + getFoodType());
        res.add("Requires night supervision: " + requiresNightSupervision());
        return res;
    }

    @Override
    public int calculateValue(int days) {
        if (!hasNeighbors()) {
            return VALOR_DIA_ALOJAMIENTO * days;
        }

        double rate = 1 + percentageIncreaseFeesByPetType.get("Rabbit") / 100.0;
        double fee = VALOR_DIA_ALOJAMIENTO * (Math.pow(rate, days) - 1) / (rate - 1);
        return Math.max((int) Math.round(fee), 1);
    }
}
