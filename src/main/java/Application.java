import controller.LottoController;
import domain.Lotto;
import domain.LottoConfig;
import domain.LottoNumberGenerator;
import domain.NumbersGenerator;
import view.InputView;
import view.ResultView;

public class Application {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    NumbersGenerator numbersGenerator = new LottoNumberGenerator(LottoConfig.MIN_NUMBER, LottoConfig.MAX_NUMBER,
        LottoConfig.LOTTO_SIZE);
    LottoController lottoController = new LottoController(inputView, resultView, numbersGenerator);
    lottoController.run();
  }
}
