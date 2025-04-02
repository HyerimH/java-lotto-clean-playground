package domain;

public class Money {

  private final int purchaseMoney;

  public Money(int value) {
    validatePurchaseMoney(value);
    this.purchaseMoney = value;
  }

  private void validatePurchaseMoney(int purchaseMoney) {
    if (purchaseMoney < LottoConfig.MINIMUM_PURCHASE_MONEY) {
      throw new IllegalArgumentException(
          "구입 금액은 " + LottoConfig.MINIMUM_PURCHASE_MONEY + "원 이상이어야 합니다."
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
