package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Racing {

    private final List<Car> cars;
    private final int trial;
    private final List<Map<String, Integer>> result = new ArrayList<>();

    public Racing(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
        moveCars();
    }

    private void moveCars() {
        for (int i = 0; i < trial; i++) {
            result.add(moveEachCar());
        }
    }

    private Map<String, Integer> moveEachCar() {
        Map<String, Integer> round = new LinkedHashMap<>();
        cars.forEach(car -> {
            car.move();
            round.put(car.getCarName(), car.getPosition());
        });

        return round;
    }

    public List<Map<String, Integer>> getRoundResult() {
        return result;
    }

    public List<Car> getCarsResult() {
        return cars;
    }
}
