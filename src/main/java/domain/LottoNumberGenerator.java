package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumbersGenerator {

  private final int minNumber;
  private final int maxNumber;
  private final int size;
  private final List<Integer> baseNumbers;

  public LottoNumberGenerator(int minNumber, int maxNumber, int size) {
    this.minNumber = minNumber;
    this.maxNumber = maxNumber;
    this.size = size;
    this.baseNumbers = createBaseNumbers();
  }

  private List<Integer> createBaseNumbers() {
    return IntStream.rangeClosed(minNumber, maxNumber)
        .boxed()
        .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
  }

  @Override
  public List<Integer> generate() {
    List<Integer> baseNumbers = new ArrayList<>(this.baseNumbers);
    Collections.shuffle(baseNumbers);
    List<Integer> result = baseNumbers.subList(0, size);
    result.sort(Integer::compareTo);
    return new ArrayList<>(result);
  }
}
