package domain;

public class Statistics {
  private final Lottos lottos;
  private final WinningNumbers winningNumbers;
  private final Money investedMoney;

  public Statistics(Lottos lottos, WinningNumbers winningNumbers, Money investedMoney) {
    this.lottos = lottos;
    this.winningNumbers = winningNumbers;
    this.investedMoney = investedMoney;
  }

  public int[] calculateMatchCounts(){
    int[] matchCounts = new int[7];
    for (Lotto lotto : lottos.getLottos()) {
      int matches = winningNumbers.countMatches(lotto.getNumbers());
      matchCounts[matches]++;
    }
    return matchCounts;
  }

  public long calculateTotalPrize(int[] matchCounts) {
    return matchCounts[3] * 5000L +
           matchCounts[4] * 50000L +
           matchCounts[5] * 1500000L +
           matchCounts[6] * 2000000000L;
  }

  public double calculateProfitRate(int[] matchCounts) {
    long totalPrize = calculateTotalPrize(matchCounts);
    return investedMoney.calculateProfitRate(totalPrize);
  }
}
