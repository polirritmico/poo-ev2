package AirbnbPet;

import org.junit.jupiter.api.Test;
import AirbnbPet.Pets.Cat;

import static AirbnbPet.helpers.substringInCollection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    @Test
    void shouldGenerateAllMeaningfulPetData() {
        Cat casePet = new Cat(
            "mockrabbit-42",
            "Mock The Rabbit",
            0.4,
            1,
            2,
            false,
            "Carrots"
        );
        String expectedId = "mockrabbit-42";
        String expectedName = "mock the rabbit";
        String expectedWeight = "0.4 kg";
        String expectedYears = "1 years";
        String expectedMonths = "2 months";
        String expectedFoodType = "carrots";
        String expectedSupervision = "requires night supervision";

        List<String> output = casePet.getData();
        assertTrue(substringInCollection(expectedId, output));
        assertTrue(substringInCollection(expectedName, output));
        assertTrue(substringInCollection(expectedWeight, output));
        assertTrue(substringInCollection(expectedYears, output));
        assertTrue(substringInCollection(expectedMonths, output));
        assertTrue(substringInCollection(expectedFoodType, output));
        assertTrue(substringInCollection(expectedSupervision, output));
    }
}