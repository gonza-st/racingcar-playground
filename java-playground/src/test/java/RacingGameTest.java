
import org.gonza.javaplayground.RacingGame;
import org.gonza.javaplayground.rule.GameRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {
    @Mock
    private GameRule gameRule;

    private RacingGame game;

    @BeforeEach
    public void setUp() throws Exception {
        this.game = new RacingGame(gameRule);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void should_be_able_to_start_game() throws NoSuchFieldException, IllegalAccessException {
        Boolean initialIsPlaying = getIsPlaying(game);
        assertFalse(initialIsPlaying);

        game.startGame();

        Boolean startedIsPlaying = getIsPlaying(game);
        assertTrue(startedIsPlaying);
    }

    @Test
    public void should_be_able_to_finish_game() throws NoSuchFieldException, IllegalAccessException {
        game.startGame();

        Boolean initialIsPlaying = getIsPlaying(game);
        assertTrue(initialIsPlaying);

        game.finishGame();

        Boolean finishedIsPlaying = getIsPlaying(game);
        assertFalse(finishedIsPlaying);
    }

    @Test
    public void should_be_false_when_instance_initialized() throws NoSuchFieldException, IllegalAccessException {
        Boolean isPlayingField = getIsPlaying(game);
        assertFalse(isPlayingField);
    }

    @Test
    public void should_decrease_one_count_by_every_race() throws NoSuchFieldException, IllegalAccessException {
        Integer racingCount = 3;
        game.assignRacingCount(racingCount);

        Integer initialCount = getRacingCount(game);
        assertEquals(racingCount, initialCount);

        game.race();
        Integer afterRaceCount = getRacingCount(game);
        assertEquals(afterRaceCount, initialCount - 1);
    }

    @Test
    public void should_assign_racing_count() throws NoSuchFieldException, IllegalAccessException {
        Integer initRacingCount = getRacingCount(game);
        assertNull(initRacingCount);

        Integer racingCount = 1;
        game.assignRacingCount(racingCount);

        Integer assignedRacingCount = getRacingCount(game);
        assertEquals(assignedRacingCount, racingCount);
    }

    @Nested
    class AssignCarNameTest {
        @Test
        public void should_assign_carName() throws NoSuchFieldException, IllegalAccessException {
            String initCarName = getCarNames(game);
            assertNull(initCarName);

            String carNames = "pobi,crong,honux";
            game.assignCarName(carNames);

            String assignedCarName = getCarNames(game);
            assertEquals(assignedCarName, carNames);
        }
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

        @Test
        public void should_contain_rule_as_private_Rule_type() throws NoSuchFieldException {
            Field field = getPrivateField("rule");
            assertTrue(Modifier.isPrivate(field.getModifiers()));
            assertEquals(GameRule.class, field.getType());
        }
    }

    private GameRule getGameRule(RacingGame game) throws NoSuchFieldException, IllegalAccessException {
        return (GameRule) game.getClass().getDeclaredField("rule").get(game);
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