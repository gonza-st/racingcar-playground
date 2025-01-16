package org.gonza.javaplayground;

import org.gonza.javaplayground.domain.Game;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPlaygroundApplication {

    public static void main(String[] args) {
        Game game = new Game().setup();
        game.play();
    }
}
