package view;

import domain.WinningNumbers;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public int getPurchaseMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    return scanner.nextInt();
  }

  public WinningNumbers getWinningNumbers() {
    System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    scanner.nextLine();
    String input = scanner.nextLine();
    List<Integer> numbers = Arrays.stream(input.split(", "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    return new WinningNumbers(numbers);
  }
}
