package domain;

public class Money {

  private final long purchaseMoney;

  public Money(long purchaseMoney) {
    this.purchaseMoney = purchaseMoney;
  }

  public long getPurchaseMoney() {
    return purchaseMoney;
  }
}
