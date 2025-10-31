package AirbnbPet;

import AirbnbPet.Pets.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private Map<String, Pet> guests = new HashMap<>();

    private boolean isPetCodeAlreadyRegister(String checkCode) {
        return false;
    }

    private List<String> validate(Pet visitor) {
        List<String> output = new ArrayList<>();

        if (!hasValidId(visitor)) {
            String msg = "Invalid id: '" + visitor.getId() + "'";
            output.add(msg);
        } else if (isPetRegister(visitor)) {
            String msg = "Duplicated id: '" + visitor.getId() + "'";
            output.add(msg);
        }

        return output;
    }

    private boolean hasValidId(Pet pet) {
        if (pet.getId() == null)
            return false;
        else if (pet.getId().isBlank())
            return false;

        return true;
    }

    boolean isPetRegister(Pet checkGuest) {
        return guests.containsKey(checkGuest.getId());
    }

    private void showErrorMessages(List<String> messages) {
        System.out.println("Errors found:");
        for (String err : messages) {
            System.out.println("- " + err);
        }
    }

    private void checkInGuest(Pet guest) {
        guests.put(guest.getId(), guest);
    }

    public boolean registerPet(Pet incomingGuest) {
        List<String> validationResults = validate(incomingGuest);
        if (!validationResults.isEmpty()) {
            showErrorMessages(validationResults);
            return false;
        }

        checkInGuest(incomingGuest);
        return true;
    }
}
