package org.gonza.javaplayground.car;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingTest {
    @Test
    void Racing은_Car를_생성할_수_있다() {
        List<String> names = List.of("test1", "test2", "test3");

        Racing racing = new Racing(names);

        assertEquals(names.size(), racing.countPlayers());
    }

    @Test
    void Car의_이름이_6자를_초과하면_예외가_발생한다() {
        List<String> names = List.of("123456");

        assertThrows(IllegalArgumentException.class, () -> new Racing(names));
    }

    @Test
    void 숫자가_4_이상인_Car만_이동한다() {
        Racing racing = new Racing(List.of("test1", "test2"));

        RaceResult result = racing.race(List.of(3, 4));

        assertEquals(1, result.findWinner().getFirst().getPosition());
        assertEquals("test2", result.findWinner().getFirst().getName());
    }

    @Test
    void Racing의_Car는_숫자_4_이상이면_이동한다() {
        Racing racing = new Racing(List.of("test1"));

        RaceResult result = racing.race(List.of(4));

        assertEquals(1, result.findWinner().getFirst().getPosition());
    }

    @Test
    void Racing의_Car는_숫자_4_미만이면_이동하지_않는다() {
        Racing racing = new Racing(List.of("test1"));

        RaceResult result = racing.race(List.of(3));

        assertEquals(0, result.findWinner().getFirst().getPosition());
    }

    @Test
    void 결과를_출력할_수_있다() {
        Racing racing = new Racing(List.of("test1", "test2"));

        RaceResult firstResult = racing.race(List.of(4, 4));
        assertEquals("test1 : -\ntest2 : -", firstResult.report());

        RaceResult secondResult = racing.race(List.of(4, 4));
        assertEquals("test1 : --\ntest2 : --", secondResult.report());

        RaceResult thirdResult = racing.race(List.of(3, 4));
        assertEquals("test1 : --\ntest2 : ---", thirdResult.report());
    }
}