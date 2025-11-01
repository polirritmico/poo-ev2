package AirbnbPet;

import AirbnbPet.Pets.Dog;
import AirbnbPet.Pets.Rabbit;
import org.junit.jupiter.api.Test;

import static AirbnbPet.Mocks.newMockDog;
import static AirbnbPet.Mocks.newMockRabbit;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    @Test
    public void shouldRegisterIncomingPetOnEmptyHotel() {
        Dog casePet = newMockDog();

        Hotel hotel = new Hotel();
        assertTrue(hotel.registerPet(casePet));
        assertTrue(hotel.isPetRegister(casePet));
    }

    @Test
    public void shouldRegisterIncomingPets() {
        Dog casePet1 = newMockDog();
        Dog casePet2 = newMockDog();

        Hotel hotel = new Hotel();
        assertTrue(hotel.registerPet(casePet1));
        assertTrue(hotel.registerPet(casePet2));

        assertTrue(hotel.isPetRegister(casePet1));
    }

    @Test
    public void shouldNotRegisterPetWithoutId() {
        Dog casePet = new Dog();
        Hotel hotel = new Hotel();
        assertFalse(hotel.registerPet(casePet));
        assertFalse(hotel.isPetRegister(casePet));
    }

    @Test
    public void shouldNotRegisterIncomingPetWithDuplicatedId() {
        Dog caseFirstPet = newMockDog();
        Dog casePetWithDuplicatedId = newMockDog();

        Hotel hotel = new Hotel();
        casePetWithDuplicatedId.setId(caseFirstPet.getId());
        hotel.registerPet(caseFirstPet);

        assertEquals(caseFirstPet.getId(), casePetWithDuplicatedId.getId());
        assertFalse(hotel.registerPet(casePetWithDuplicatedId));
    }

    @Test
    public void shouldCalculateSingleRabbitFee() {
        Rabbit caseRabbit = newMockRabbit();
        int expectedFeeOneDay = 25_000;
        int expectedFeeTwoDays = 50_000;
        int expectedFeeFiveDays = 125_000;

        Hotel hotel = new Hotel();
        hotel.registerPet(caseRabbit);
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
        int expectedFeeOneDay = 25_000;
        int expectedFeeTwoDays = 48_250;
        int expectedFeeFiveDays = 108_683;

        Hotel hotel = new Hotel();
        hotel.registerPet(caseRabbit);
        hotel.registerPet(newMockRabbit());
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

        Hotel hotel = new Hotel();
        newMockRabbit();
        hotel.registerPet(caseRabbit);
        int output = caseRabbit.calculateValue(caseDays);

        assertTrue(output > 0);
    }
}