package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  @DisplayName("구입 금액이 Lottos.MINIMUM_PURCHASE_MONEY 미만이면 예외가 발생한다")
  void throwExceptionWhenLessThanMinimumPurchaseMoney() {
    // given
    int invalidMoney = 500;

    // when & then
    assertThatThrownBy(() -> new Money(invalidMoney))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("구입 금액은 " + Lottos.MINIMUM_PURCHASE_MONEY + "원 이상이어야 합니다.");
  }

  @Test
  @DisplayName("금액에 맞게 Money 객체가 생성된다")
  void createMoneyWithValidAmount() {
    // given
    int purchaseMoney = 2000;

    // when
    Money money = new Money(purchaseMoney);

    // then
    assertThat(money.getTicketCount(1000)).isEqualTo(2);
  }
}
