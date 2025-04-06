package domain;

public class Money {

  private final long purchaseMoney;

  public Money(long purchaseMoney) {
    validatePurchaseMoney(purchaseMoney);
    this.purchaseMoney = purchaseMoney;
  }

  private static void validatePurchaseMoney(long purchaseMoney) {
    if (purchaseMoney < Lottos.MINIMUM_PURCHASE_MONEY) {
      throw new IllegalArgumentException(
          "구입 금액은 " + Lottos.MINIMUM_PURCHASE_MONEY + "원 이상이어야 합니다."
      );
    }
  }

  public long getPurchaseMoney() {
    return purchaseMoney;
  }

  public int getTicketCount(long ticketPrice) {
    return (int)(purchaseMoney / ticketPrice);
  }
}
