package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumbersGenerator {

  private static final int LOTTO_SIZE = 6;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private List<Integer> createBaseNumbers() {
    return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
        .boxed()
        .collect(Collectors.toList());
  }

  @Override
  public List<Integer> generate() {
    List<Integer> baseNumbers = createBaseNumbers();
    Collections.shuffle(baseNumbers);
    List<Integer> integers = baseNumbers.subList(0, LOTTO_SIZE);
    integers.sort(Integer::compareTo);
    return integers;
  }
}
