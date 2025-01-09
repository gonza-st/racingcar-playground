import org.gonza.javaplayground.RacingGame;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {
    @Test
    public void contextLoads() {
    }

    @Test
    public void should_contain_car_names_as_private_string_type() throws NoSuchFieldException {
        Field field = getPrivateField("carNames");

        assertTrue(Modifier.isPrivate(field.getModifiers()));
        assertEquals(String.class, field.getType());
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

    private String getCarNames(RacingGame game) throws NoSuchFieldException, IllegalAccessException {
        return (String) getPrivateField("carNames").get(game);
    }

    private Field getPrivateField(String fieldName) throws NoSuchFieldException {
        Field field = RacingGame.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field;
    }
}
