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
        List<String> output = new ArrayList<String>();
        return output;
    }

    private void showErrorMessages(List<String> messages) {
    }

    private void checkInGuest(Pet guest) {
    }

    public boolean registerPet(Pet incomingGuest) {
        List<String> validationResults = validate(incomingGuest);
        if (!validationResults.isEmpty()) {
            showErrorMessages(validationResults);
        }

        checkInGuest(incomingGuest);
        return true;
    }
}
