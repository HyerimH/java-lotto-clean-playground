package view;

import domain.Lotto;
import domain.Lottos;
import domain.Statistics;

public class ResultView {

  public static void printPurchaseMessage() {
    System.out.println("구입금액을 입력해 주세요.");
  }

  public void printLottos(Lottos lottos) {
    System.out.println("\n"+lottos.getLottos().size()+"개를 구매했습니다.");
    for (Lotto lotto : lottos.getLottos()) {
      System.out.println(lotto.getNumbers());
    }
  }

  public void printWinningNumber() {
    System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
  }

  public void printStatistics(Statistics statistics) {    System.out.println("\n당첨 통계");
    System.out.println("---------");
    int[] matchCounts = statistics.calculateMatchCounts();
    printMatchResults(matchCounts);
    printProfitRate(statistics, matchCounts);
  }

  private void printMatchResults(int[] matchCounts) {
    System.out.println("3개 일치 (5000원)- " + matchCounts[3] + "개");
    System.out.println("4개 일치 (50000원)- " + matchCounts[4] + "개");
    System.out.println("5개 일치 (1500000원)- " + matchCounts[5] + "개");
    System.out.println("6개 일치 (2000000000원)- " + matchCounts[6] + "개");
  }

  private void printProfitRate(Statistics statistics, int[] matchCounts) {
    double profitRate = statistics.calculateProfitRate(matchCounts);
    System.out.printf("총 수익률은 %.2f입니다.%n", profitRate);
  }
}
