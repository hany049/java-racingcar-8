package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RandomNumber;
import racingcar.model.Winner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("우승자 판별 테스트")
class WinnerTest {

    private static class AlwaysMoveRandomNumber extends RandomNumber {
        @Override
        public int generateNumber() {
            return 4; // 항상 전진
        }
    }

    @Test
    @DisplayName("단독 우승 결과를 올바르게 판별한다")
    void singleWinnerTest() {
        // 주행 결과 (pobi: 5, woni: 3, boni: 1)
        RandomNumber generator = new AlwaysMoveRandomNumber();
        Car pobi = new Car("pobi", generator);
        Car woni = new Car("woni", generator);
        Car boni = new Car("boni", generator);

        for (int i = 0; i < 5; i++) pobi.move();
        for (int i = 0; i < 3; i++) woni.move();
        for (int i = 0; i < 1; i++) boni.move();

        List<Car> carResults = List.of(pobi, woni, boni);

        Winner winner = new Winner(carResults);
        List<String> winners = winner.getWinner();

        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("공동 우승 결과를 올바르게 판별한다")
    void jointWinnersTest() {
        // 주행 결과 (pobi: 5, woni: 3, boni: 5)
        RandomNumber generator = new AlwaysMoveRandomNumber();
        Car pobi = new Car("pobi", generator);
        Car woni = new Car("woni", generator);
        Car boni = new Car("boni", generator);

        // pobi 5칸, woni 3칸, boni 5칸
        for (int i = 0; i < 5; i++) pobi.move();
        for (int i = 0; i < 3; i++) woni.move();
        for (int i = 0; i < 5; i++) boni.move();

        List<Car> carResults = List.of(pobi, woni, boni);

        Winner winner = new Winner(carResults);
        List<String> winners = winner.getWinner();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "boni");
    }
}