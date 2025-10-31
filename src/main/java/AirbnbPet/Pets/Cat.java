package AirbnbPet.Pets;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Pet {
    // defined by a pedigree
    private String pedigree;

    public Cat() {}

    public Cat(String id, String name, double weightKg, int ageYears, int ageMonths, boolean requiresNightSupervision, String pedigree) {
        super(id, name, weightKg, ageYears, ageMonths, requiresNightSupervision);
        this.pedigree = pedigree;
    }

    @Override
    public List<String> getData() {
        List<String> res = new ArrayList<>();
        return res;
    }

    @Override
    public int calculateValue(int days) {
        return 0;
    }
}
