package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.NameParser;
import racingcar.model.TrialValidation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력 및 유효성 검증 테스트")
class NameTrialValidationTest {

    // NameParser 테스트

    @Test
    @DisplayName("NameParser 이름이 정상적으로 분리되는지 테스트")
    void nameParser_Success() {
        // given
        String input = "pobi,woni,crong";

        // when & then
        NameParser nameParser = new NameParser(input);
        assertThat(nameParser.getNames()).containsExactly("pobi", "woni", "crong");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "pobi,javaji",  // 5자 초과
            "pobi,woni,pobi", // 중복
            "",               // 빈 값
            "pobi, woni",     // 공백 포함
            "pobi,,woni"      // 연속 쉼표
    })
    @DisplayName("NameParser - 조건에 맞지 않은 입력 시 IllegalArgumentException 발생")
    void nameParser_Failure_IllegalArgumentException(String input) {
        assertThatThrownBy(() -> new NameParser(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TrialValidation 테스트

    @ParameterizedTest
    @ValueSource(strings = {
            "a",    // 숫자가 아님
            " ",    // 공백
            "1.5",  // 정수가 아님
            "0",    // 0
            "-5"    // 음수
    })
    @DisplayName("TrialValidation - 조건에 맞지 않은 입력 시 IllegalArgumentException 발생")
    void trialValidation_Failure_IllegalArgumentException(String input) {
        assertThatThrownBy(() -> new TrialValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}