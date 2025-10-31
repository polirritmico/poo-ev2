package AirbnbPet;

import AirbnbPet.Pets.Dog;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class DogTest {
    @Test
    void shouldSetAndGetPassedDogId() {
        String caseValue = "asdf1234";
        String expected = "asdf1234";

        Dog dog = new Dog();
        dog.setId(caseValue);
        String output = dog.getId();

        assertEquals(expected, output);
    }
}