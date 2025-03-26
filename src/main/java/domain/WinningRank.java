package domain;

import java.util.Arrays;

public enum WinningRank {
  NONE(0, 0L, "상금 없음"),
  THREE(3, 5_000L, "3개 일치 (5000원)"),
  FOUR(4, 50_000L, "4개 일치 (50000원)"),
  FIVE(5, 1_500_000L, "5개 일치 (1500000원)"),
  SIX(6, 2_000_000_000L, "6개 일치 (2000000000원)");

  private final int matchCount;
  private final long prize;
  private final String description;

  WinningRank(int matchCount, long prize, String description) {
    this.matchCount = matchCount;
    this.prize = prize;
    this.description = description;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public long getPrize() {
    return prize;
  }

  public String getDescription() {
    return description;
  }

  public static WinningRank valueof(int matches) {
    return Arrays.stream(values())
        .filter(WinningRank -> WinningRank.matchCount == matches)
        .findFirst()
        .orElse(WinningRank.NONE);
  }
}
