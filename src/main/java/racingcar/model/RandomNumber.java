package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public int generateNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
