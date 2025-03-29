package domain;

import java.util.List;

public class WinningNumbers {
  private final Lotto lotto;

  public WinningNumbers(List<Integer> numbers) {
    this.lotto = Lotto.createManual(numbers);
  }

  public int countMatches(List<Integer> lottoNumbers) {
    return (int) lottoNumbers.stream()
        .filter(this.lotto.getNumbers()::contains)
        .count();
  }

  public List<Integer> getNumbers() {
    return lotto.getNumbers();
  }
}
