package AirbnbPet;

import AirbnbPet.Pets.Cat;
import AirbnbPet.Pets.Dog;
import AirbnbPet.Pets.Rabbit;

public class Mocks {
    private static int prevId = 100;
    private static int dogCounter = 0;
    private static int catCounter = 0;
    private static int rabbitCounter = 0;

    public static Dog newMockDog() {
        String id = "mockId-" + (++prevId);
        String name = "Mock Dog " + (++dogCounter);
        return new Dog(
            id,
            name,
            17,
            3,
            4,
            true,
            0
        );
    }

    public static Cat newMockCat() {
        String id = "mockId-" + (++prevId);
        String name = "Mock Cat " + (++catCounter);
        return new Cat(
            id,
            name,
            4,
            2,
            6,
            false,
            "Siamese"
        );
    }

    public static Rabbit newMockRabbit() {
        String id = "mockId-" + (++prevId);
        String name = "Mock Rabbit " + (++rabbitCounter);
        return new Rabbit(
            id,
            name,
            2,
            1,
            2,
            false,
            "Lettuce"
        );
    }
}
