package domain;

public class Money {
  private final int value;
  public static final Money LOTTO_PRICE=new Money(1000);

  public Money(int value) {
    validateTicketCount(value);
    this.value = value;
  }

  private void validateTicketCount(int value) {
    if (value < 1000) {
      throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
    }
  }

  public int calculateTicketCount(){
    return this.value / LOTTO_PRICE.getValue();
  }

  public double calculateProfitRate(long prize) {
    return (double) prize / this.value;
  }

  public int getValue() {
    return value;
  }
}
