package AirbnbPet;

import AirbnbPet.Pets.Cat;
import org.junit.jupiter.api.Test;

import java.util.List;

import static AirbnbPet.Mocks.newMockCat;
import static AirbnbPet.helpers.substringInCollection;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CatTest {
    @Test
    void shouldGenerateAllMeaningfulPetData() {
        Cat casePet = new Cat(
            "mocat-987",
            "MockedCat",
            4.2,
            2,
            6,
            false,
            "Siamese"
        );
        String expectedId = "mocat-987";
        String expectedName = "MockedCat";
        String expectedWeight = "4.2 kg";
        String expectedYears = "2 years";
        String expectedMonths = "6 months";
        String expectedSupervision = "requires night supervision";
        String expectedPedigree = "Siamese";

        List<String> output = casePet.getData();
        assertTrue(substringInCollection(expectedId, output));
        assertTrue(substringInCollection(expectedName, output));
        assertTrue(substringInCollection(expectedWeight, output));
        assertTrue(substringInCollection(expectedYears, output));
        assertTrue(substringInCollection(expectedMonths, output));
        assertTrue(substringInCollection(expectedSupervision, output));
        assertTrue(substringInCollection(expectedPedigree, output));
    }

    @Test
    public void shouldCalculateCatFee() {
        int expectedFeeOneDay = 25_000;
        int expectedFeeTwoDays = 51_250;
        int expectedFeeFiveDays = 138_141;

        Cat casePet = newMockCat();
        int outputFeeOneDay = casePet.calculateValue(1);
        int outputFeeTwoDays = casePet.calculateValue(2);
        int outputFeeFiveDays = casePet.calculateValue(5);

        assertEquals(expectedFeeOneDay, outputFeeOneDay);
        assertEquals(expectedFeeTwoDays, outputFeeTwoDays);
        assertEquals(expectedFeeFiveDays, outputFeeFiveDays);
    }
}