package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다")
  void throwExceptionWhenLessThan1000() {
    assertThatThrownBy(() -> new Money(500))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("구입 금액" + LottoConfig.MINIMUM_PURCHASE_MONEY + "원 이상이어야 합니다.");
  }

  @Test
  @DisplayName("금액에 맞게 Money 객체가 생성된다")
  void createMoneyWithValidAmount() {
    // Given
    int validAmount = 2000;

    // When
    Money money = new Money(validAmount);

    // Then
    assertThat(money.getPurchaseMoney()).isEqualTo(2000);
  }
}
