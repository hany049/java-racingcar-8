package racingcar.model;

import java.util.List;

public class NameParser {

    private final List<String> names;

    public NameParser(String carNames) {
        this.names = splitName(carNames);
        validateDuplicate();
        validateLength();
    }

    private List<String> splitName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요!!!");
        }
        validationName(carName);
        return List.of(carName.split(","));
    }

    private void validationName(String name) {
        if (!name.matches("^[a-zA-Z]+(,[a-zA-Z]+)*$")) {
            throw new IllegalArgumentException("공백없이 알파벳과 쉼표(,)만 사용해 (이름,이름 ...) 형태로 입력하세요!!!");
        }
    }

    private void validateDuplicate(){
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("이름이 중복됩니다!!!");
        }
    }

    private void validateLength() {
        if (names.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("이름은 5자 이하로 작성하세요!!!");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
