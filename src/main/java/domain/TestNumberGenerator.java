package domain;

import java.util.ArrayList;
import java.util.List;

public class TestNumberGenerator implements NumbersGenerator {

  private final int[] numbers;
  private int index;

  public TestNumberGenerator(int[] numbers) {
    this.numbers = numbers;
    this.index = 0;
  }

  @Override
  public List<Integer> generate() {
    if (index >= numbers.length) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    result.add(numbers[index++]);
    return result;
  }
}
