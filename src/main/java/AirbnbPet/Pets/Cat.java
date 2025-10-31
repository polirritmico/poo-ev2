package AirbnbPet.Pets;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Pet {
    // defined by a pedigree
    private String pedigree;

    public Cat() {}

    public Cat(
        String id,
        boolean requiresNightSupervision,
        String name,
        double weightKg,
        int ageYears,
        int ageMonths,
        String pedigree
    ) {
        super.id = id;
        super.requiresNightSupervision = requiresNightSupervision;
        super.name = name;
        super.weightKg = weightKg;
        super.ageYears = ageYears;
        super.ageMonths = ageMonths;
        this.pedigree = pedigree;
    }

    @Override
    public List<String> getData() {
        List<String> res = new ArrayList<>();
        return res;
    }
}
