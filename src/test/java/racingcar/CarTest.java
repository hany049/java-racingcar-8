package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.model.RandomNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
class CarTest {

    private static class TestRandomNumber extends RandomNumber {
        private final int numberToReturn;

        public TestRandomNumber(int numberToReturn) {
            this.numberToReturn = numberToReturn;
        }

        @Override
        public int generateNumber() {
            return numberToReturn;
        }
    }

    @ParameterizedTest
    @CsvSource({
            "5, 1",  // 전진
            "3, 0",  // 정지
    })
    @DisplayName("Car 랜덤 값이 주어졌을 때 전진 혹은 정지 하는지 테스트")
    void car_Move_Or_Stop(int randomNumber, int expectedPosition) {
        RandomNumber testGenerator = new TestRandomNumber(randomNumber);
        Car car = new Car("testCar", testGenerator);

        car.move();

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("Racing 주행 완료 후 최종 위치가 올바른지 테스트")
    void racing_FinalPosition() {

        Car pobi = new Car("pobi", new TestRandomNumber(5));
        Car woni = new Car("woni", new TestRandomNumber(2));
        List<Car> cars = List.of(pobi, woni);

        int trial = 3;

        // Racing 객체는 3번의 trial 동안 pobi와 woni의 move()를 호출
        Racing racingGame = new Racing(cars, trial);
        List<Car> resultCars = racingGame.getCarsResult();

        // pobi는 3번 전진, woni는 3번 정지
        assertThat(resultCars.get(0).getCarName()).isEqualTo("pobi");
        assertThat(resultCars.get(0).getPosition()).isEqualTo(3);

        assertThat(resultCars.get(1).getCarName()).isEqualTo("woni");
        assertThat(resultCars.get(1).getPosition()).isEqualTo(0);
    }
}