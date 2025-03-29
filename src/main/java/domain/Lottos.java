package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private static final Integer TICKET_PRICE = 1000;
  private final List<Lotto> lottos;
  private final Integer ticketCount;

  private Lottos(List<Lotto> lottos) {
    this.lottos = new ArrayList<>(lottos);
  }

  public static Lottos createLottos(int amount, NumbersGenerator numbersGenerator) {
    List<Lotto> lottoList = new ArrayList<>();
    for (int i = 0; i < amount; i++) {
      lottoList.add(new Lotto(numbersGenerator));
    }
    return new Lottos(lottoList);
  }

  public List<Lotto> getLottos() {
    return new ArrayList<>(lottos);
  }
}
