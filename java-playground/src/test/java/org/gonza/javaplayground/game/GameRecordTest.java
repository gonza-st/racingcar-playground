package org.gonza.javaplayground.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameRecordTest {

    private GameRecord sut;

    @BeforeEach
    public void setUp() {
        this.sut = new GameRecord();
    }

    @Test
    public void 누적횟수를_증가시킬수_있다() {
        String carName = "car1";
        Integer beforeCount = sut.getMoveCount(carName);

        Integer afterCount = sut.plusMoveCount(carName);
        Integer foundCount = sut.getMoveCount(carName);

        assertEquals(beforeCount + 1, afterCount);
        assertEquals(foundCount, afterCount);
    }

    @Test
    // plusMoveCount에 의존하는 테스트
    // plus 메소드 없이는 조회를 테스트할 수 없을까?
    public void 차량별_누적_이동횟수를_조회할_수_있다() {
        String carName = "car1";
        sut.plusMoveCount(carName);
        Integer count = sut.getMoveCount(carName);

        assertEquals(1, count);
    }

    @Test
    public void 누적횟수가_없으면_0을_반환한다() {
        String carName = "car1";
        Integer count = sut.getMoveCount(carName);

        assertEquals(0, count);
    }

    @Test
    public void 누적횟수가_가장_높은_차량을_조회할_수_있다() {
        sut.plusMoveCount("car1");
        sut.plusMoveCount("car1");
        sut.plusMoveCount("car2");

        List<String> result = sut.getCarWithLargestMoveCount();
        assertTrue(result.contains("car1"));
    }

    @Test
    public void 누적횟수가_가장_높은_차량은_복수일_수_있다() {
        sut.plusMoveCount("car1");
        sut.plusMoveCount("car1");
        sut.plusMoveCount("car2");
        sut.plusMoveCount("car2");

        List<String> result = sut.getCarWithLargestMoveCount();
        assertTrue(result.contains("car1"));
        assertTrue(result.contains("car2"));
    }

    @Test
    public void 누적횟수가_가장_높은_차량은_내림차순_정렬된다() {
        sut.plusMoveCount("car2");
        sut.plusMoveCount("car2");
        sut.plusMoveCount("car1");
        sut.plusMoveCount("car1");

        List<String> result = sut.getCarWithLargestMoveCount();
        assertEquals("car1", result.get(0));
        assertEquals("car2", result.get(1));
    }
}
