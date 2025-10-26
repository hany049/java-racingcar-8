package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final List<String> winner;
    private final List<Car> cars;

    public Winner (List<Car> cars) {
        this.cars = cars;
        winner = findWinner();
    }

    private List<String> findWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                    .filter(car -> car.getPosition() == maxPosition)
                    .map(Car::getCarName)
                    .collect(Collectors.toList());
    }

    public List<String> getWinner() {
        return winner;
    }
}
