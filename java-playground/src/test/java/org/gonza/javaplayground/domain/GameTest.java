package org.gonza.javaplayground.domain;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void 게임을_시작할_수_있다() {
        Game game = new Game();
        System.setIn(new ByteArrayInputStream("CarA,CarB,CarC\n 5".getBytes()));
        game.setup();
    }

    @Test
    void 승자를_검증할_수_있다() {
        Game game = new Game();
        System.setIn(new ByteArrayInputStream("CarA,CarB,CarC\n 5".getBytes()));
        game.setup();
        game.play();
        ArrayList<Car> winner = game.getWinner();
        Assertions.assertFalse(winner.isEmpty());
    }
}
