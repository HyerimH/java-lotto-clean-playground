package domain;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;
  private final int number;

  public LottoNumber(int number) {
    validateRange(number);
    this.number = number;
  }

  private void validateRange(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException(
          "로또 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이여야 합니다."
      );
    }
  }

  public boolean isSameAs(LottoNumber other) {
    return this.number == other.number;
  }

  @Override
  public int compareTo(LottoNumber other) {
    return Integer.compare(this.number, other.number);
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
