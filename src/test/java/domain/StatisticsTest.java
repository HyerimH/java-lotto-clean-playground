package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  @Test
  @DisplayName("로또 번호와 당첨 번호를 비교하여 당첨 등수를 제대로 계산하고 상금과 수익률을 계산한다.")
  void calculateMatchCounts() {
    // Given
    List<Lotto> lottoList = Arrays.asList(
        Lotto.createManual(Arrays.asList(1, 2, 3, 4, 5, 6)),
        Lotto.createManual(Arrays.asList(1, 2, 3, 4, 5, 7)),
        Lotto.createManual(Arrays.asList(1, 2, 3, 4, 5, 9)),
        Lotto.createManual(Arrays.asList(1, 2, 3, 4, 8, 9)),
        Lotto.createManual(Arrays.asList(1, 2, 3, 9, 10, 11)),
        Lotto.createManual(Arrays.asList(1, 2, 9, 10, 11, 12)),
        Lotto.createManual(Arrays.asList(1, 9, 10, 11, 12, 13))
    );
    Lottos lottos = new Lottos(lottoList, 7, 7, new Money(7000));
    WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);
    Money investedMoney = new Money(7000);
    Statistics statistics = new Statistics(lottos, winningNumbers, investedMoney, bonusNumber);

    // When
    Map<WinningRank, Integer> matchCounts = statistics.calculateMatchCounts();
    long totalPrize = statistics.calculateTotalPrize(matchCounts);
    double profitRate = statistics.calculateProfitRate(matchCounts);

    // Then
    assertThat(matchCounts.get(WinningRank.SIX)).isEqualTo(1);
    assertThat(matchCounts.get(WinningRank.FIVE_WITH_BONUS)).isEqualTo(1);
    assertThat(matchCounts.get(WinningRank.FIVE)).isEqualTo(1);
    assertThat(matchCounts.get(WinningRank.FOUR)).isEqualTo(1);
    assertThat(matchCounts.get(WinningRank.THREE)).isEqualTo(1);
    assertThat(matchCounts.get(WinningRank.NONE)).isEqualTo(2);

    assertThat(totalPrize).isEqualTo(
        WinningRank.SIX.getPrize() +
        WinningRank.FIVE_WITH_BONUS.getPrize() +
        WinningRank.FIVE.getPrize() +
        WinningRank.FOUR.getPrize() +
        WinningRank.THREE.getPrize()
    );

    assertThat(profitRate).isEqualTo((double) totalPrize / investedMoney.getPurchaseMoney());
  }
}
