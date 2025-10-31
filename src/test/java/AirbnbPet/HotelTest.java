package AirbnbPet;

import AirbnbPet.Pets.Dog;

import static AirbnbPet.Mocks.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}