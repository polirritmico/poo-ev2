package AirbnbPet;

import AirbnbPet.Pets.Cat;
import AirbnbPet.Pets.Dog;
import AirbnbPet.Pets.Pet;
import AirbnbPet.Pets.Rabbit;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    public void shouldCorrectlyCountGuests() {
        int expectedEmptyHotelGuestsCount = 0;
        int expectedAfterGuestsCount = 20;

        Hotel hotel = new Hotel();
        int outputBefore = hotel.getGuestsCount();

        for (int i = 0; i < 20; i++)
            hotel.registerPet(newMockCat());
        int outputAfter = hotel.getGuestsCount();

        assertEquals(expectedEmptyHotelGuestsCount, outputBefore);
        assertEquals(expectedAfterGuestsCount, outputAfter);
    }

    @Test
    public void shouldCorrectlyUnregisterAGuest() {
        int expectedBeforeCount = 3;
        int expectedAfterCount = 0;

        Cat cat = newMockCat();
        Dog dog = newMockDog();
        Rabbit rabbit = newMockRabbit();
        Hotel hotel = new Hotel();
        hotel.registerPet(cat);
        hotel.registerPet(cat);
        hotel.registerPet(dog);
        hotel.registerPet(rabbit);
        int outputBeforeCount = hotel.getGuestsCount();
        hotel.unregisterPet(cat);
        hotel.unregisterPet(dog);
        hotel.unregisterPet(rabbit);
        int outputAfterCount = hotel.getGuestsCount();

        assertEquals(expectedBeforeCount, outputBeforeCount);
        assertEquals(expectedAfterCount, outputAfterCount);
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

    @Test
    public void shouldBuildAListWithAllGuestsNamesAndTotal() {
        Pet pet1 = newMockDog();
        Pet pet2 = newMockCat();
        Pet pet3 = newMockRabbit();
        pet1.setName("MockPet 1");
        pet2.setName("MockPet 2");
        pet3.setName("MockPet 3");
        String expected0 = "Total guests: 3";
        String expected1 = "1. MockPet 1";
        String expected2 = "2. MockPet 2";
        String expected3 = "3. MockPet 3";

        Hotel hotel = new Hotel();
        hotel.registerPet(pet1);
        hotel.registerPet(pet2);
        hotel.registerPet(pet3);
        List<String> output = hotel.getGuestsListString();

        assertEquals(4, output.size());
        assertEquals(expected0, output.get(0));
        assertEquals(expected1, output.get(1));
        assertEquals(expected2, output.get(2));
        assertEquals(expected3, output.get(3));
    }
}