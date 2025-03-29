package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  @Test
  @DisplayName("로또 번호와 당첨 번호를 비교하여 당첨 등수를 제대로 계산한다")
  void calculateMatchCounts() {
    // Given
    int[][] testNumbers = {
        {1, 2, 3, 4, 5, 6},
        {1, 2, 3, 4, 5, 7},
        {1, 2, 3, 4, 7, 8},
        {1, 2, 3, 7, 8, 9},
        {1, 2, 7, 8, 9, 10},
        {1, 7, 8, 9, 10, 11},
        {7, 8, 9, 10, 11, 12}
    };
    NumbersGenerator numbersGenerator = new TestNumberGenerator(testNumbers);
    Money money = new Money(7000);
    Lottos lottos = Lottos.createLottos(money, numbersGenerator);
    WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    Money investedMoney = new Money(7000);

    Statistics statistics = new Statistics(lottos, winningNumbers, investedMoney);

    // When
    Map<WinningRank, Integer> matchCounts = statistics.calculateMatchCounts();
    long totalPrize = statistics.calculateTotalPrize(matchCounts);
    double profitRate = statistics.calculateProfitRate(matchCounts);

    long expectedPrize =
        (WinningRank.SIX.getPrize() * 1) +
        (WinningRank.FIVE.getPrize() * 1) +
        (WinningRank.FOUR.getPrize() * 1) +
        (WinningRank.THREE.getPrize() * 1);

    assertThat(totalPrize).isEqualTo(expectedPrize);

    double expectedProfitRate = (double) expectedPrize / investedMoney.getPurchaseMoney();

    // Then
    assertThat(matchCounts.get(WinningRank.SIX)).isEqualTo(1);
    assertThat(matchCounts.get(WinningRank.FIVE)).isEqualTo(1);
    assertThat(matchCounts.get(WinningRank.FOUR)).isEqualTo(1);
    assertThat(matchCounts.get(WinningRank.THREE)).isEqualTo(1);
    assertThat(matchCounts.get(WinningRank.NONE)).isEqualTo(3);
    assertThat(profitRate).isEqualTo(expectedProfitRate);
  }
}
