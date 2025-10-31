package AirbnbPet;

import java.util.Map;

public interface AccommodationFees {
    static final int VALOR_DIA_ALOJAMIENTO = 25_000;

    static final Map<String, Integer> dailyPercentageFeesByPetType = Map.of(
            "Dog", 7,
            "Cat", 5,
            "Rabbit", -7
    );

    int calculateValue(int days);
}