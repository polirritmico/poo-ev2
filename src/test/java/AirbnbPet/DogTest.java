package AirbnbPet;

import AirbnbPet.Pets.Dog;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import static AirbnbPet.Mocks.newMockDog;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DogTest {
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
    void shouldRegisterAllExerciseSessions() {
        int expectedInitialExerciseSessions = 0;
        int expectedEndingExerciseSessions = 4;

        Dog dog = newMockDog();
        LocalDate today = LocalDate.now();
        int outputInitialExerciseSessions = dog.getDailyExerciseSessions();
        for (int i = 0; i < 3; i++)
            dog.registerNewExerciseSession(today);
        int outputEndingExerciseSessions = dog.registerNewExerciseSession(today);

        assertEquals(expectedInitialExerciseSessions, outputInitialExerciseSessions);
        assertEquals(expectedEndingExerciseSessions, outputEndingExerciseSessions);
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

    @Test
    void shouldGenerateAllMeaningfulPetData() {
        Dog casePet = new Dog(
            "mockdog-987",
            "MockReDog",
            4.2,
            7,
            3,
            true,
            0
        );
        String expectedId = "mockdog-987";
        String expectedName = "mockredog";
        String expectedWeight = "4.2 kg";
        String expectedYears = "7 years";
        String expectedMonths = "3 months";
        String expectedExerciseSessions = "exercise";
        String expectedSupervision = "requires night supervision";

        List<String> output = casePet.getData();
        assertTrue(substringInCollection(expectedId, output));
        assertTrue(substringInCollection(expectedName, output));
        assertTrue(substringInCollection(expectedWeight, output));
        assertTrue(substringInCollection(expectedYears, output));
        assertTrue(substringInCollection(expectedMonths, output));
        assertTrue(substringInCollection(expectedExerciseSessions, output));
        assertTrue(substringInCollection(expectedSupervision, output));
    }

    private boolean substringInCollection(String substr, List<String> collection) {
        substr = substr.toLowerCase();
        for (String str : collection) {
            str = str.toLowerCase();
            if (str.contains(substr.toLowerCase()))
                return true;
        }
        return false;
    }
}