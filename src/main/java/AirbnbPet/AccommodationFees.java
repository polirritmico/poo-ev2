package AirbnbPet;

import java.util.Map;

// NOTE: Solo sigo las instrucciones al pie de la letra, pero encuentro que este
// no es el patrón correcto para utilizar interfaces. Que puedan almacenar datos
// no implica que se deba hacer. La idea es definir contratos de comportamiento,
// no almacenar valores y mezclar responsabilidades.
public interface AccommodationFees {
    int VALOR_DIA_ALOJAMIENTO = 25_000;

    Map<String, Integer> percentageIncreaseFeesByPetType = Map.of(
        "Dog", 7,
        "Cat", 5,
        "Rabbit", -7
    );

    int calculateValue(int days);
}