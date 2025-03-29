package domain;

import java.util.EnumMap;
import java.util.Map;

public class Statistics {

  private final Lottos lottos;
  private final WinningNumbers winningNumbers;
  private final Money investedMoney;

  public Statistics(Lottos lottos, WinningNumbers winningNumbers, Money investedMoney) {
    this.lottos = lottos;
    this.winningNumbers = winningNumbers;
    this.investedMoney = investedMoney;
  }

  private Map<WinningRank, Integer> initializeMatchCounts() {
    Map<WinningRank, Integer> matchCounts = new EnumMap<>(WinningRank.class);
    for (WinningRank winningRank : WinningRank.values()) {
      matchCounts.put(winningRank, 0);
    }
    return matchCounts;
  }

  public Map<WinningRank, Integer> calculateMatchCounts() {
    Map<WinningRank, Integer> matchCounts = initializeMatchCounts();
    for (Lotto lotto : lottos.getLottos()) {
      int matches = winningNumbers.countMatches(lotto.getNumbers());
      WinningRank rank = WinningRank.valueof(matches);
      matchCounts.put(rank, matchCounts.get(rank) + 1);
    }
    return matchCounts;
  }

  public long calculateTotalPrize(Map<WinningRank, Integer> matchCounts) {
    long totalPrize = 0;
    for (WinningRank rank : WinningRank.values()) {
      totalPrize += rank.getPrize() * matchCounts.get(rank);
    }
    return totalPrize;
  }

  private double calculateProfitRate(long prize) {
    return (double) prize / investedMoney.getPurchaseMoney();
  }

  public double calculateProfitRate(Map<WinningRank, Integer> matchCounts) {
    long totalPrize = calculateTotalPrize(matchCounts);
    return calculateProfitRate(totalPrize);
  }
}
