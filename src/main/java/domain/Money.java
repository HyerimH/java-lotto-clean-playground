package domain;

public class Money {

  private static final int MINIMUM_PURCHASE_MONEY = 1000;
  private final int purchaseMoney;

  public Money(int value) {
    validatePurchaseMoney(value);
    this.purchaseMoney = value;
  }

  private void validatePurchaseMoney(int purchaseMoney) {
    if (purchaseMoney < MINIMUM_PURCHASE_MONEY) {
      throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
    }
  }

  public int getPurchaseMoney() {
    return purchaseMoney;
  }
}
