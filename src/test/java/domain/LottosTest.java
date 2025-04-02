package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  @DisplayName("구입 금액 5500원으로 티켓을 생성할 때, 5개의 티켓만 생성된다")
  void createLottosWith5500() {
    // Given
    int purchaseMoney = 5500;
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    // When
    Lottos lottos = Lottos.from(purchaseMoney, new ArrayList<>(), lottoNumberGenerator);

    // Then
    assertThat(lottos.getTicketCount()).isEqualTo(5);
    assertThat(lottos.getLottos()).hasSize(5);
  }

  @Test
  @DisplayName("구입 금액 6000원으로 티켓을 생성할 때, 6개의 티켓이 생성된다")
  void createLottosWith6000() {
    // Given
    int purchaseMoney = 6000;
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    // When
    Lottos lottos = Lottos.from(purchaseMoney, new ArrayList<>(), lottoNumberGenerator);

    // Then
    assertThat(lottos.getTicketCount()).isEqualTo(6);
    assertThat(lottos.getLottos()).hasSize(6);
  }
}
