package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumbersGenerator {

  private static final List<Integer> BASE_NUMBERS = createBaseNumbers();

  private static List<Integer> createBaseNumbers() {
    return IntStream.rangeClosed(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)
        .boxed()
        .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
  }

  @Override
  public List<Integer> generate() {
    List<Integer> baseNumbers = new ArrayList<>(BASE_NUMBERS);
    Collections.shuffle(baseNumbers);
    List<Integer> result = baseNumbers.subList(0, Lotto.LOTTO_SIZE);
    result.sort(Integer::compareTo);
    return new ArrayList<>(result);
  }
}
