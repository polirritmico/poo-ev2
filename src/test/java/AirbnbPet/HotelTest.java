package AirbnbPet;

import AirbnbPet.Pets.Dog;
import org.junit.jupiter.api.Test;

import static AirbnbPet.Mocks.newMockDog;
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
    public void shouldCalculateDogFee() {
        Dog casePet = newMockDog();
        for (int i = 0; i < 3; i++)
            casePet.registerNewExerciseSession();
        int expectedFee = 26_750;

        int outputFee = casePet.calculateValue(1);
        assertEquals(expectedFee, outputFee);
    }
}