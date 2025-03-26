package domain;

public class Money {
  private final int value;
  public static final Money LOTTO_PRICE=new Money(1000);

  public Money(int value) {
    this.value = value;
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
