package domain;

import java.util.List;
public class WinningNumbers {
  private final List<Integer> numbers;

  public WinningNumbers(List<Integer> numbers) {
    this.numbers = List.copyOf(numbers);
  }

  public int countMatches(List<Integer> lottoNumbers) {
    return (int) lottoNumbers.stream()
        .filter(this.numbers::contains)
        .count();
  }
}
