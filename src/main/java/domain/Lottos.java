package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private static final Integer TICKET_PRICE = 1000;
  private final List<Lotto> lottos;
  private final Integer ticketCount;

  private Lottos(List<Lotto> lottos, int ticketCount) {
    this.lottos = new ArrayList<>(lottos);
    this.ticketCount = ticketCount;
  }

  public static Lottos createLottos(Money money, NumbersGenerator numbersGenerator) {
    Integer ticketCount = money.getPurchaseMoney() / TICKET_PRICE;
    List<Lotto> lottoList = new ArrayList<>();
    for (int i = 0; i < ticketCount; i++) {
      lottoList.add(Lotto.createAuto(numbersGenerator));
    }
    return new Lottos(lottoList, ticketCount);
  }

  public List<Lotto> getLottos() {
    return new ArrayList<>(lottos);
  }

  public Integer getTicketCount() {
    return ticketCount;
  }
}
