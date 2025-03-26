package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

  @Test
  @DisplayName("당첨 번호가 6개 미만이면 예외가 발생한다")
  void throwExceptionWhenLessThanSixNumbers() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    assertThatThrownBy(() -> new WinningNumbers(numbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호는 6개여야 합니다.");
  }

  @Test
  @DisplayName("당첨 번호가 6개 초과면 예외가 발생한다")
  void throwExceptionWhenMoreThanSixNumbers() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
    assertThatThrownBy(() -> new WinningNumbers(numbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호는 6개여야 합니다.");
  }

  @Test
  @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다")
  void throwExceptionWhenDuplicateNumbers() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
    assertThatThrownBy(() -> new WinningNumbers(numbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호는 중복될 수 없습니다.");
  }

  @Test
  @DisplayName("당첨 번호가 1~45 범위를 벗어나면 예외가 발생한다")
  void throwExceptionWhenOutOfRange() {
    List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);
    assertThatThrownBy(() -> new WinningNumbers(numbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호는 1~45 사이여야 합니다.");
  }

  @Test
  @DisplayName("정상적인 6개 번호로 생성되면 일치 개수를 계산한다")
  void calculateMatchesWithValidNumbers() {
    // Given
    WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    List<Integer> lottoNumbers = List.of(1, 2, 3, 7, 8, 9);

    // When
    int matchCount = winningNumbers.countMatches(lottoNumbers);

    // Then
    assertThat(matchCount).isEqualTo(3);
  }
}
