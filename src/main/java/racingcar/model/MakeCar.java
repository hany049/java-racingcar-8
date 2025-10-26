package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class MakeCar {

    private final List<String> names;
    private final List<Car> cars;
    private final RandomNumber generateRandom;

    public MakeCar(List<String> names, RandomNumber generator) {
        this.names = names;
        this.generateRandom = generator;
        this.cars = makecars();
    }

    private List<Car> makecars() {
        return names.stream()
                    .map(name -> new Car(name, generateRandom))
                    .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
