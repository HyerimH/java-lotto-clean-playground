package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

  private final Random random;

  public LottoNumberGenerator(Random random) {
    this.random = random;
  }

  public LottoNumberGenerator() {
    this(new Random());
  }

  public List<LottoNumber> generate() {
    List<Integer> baseNumbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
        .boxed()
        .collect(Collectors.toCollection(ArrayList::new));
    Collections.shuffle(baseNumbers, random);
    List<Integer> result = baseNumbers.subList(0, Lotto.LOTTO_SIZE);
    List<LottoNumber> lottoNumbers = result.stream()
        .map(LottoNumber::new)
        .sorted()
        .toList();
    return new ArrayList<>(lottoNumbers);
  }
}
