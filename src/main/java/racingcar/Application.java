package racingcar;

import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingGame = new RacingController();
        racingGame.race();
    }
}
