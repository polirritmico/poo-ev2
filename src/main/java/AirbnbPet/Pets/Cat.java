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

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    @Override
    public List<String> getData() {
        List<String> res = new ArrayList<>();
        res.add("[Cat Data]");
        res.add("ID:\t" + getId());
        res.add("Name:\t" + getName());
        res.add("Weight:\t" + getWeightKg() + " kg");
        res.add("Age:\t" + getAgeYears() + " years, " + getAgeMonths() + " months");
        res.add("Pedigree:\t" + getPedigree());
        res.add("Requires night supervision:\t" + requiresNightSupervision());
        return res;
    }

    @Override
    public int calculateValue(int days) {
        return 0;
    }
}
