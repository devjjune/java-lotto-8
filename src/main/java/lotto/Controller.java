package lotto;

import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.List;

public class Controller {
    public static void run() {
        // [입력]
        String purchaseAmount = InputView.readPurchaseAmount();
        String winningNumber = InputView.readWinningNumber();
        String bonusNumber = InputView.readBonusNumber();

        // [로또 발행]
        int lottoAmount = Lotto.calculateLottoAmount(purchaseAmount);
        List<Integer> randomNumbers = Lotto.pickRandomNumbers();
        List<List<Integer>> issuedLottos = Lotto.issueLottos(lottoAmount, randomNumbers);

    }

}
