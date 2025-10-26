package racingcar.model;

public class TrialValidation {

    private final int trial;

    public TrialValidation(String trialString) {
        this.trial = convert2int(trialString);
    }

    private int convert2int(String trial) {
        try {
            int trialNum = Integer.parseInt(trial);
            validation(trialNum);

            return trialNum;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하세요!!!");
        }
    }

    private void validation(int trialNum) {
        if (trialNum <= 0) {
            throw new IllegalArgumentException("자연수를 입력하세요!!!");
        }
    }

    public int getTrial() {
        return trial;
    }
}
