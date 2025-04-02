package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

  @Test
  @DisplayName("보너스 번호는 당첨 번호와 중복되지 않아야 한다")
  void bonusNumberShouldNotDuplicateWithWinningNumbers() {
    WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);

    assertThatThrownBy(() -> new BonusNumber(5, winningNumbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
  }
}
