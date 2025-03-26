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
    int[] testNumbers = {1, 2, 3, 4, 5, 6};
    NumbersGenerator numbersGenerator = new TestNumberGenerator(testNumbers);
    Lottos lottos = Lottos.createLottos(1, numbersGenerator);
    WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    Money investedMoney = new Money(1000);

    Statistics statistics = new Statistics(lottos, winningNumbers, investedMoney);

    // When
    Map<WinningRank, Integer> matchCounts = statistics.calculateMatchCounts();

    // Then
    assertThat(matchCounts.get(WinningRank.SIX)).isEqualTo(1);
    assertThat(matchCounts.get(WinningRank.FIVE)).isEqualTo(0);
    assertThat(matchCounts.get(WinningRank.FOUR)).isEqualTo(0);
  }
}
