package domain;

public class BonusNumber {

  private final int number;

  public BonusNumber(int number, WinningNumbers winningNumbers) {
    Lotto.validateBonusNumber(number);
    validateNotInWinningNumbers(number, winningNumbers);
    this.number = number;
  }

  private void validateNotInWinningNumbers(int number, WinningNumbers winningNumbers) {
    if (winningNumbers.getNumbers().contains(number)) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
  }

  public int getNumber() {
    return number;
  }
}
