package view;

import domain.WinningNumbers;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static int getInt() {
    return scanner.nextInt();
  }

  public WinningNumbers getWinningNumbers() {
    scanner.nextLine();
    String input = scanner.nextLine();
    List<Integer> numbers = Arrays.stream(input.split(", "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    return new WinningNumbers(numbers);
  }
}
