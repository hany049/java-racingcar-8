package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.RandomNumber;
import racingcar.model.TrialValidation;
import racingcar.model.NameParser;
import racingcar.model.MakeCar;
import racingcar.model.Racing;
import racingcar.model.Winner;

public class RacingController {

    private final RandomNumber numberGenerator = new RandomNumber();

    public void race() {
        String names = InputView.getCarName();
        NameParser nameparser = new NameParser(names);
        MakeCar makeCars = new MakeCar(nameparser.getNames(), numberGenerator);
        int trial = new TrialValidation(InputView.getTrialNumber()).getTrial();

        Racing racingGame = new Racing(makeCars.getCars(),trial);
        Winner winner = new Winner(racingGame.getCarsResult());

        OutputView.printResult();
        OutputView.printRacing(racingGame.getRoundResult());
        OutputView.printWinner(winner.getWinner());
    }
}
