import org.gonza.javaplayground.RacingGame;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {
    @Test
    public void contextLoads() {
    }

    @Test
    public void should_be_false_when_instance_initialized() throws NoSuchFieldException, IllegalAccessException {
        RacingGame game = new RacingGame();
        Boolean isPlayingField = getIsPlaying(game);
        assertFalse(isPlayingField);
    }

    @Test
    public void should_decrease_one_count_by_every_race() throws NoSuchFieldException, IllegalAccessException {
        Integer racingCount = 3;
        RacingGame racingGame = new RacingGame();
        racingGame.assignRacingCount(racingCount);

        Integer initialCount = getRacingCount(racingGame);
        assertEquals(racingCount, initialCount);

        racingGame.race();
        Integer afterRaceCount = getRacingCount(racingGame);
        assertEquals(afterRaceCount, initialCount - 1);
    }

    @Test
    public void should_assign_carName() throws NoSuchFieldException, IllegalAccessException {
        RacingGame game = new RacingGame();

        String initCarName = getCarNames(game);
        assertNull(initCarName);

        String carNames = "pobi,crong,honux";
        game.assignCarName(carNames);

        String assignedCarName = getCarNames(game);
        assertEquals(assignedCarName, carNames);
    }

    @Test
    public void should_assign_racing_count() throws NoSuchFieldException, IllegalAccessException {
        RacingGame game = new RacingGame();

        Integer initRacingCount = getRacingCount(game);
        assertNull(initRacingCount);

        Integer racingCount = 1;
        game.assignRacingCount(racingCount);

        Integer assignedRacingCount = getRacingCount(game);
        assertEquals(assignedRacingCount, racingCount);
    }

    @Nested
    class StructureTest {
        @Test
        public void should_contain_car_names_as_private_string_type() throws NoSuchFieldException {
            Field field = getPrivateField("carNames");

            assertTrue(Modifier.isPrivate(field.getModifiers()));
            assertEquals(String.class, field.getType());
        }

        @Test
        public void should_contain_race_count_as_private_Integer_type() throws NoSuchFieldException {
            Field field = getPrivateField("racingCount");
            assertTrue(Modifier.isPrivate(field.getModifiers()));
            assertEquals(Integer.class, field.getType());
        }

        @Test
        public void should_contain_isPlaying_as_private_Boolean_type() throws NoSuchFieldException {
            Field field = getPrivateField("isPlaying");
            assertTrue(Modifier.isPrivate(field.getModifiers()));
            assertEquals(Boolean.class, field.getType());
        }
    }

    private Boolean getIsPlaying(RacingGame game) throws NoSuchFieldException, IllegalAccessException {
        return (Boolean) getPrivateField("isPlaying").get(game);
    }

    private Integer getRacingCount(RacingGame game) throws NoSuchFieldException, IllegalAccessException {
        return (Integer) getPrivateField("racingCount").get(game);
    }

    private String getCarNames(RacingGame game) throws NoSuchFieldException, IllegalAccessException {
        return (String) getPrivateField("carNames").get(game);
    }

    private Field getPrivateField(String fieldName) throws NoSuchFieldException {
        Field field = RacingGame.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field;
    }
}
