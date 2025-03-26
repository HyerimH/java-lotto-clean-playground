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
    List<Integer> result = new ArrayList<>(6);

    for (int i = 0; i < 6; i++) {
      result.add(index < numbers.length ? numbers[index++] : 0);
    }

    return result;
  }
}
