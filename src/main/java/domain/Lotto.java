package domain;

import java.util.List;

public class Lotto {
  private final NumbersGenerator numbersGenerator;
  private final List<Integer> numbers;

  public Lotto(NumbersGenerator numbersGenerators) {
    this.numbersGenerator = numbersGenerators;
    this.numbers = numbersGenerator.generate();
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
