package AirbnbPet;

import AirbnbPet.Pets.Rabbit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static AirbnbPet.Mocks.newMockRabbit;
import static AirbnbPet.helpers.substringInCollection;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void shouldCalculateSingleRabbitFee() {
        Rabbit caseRabbit = newMockRabbit();
        caseRabbit.setHasNeighbors(false);
        int expectedFeeOneDay = 25_000;
        int expectedFeeTwoDays = 50_000;
        int expectedFeeFiveDays = 125_000;

        int outputFeeOneDay = caseRabbit.calculateValue(1);
        int outputFeeTwoDays = caseRabbit.calculateValue(2);
        int outputFeeFiveDays = caseRabbit.calculateValue(5);

        assertEquals(expectedFeeOneDay, outputFeeOneDay);
        assertEquals(expectedFeeTwoDays, outputFeeTwoDays);
        assertEquals(expectedFeeFiveDays, outputFeeFiveDays);
    }

    @Test
    public void shouldCalculateMultipleRabbitsFee() {
        Rabbit caseRabbit = newMockRabbit();
        caseRabbit.setHasNeighbors(true);
        int expectedFeeOneDay = 25_000;
        int expectedFeeTwoDays = 48_250;
        int expectedFeeFiveDays = 108_683;

        int outputFeeOneDay = caseRabbit.calculateValue(1);
        int outputFeeTwoDays = caseRabbit.calculateValue(2);
        int outputFeeFiveDays = caseRabbit.calculateValue(5);

        assertEquals(expectedFeeOneDay, outputFeeOneDay);
        assertEquals(expectedFeeTwoDays, outputFeeTwoDays);
        assertEquals(expectedFeeFiveDays, outputFeeFiveDays);
    }

    @Test
    public void multipleRabbitsFeeShouldNotBeFree() {
        int caseDays = 200; // zero at >150
        Rabbit caseRabbit = newMockRabbit();

        caseRabbit.setHasNeighbors(true);
        int output = caseRabbit.calculateValue(caseDays);

        assertTrue(output > 0);
    }
}