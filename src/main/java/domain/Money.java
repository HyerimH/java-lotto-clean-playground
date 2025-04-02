package domain;

public class Money {

  private final int purchaseMoney;

  public Money(int purchaseMoney) {
    validatePurchaseMoney(purchaseMoney);
    this.purchaseMoney = purchaseMoney;
  }

  private static void validatePurchaseMoney(int purchaseMoney) {
    if (purchaseMoney < Lottos.MINIMUM_PURCHASE_MONEY) {
      throw new IllegalArgumentException(
          "구입 금액은 " + Lottos.MINIMUM_PURCHASE_MONEY + "원 이상이어야 합니다."
      );
    }
  }

  public int getPurchaseMoney() {
    return purchaseMoney;
  }

  public int getTicketCount(int ticketPrice) {
    return purchaseMoney / ticketPrice;
  }
}
