package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator{

  private final Random random;

  public LottoNumberGenerator(Random random) {
    this.random = random;
  }

  public LottoNumberGenerator() {
    this(new Random());
  }

  public List<Integer> generate(int minNumber, int maxNumber, int size) {
    List<Integer> baseNumbers = IntStream.rangeClosed(minNumber, maxNumber)
        .boxed()
        .collect(Collectors.toList());
    Collections.shuffle(baseNumbers, random);
    List<Integer> result = baseNumbers.subList(0, size);
    result.sort(Integer::compareTo);
    return new ArrayList<>(result);
  }
}
