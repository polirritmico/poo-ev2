package AirbnbPet;

import AirbnbPet.Pets.Cat;
import AirbnbPet.Pets.Dog;
import AirbnbPet.Pets.Pet;
import AirbnbPet.Pets.Rabbit;

import java.util.List;

public class App {
    public void run() {
        System.out.println("=== AirBnbPet ===\n");

        Hotel hotel = new Hotel();
        hotel.registerPet(new Dog(
            "dog-001", "Ringo", 20.5, 3, 6, true, 2
        ));
        hotel.registerPet(new Dog(
            "dog-002", "Lunita", 15.2, 2, 3, true, 3
        ));
        hotel.registerPet(new Dog(
            "dog-003", "Sandro", 18.0, 4, 0, false, 1
        ));

        hotel.registerPet(new Cat(
            "cat-001", "Mishi", 4.5, 2, 6, false, "Siamés"
        ));
        hotel.registerPet(new Cat(
            "cat-002", "Midi", 5.0, 3, 0, true, "Minitigre"
        ));

        hotel.registerPet(new Rabbit(
            "rabbit-001", "Trix", 2.2, 1, 6, false, "Zanahoria", true
        ));
        hotel.registerPet(new Rabbit(
            "rabbit-002", "Pelusa", 1.8, 2, 0, false, "Lechuga", false
        ));

        List<String> guestsList = hotel.getGuestsListString();
        int totalFee = 0;
        for (Pet pet : hotel.getGuests().values()) {
            totalFee += pet.calculateValue(1);
        }

        for (String line : guestsList)
            System.out.println(line);
        System.out.println("Valor total por 1 día: " + totalFee);


    }
}
