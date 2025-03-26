package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

  private final List<Integer> numbers;

  public WinningNumbers(List<Integer> numbers) {
    validate(numbers);
    this.numbers = List.copyOf(numbers);
  }

  private void validate(List<Integer> numbers) {
    validateSize(numbers);
    validateDuplicates(numbers);
    validateRange(numbers);
  }

  private void validateSize(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
    }
  }

  private void validateDuplicates(List<Integer> numbers) {
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != 6) {
      throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
    }
  }

  private void validateRange(List<Integer> numbers) {
    if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
      throw new IllegalArgumentException("당첨 번호는 1~45 사이여야 합니다.");
    }
  }

  public int countMatches(List<Integer> lottoNumbers) {
    return (int) lottoNumbers.stream()
        .filter(this.numbers::contains)
        .count();
  }

  public List<Integer> getNumbers() {
    return new ArrayList<>(numbers);
  }
}
