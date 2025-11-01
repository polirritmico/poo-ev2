package AirbnbPet;

import AirbnbPet.Pets.Rabbit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static AirbnbPet.helpers.substringInCollection;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RabbitTest {
    @Test
    void shouldGenerateAllMeaningfulPetData() {
        Rabbit casePet = new Rabbit(
            "mockrabbit-42",
            "Mock The Rabbit",
            0.4,
            1,
            2,
            false,
            "Carrots",
            false
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