package view;

import domain.Lotto;
import domain.Lottos;
import domain.Statistics;
import domain.WinningRank;
import java.util.Map;

public class ResultView {

  public void printLottos(Lottos lottos) {
    System.out.println("\n" + lottos.getLottos().size() + "개를 구매했습니다.");
    for (Lotto lotto : lottos.getLottos()) {
      System.out.println(lotto.getNumbers());
    }
  }

  public void printStatistics(Statistics statistics) {
    System.out.println("\n당첨 통계");
    System.out.println("---------");
    Map<WinningRank, Integer> matchCounts = statistics.calculateMatchCounts();
    printMatchResults(matchCounts);
    printProfitRate(statistics, matchCounts);
  }

  private void printMatchResults(Map<WinningRank, Integer> matchCounts) {
    printRankResult(WinningRank.THREE, matchCounts);
    printRankResult(WinningRank.FOUR, matchCounts);
    printRankResult(WinningRank.FIVE, matchCounts);
    printRankResult(WinningRank.SIX, matchCounts);
  }

  private void printRankResult(WinningRank rank, Map<WinningRank, Integer> matchCounts) {
    if (rank != WinningRank.NONE) {
      System.out.println(rank.getDescription() + "- " + matchCounts.get(rank) + "개");
    }
  }

  private void printProfitRate(Statistics statistics, Map<WinningRank, Integer> matchCounts) {
    double profitRate = statistics.calculateProfitRate(matchCounts);
    System.out.printf("총 수익률은 %.2f입니다.%n", profitRate);
  }
}
