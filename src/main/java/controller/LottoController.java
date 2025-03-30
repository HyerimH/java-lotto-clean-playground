package controller;

import domain.Lottos;
import domain.Money;
import domain.NumbersGenerator;
import domain.Statistics;
import domain.WinningNumbers;
import view.InputView;
import view.ResultView;

public class LottoController {

  private final InputView inputView;
  private final ResultView resultView;
  private final NumbersGenerator numbersGenerator;

  public LottoController(InputView inputView, ResultView resultView, NumbersGenerator numbersGenerator) {
    this.inputView = inputView;
    this.resultView = resultView;
    this.numbersGenerator = numbersGenerator;
  }

  public void run() {
    // 구매 금액 처리
    int purchaseMoney = inputView.getPurchaseMoney();
    Money money = new Money(purchaseMoney);

    // 로또 생성 및 출력
    Lottos lottos = Lottos.createLottos(money, numbersGenerator);
    resultView.printLottos(lottos);

    // 당첨 번호 입력
    WinningNumbers winningNumbers = inputView.getWinningNumbers();

    // 당첨 결과 출력
    Statistics statistics = new Statistics(lottos, winningNumbers, money);
    resultView.printStatistics(statistics);
  }
}
