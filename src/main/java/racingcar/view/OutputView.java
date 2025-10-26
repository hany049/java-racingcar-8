package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRacing(List<Map<String, Integer>> results) {
        for (Map<String, Integer> result : results) {
            printPosition(result);
        }
    }

    private static void printPosition(Map<String, Integer> cars) {
        cars.forEach((carName, position) ->
                System.out.println(carName + " : " +"-".repeat(position)));
        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
