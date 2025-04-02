package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private static final int TICKET_PRICE = 1000;
  public static final int MINIMUM_PURCHASE_MONEY = 1000;

  private final List<Lotto> lottos;
  private final int ticketCount;
  private final int manualTicketCount;
  private final Money money;

  public Lottos(List<Lotto> lottos, int ticketCount, int manualTicketCount, Money money) {
    validateManualCount(ticketCount, manualTicketCount);
    this.lottos = new ArrayList<>(lottos);
    this.ticketCount = ticketCount;
    this.manualTicketCount = manualTicketCount;
    this.money = money;
  }

  public static Lottos from(int purchaseMoney, List<Lotto> manualLottos, LottoNumberGenerator lottoNumberGenerator) {
    Money money = new Money(purchaseMoney);
    int ticketCount = money.getTicketCount(TICKET_PRICE);
    int manualTicketCount = manualLottos.size();

    List<Lotto> lottoList = generateLottoList(manualLottos, ticketCount, lottoNumberGenerator);

    return new Lottos(lottoList, ticketCount, manualTicketCount, money);
  }

  private static List<Lotto> generateLottoList(List<Lotto> manualLottos, int ticketCount,
      LottoNumberGenerator lottoNumberGenerator) {
    List<Lotto> lottoList = new ArrayList<>(manualLottos);
    for (int i = 0; i < calculateAutoCount(ticketCount, manualLottos.size()); i++) {
      lottoList.add(Lotto.createAuto(lottoNumberGenerator));
    }
    return lottoList;
  }

  private static void validateManualCount(int ticketCount, int manualTicketCount) {
    validateManualCountExcess(ticketCount, manualTicketCount);
    validateNegativeManualCount(manualTicketCount);
  }

  private static void validateManualCountExcess(int ticketCount, int manualTicketCount) {
    if (manualTicketCount > ticketCount) {
      throw new IllegalArgumentException("수동 구매 수는 전체 티켓 수를 초과할 수 없습니다.");
    }
  }

  private static void validateNegativeManualCount(int manualTicketCount) {
    if (manualTicketCount < 0) {
      throw new IllegalArgumentException("수동 구매 수는 음수일 수 없습니다.");
    }
  }

  private static int calculateAutoCount(int ticketCount, int manualCount) {
    return ticketCount - manualCount;
  }

  public List<Lotto> getLottos() {
    return new ArrayList<>(lottos);
  }

  public Integer getTicketCount() {
    return ticketCount;
  }

  public Integer getManualTicketCount() {
    return manualTicketCount;
  }

  public Integer getAutoTicketCount() {
    return ticketCount - manualTicketCount;
  }

  public Money getMoney(){
    return money;
  }
}
