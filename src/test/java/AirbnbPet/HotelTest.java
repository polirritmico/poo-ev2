package AirbnbPet;

import AirbnbPet.Pets.Dog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HotelTest {
    @Test
    public void shouldRegisterIncomingPets() {
        Dog casePet = new Dog();

        Hotel hotel = new Hotel();
        boolean output = hotel.registerPet(casePet);
        assertTrue(output);
    }

    @Test
    public void shouldNotRegisterIncomingPetWithDuplicatedId() {
        Dog caseFirstPet = new Dog();
        Dog casePetWithDuplicatedId = new Dog();
        casePetWithDuplicatedId.setId(caseFirstPet.getId());

        Hotel hotel = new Hotel();
        hotel.registerPet(caseFirstPet);
        boolean output = hotel.registerPet(casePetWithDuplicatedId);

        assertFalse(output);
    }
}