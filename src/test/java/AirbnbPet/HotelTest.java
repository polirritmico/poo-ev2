package AirbnbPet;

import AirbnbPet.Pets.Cat;
import AirbnbPet.Pets.Dog;
import AirbnbPet.Pets.Rabbit;
import org.junit.jupiter.api.Test;

import static AirbnbPet.Mocks.*;
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
    public void rabbitNeighborsStateShouldRepresentCurrentHotelGuestsState() {
        Rabbit rabbit1 = newMockRabbit();
        Rabbit rabbit2 = newMockRabbit();
        Rabbit rabbit3 = newMockRabbit();
        Cat cat = newMockCat();

        Hotel hotel = new Hotel();
        hotel.registerPet(rabbit1);
        hotel.registerPet(cat);
        assertFalse(rabbit1.hasNeighbors());
        assertFalse(rabbit2.hasNeighbors());
        assertFalse(rabbit3.hasNeighbors());

        hotel.registerPet(rabbit2);
        assertTrue(rabbit1.hasNeighbors());
        assertTrue(rabbit2.hasNeighbors());
        assertFalse(rabbit3.hasNeighbors());

        hotel.registerPet(rabbit3);
        assertTrue(rabbit1.hasNeighbors());
        assertTrue(rabbit2.hasNeighbors());
        assertTrue(rabbit3.hasNeighbors());

        hotel.unregisterPet(cat);
        assertTrue(rabbit1.hasNeighbors());
        assertTrue(rabbit2.hasNeighbors());
        assertTrue(rabbit3.hasNeighbors());

        hotel.unregisterPet(rabbit1);
        assertFalse(rabbit1.hasNeighbors());
        assertTrue(rabbit2.hasNeighbors());
        assertTrue(rabbit3.hasNeighbors());

        hotel.unregisterPet(rabbit3);
        assertFalse(rabbit1.hasNeighbors());
        assertFalse(rabbit2.hasNeighbors());
        assertFalse(rabbit3.hasNeighbors());
    }
}