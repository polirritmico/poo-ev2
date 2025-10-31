package AirbnbPet;

import AirbnbPet.Pets.Dog;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DogTest {
    private Dog newMockDog() {
        return new Dog(
            "mockId-123",
            true,
            "Mock Dog",
            6,
            5,
            5,
            0
        );
    }

    @Test
    void shouldSetAndGetPassedDogId() {
        String caseValue = "asdf1234";
        String expected = "asdf1234";

        Dog dog = newMockDog();
        dog.setId(caseValue);
        String output = dog.getId();

        assertEquals(expected, output);
    }

    @Test
    void shouldRegisterExerciseSessions() {
        Dog dog = newMockDog();
        int expected = 2;
        LocalDate today = LocalDate.now();
        assertEquals(0, dog.getDailyExerciseSessions());

        dog.registerNewExerciseSession(today);
        int output = dog.registerNewExerciseSession(today);
        assertEquals(expected, output);
    }

    @Test
    void shouldResetPreviousDayRegisterExerciseSessions() {
        int expectedStartingSessions = 0;
        int expectedYesterdaySessions = 2;
        int expectedTodaySessions = 1;

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        Dog dog = newMockDog();
        int outputStartingSessions = dog.getDailyExerciseSessions();
        dog.registerNewExerciseSession(yesterday);
        int outputYesterdaySessions = dog.registerNewExerciseSession(yesterday);
        int outputTodaySessions = dog.registerNewExerciseSession(today);

        assertEquals(expectedStartingSessions, outputStartingSessions);
        assertEquals(expectedYesterdaySessions, outputYesterdaySessions);
        assertEquals(expectedTodaySessions, outputTodaySessions);
    }
}