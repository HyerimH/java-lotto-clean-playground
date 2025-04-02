package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {

  public static List<Integer> parseLottoNumbers(String input) {
    return Arrays.stream(input.split(", "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
