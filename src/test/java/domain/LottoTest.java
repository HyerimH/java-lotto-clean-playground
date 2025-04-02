package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  @DisplayName("로또 번호는 1부터 45 사이를 벗어나면 예외가 발생한다.")
  void lottoNumberShouldThrowExceptionWhenOutOfRange() {
    List<Integer> invalidNumbers = List.of(0, 1, 2, 3, 4, 46);

    assertThatThrownBy(() -> Lotto.createManual(invalidNumbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호는 1~45 사이여야 합니다.");
  }

  @Test
  @DisplayName("생성된 로또 번호는 6개여야 한다")
  void ManuallottoNumberShouldHave6Numbers() {
    // Given
    List<Integer> invalidNumbersLess = List.of(1, 2, 3, 4, 5);
    List<Integer> invalidNumbersMore = List.of(1, 2, 3, 4, 5, 6, 7);

    // When & Then
    assertThatThrownBy(() -> Lotto.createManual(invalidNumbersLess))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호는 6개여야 합니다.");

    assertThatThrownBy(() -> Lotto.createManual(invalidNumbersMore))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호는 6개여야 합니다.");

  }

  @Test
  @DisplayName("생성된 로또 번호에 중복이 있으면 예외가 발생한다")
  void manualLottoNumberShouldThrowExceptionWhenDuplicatesExist() {
    // Given
    List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

    // When & Then
    assertThatThrownBy(() -> Lotto.createManual(duplicateNumbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호는 중복될 수 없습니다.");
  }
}
