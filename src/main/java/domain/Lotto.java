package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  private static final int LOTTO_SIZE = 6;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private final List<Integer> numbers;

  private Lotto(List<Integer> numbers) {
    this.numbers = new ArrayList<>(numbers);
  }

  public static Lotto createAuto(LottoNumberGenerator lottoNumberGenerator) {
    List<Integer> generatedNumbers = lottoNumberGenerator.generate(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);    validate(generatedNumbers);
    return new Lotto(generatedNumbers);
  }

  public static Lotto createManual(List<Integer> manualNumbers) {
    validate(manualNumbers);
    return new Lotto(manualNumbers);
  }

  private static void validate(List<Integer> numbers) {
    validateSize(numbers);
    validateDuplicates(numbers);
    validateRange(numbers);
  }

  private static void validateSize(List<Integer> numbers) {
    if (numbers.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
    }
  }

  private static void validateDuplicates(List<Integer> numbers) {
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
    }
  }

  private static void validateRange(List<Integer> numbers) {
    if (numbers.stream().anyMatch(n -> n < MIN_NUMBER || n > MAX_NUMBER)) {
      throw new IllegalArgumentException("당첨 번호는 1~45 사이여야 합니다.");
    }
  }

  public static void validateBonusNumber(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException("보너스 번호는 1~45 사이여야 합니다.");
    }
  }

  public List<Integer> getNumbers() {
    return new ArrayList<>(numbers);
  }
}
