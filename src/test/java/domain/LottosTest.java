package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  @DisplayName("구입 금액 5500원으로 티켓을 생성할 때, 5개의 티켓만 생성된다")
  void createLottosWith5500() {
    // Given
    Money money = new Money(5500);
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(LottoConfig.MIN_NUMBER, LottoConfig.MAX_NUMBER,
        LottoConfig.LOTTO_SIZE);

    // When
    Lottos lottos = Lottos.createLottos(money, lottoNumberGenerator);

    // Then
    assertThat(lottos.getTicketCount()).isEqualTo(5);
    assertThat(lottos.getLottos()).hasSize(5);
    assertThat(lottos.getLottos().get(0).getNumbers()).hasSize(LottoConfig.LOTTO_SIZE);
  }

  @Test
  @DisplayName("구입 금액 6000원으로 티켓을 생성할 때, 6개의 티켓이 생성된다")
  void createLottosWith6000() {
    // Given
    Money money = new Money(6000);
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(LottoConfig.MIN_NUMBER, LottoConfig.MAX_NUMBER,
        LottoConfig.LOTTO_SIZE);

    // When
    Lottos lottos = Lottos.createLottos(money, lottoNumberGenerator);

    // Then
    assertThat(lottos.getTicketCount()).isEqualTo(6);
    assertThat(lottos.getLottos()).hasSize(6);
    assertThat(lottos.getLottos().get(0).getNumbers()).hasSize(LottoConfig.LOTTO_SIZE);
  }
}
