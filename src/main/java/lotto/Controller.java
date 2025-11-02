package lotto;

import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    public static void run() {
        String purchaseAmount = InputView.readPurchaseAmount();

        int lottoAmount = Lotto.calculateLottoAmount(purchaseAmount);
        List<Integer> randomNumbers = Lotto.pickRandomNumbers();
        List<List<Integer>> issuedLottos = Lotto.issueLottos(lottoAmount, randomNumbers);
        OutputView.printIssuedLottos(issuedLottos);

        String winningNumber = InputView.readWinningNumber();
        String bonusNumber = InputView.readBonusNumber();

    }

}
