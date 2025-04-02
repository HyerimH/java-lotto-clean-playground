import controller.LottoController;
import domain.LottoNumberGenerator;
import view.InputView;
import view.ResultView;

public class Application {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    LottoController lottoController = new LottoController(inputView, resultView, lottoNumberGenerator);
    lottoController.run();
  }
}
