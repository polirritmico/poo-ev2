package AirbnbPet;

import AirbnbPet.Pets.Pet;
import AirbnbPet.Pets.Rabbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private final Map<String, Pet> guests;

    public Hotel() {
        guests = new HashMap<>();
    }

    public Hotel(Map<String, Pet> guests) {
        this.guests = guests;
    }

    private List<String> validateVisitor(Pet visitor) {
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
        String guestId = checkGuest.getId();

        for (String currentId : guests.keySet()) {
            if (guestId.equals(currentId)) return true;

            Pet currentPet = guests.get(guestId);
            if (checkGuest == currentPet) return true;
        }
        return false;
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

    private void checkOutGuest(Pet guest) {
        guests.remove(guest.getId(), guest);
    }

    private List<Pet> getGuestsByType(String petType) {
        List<Pet> res = new ArrayList<>();
        for (Pet pet : guests.values()) {
            String currentPetType = pet.getClass().getSimpleName();
            if (currentPetType.equals(petType))
                res.add(pet);
        }
        return res;
    }

    private void checkOutRabbitGuest(Rabbit guest) {
        checkOutGuest(guest);
        guest.setHasNeighbors(false);

        List<Pet> rabbits = getGuestsByType("Rabbit");
        if (rabbits.size() == 1) {
            ((Rabbit) rabbits.getFirst()).setHasNeighbors(false);
        }
    }

    private void checkInRabbitGuest(Rabbit guest) {
        List<Pet> rabbits = getGuestsByType("Rabbit");
        if (rabbits.isEmpty())
            return;
        else if (rabbits.size() == 1)
            ((Rabbit) rabbits.getFirst()).setHasNeighbors(true);

        guest.setHasNeighbors(true);
    }

    public boolean registerPet(Pet incomingGuest) {
        List<String> validationResults = validateVisitor(incomingGuest);
        if (!validationResults.isEmpty()) {
            showErrorMessages(validationResults);
            return false;
        }

        if (incomingGuest instanceof Rabbit) {
            checkInRabbitGuest((Rabbit) incomingGuest);
        }

        checkInGuest(incomingGuest);
        return true;
    }

    public boolean unregisterPet(Pet departingGuest) {
        if (!isPetRegister(departingGuest)) {
            return false;
        }
        if (departingGuest instanceof Rabbit) {
            // TODO: If more Pets are neighbor-dependant, abstract this
            //  functionality into an interface, so more Pet subclasses could
            //  use the same logic.
            checkOutRabbitGuest((Rabbit) departingGuest);
        } else {
            checkOutGuest(departingGuest);
        }

        return true;
    }

    public int getGuestsCount() {
        return guests.size();
    }
}
