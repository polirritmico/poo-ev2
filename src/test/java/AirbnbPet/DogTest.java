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
            true,
            "MockReDog",
            4.2,
            7,
            3,
            0
        );
        String expectedId = "mockdog-987";
        String expectedName = "mockredog";
        String expectedWeight = "4.2 kg";
        String expectedYears = "7 years";
        String expectedMonths = "3 months";
        String expectedExerciseSessions = "exercise";
        String expectedSupervision = "requires supervision";

        List<String> output = casePet.getData();
        assertTrue(substringInCollection("mockdog-987", output));
        assertTrue(substringInCollection("mockredog", output));
        assertTrue(substringInCollection("4.2 kg", output));
        assertTrue(substringInCollection("7 years", output));
        assertTrue(substringInCollection("3 months", output));
        assertTrue(substringInCollection("exercise", output));
        assertTrue(substringInCollection("requires supervision", output));
    }

    private boolean substringInCollection(String substr, List<String> collection) {
        for (String str : collection)
            if (str.contains(substr))
                return true;
        return false;
    }
}