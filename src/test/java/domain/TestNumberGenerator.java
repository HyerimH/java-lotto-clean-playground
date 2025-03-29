package domain;

import java.util.ArrayList;
import java.util.List;

public class TestNumberGenerator implements NumbersGenerator {

  private final int[][] numberSets;
  private int setIndex;

  public TestNumberGenerator(int[][] numberSets) {
    this.numberSets = numberSets;
    this.setIndex = 0;
  }

  public List<Integer> generate() {
    if (setIndex >= numberSets.length) {
      setIndex = 0;
    }
    int[] currentSet = numberSets[setIndex++];
    List<Integer> result = new ArrayList<>(6);
    for (int i = 0; i < 6; i++) {
      result.add(i < currentSet.length ? currentSet[i] : 0);
    }
    return result;
  }
}
