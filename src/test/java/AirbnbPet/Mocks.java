package AirbnbPet;

import AirbnbPet.Pets.Dog;

public class Mocks {
    private static int prevId = 100;
    private static int dogCounter = 0;

    public static Dog newMockDog() {
        String id = "mockId-" + (++prevId);
        String name = "Mock Dog " + (++dogCounter);
        return new Dog(
            id,
            true,
            name,
            6,
            5,
            5,
            0
        );
    }

}
