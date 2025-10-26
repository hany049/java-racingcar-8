package racingcar.model;

public class Car {
    private final String carName;
    private final RandomNumber generateRandom;
    private int position = 0;

    public Car(String name,RandomNumber generator) {
        this.carName = name;
        this.generateRandom = generator;
    }

    public void move() {
        if (generateRandom.generateNumber() >= 4) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
