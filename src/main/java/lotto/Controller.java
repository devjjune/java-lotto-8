package lotto;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.model.WinningRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
    public static void run() {
        String purchaseAmount = InputView.readPurchaseAmount();

        int lottoAmount = Lotto.calculateLottoAmount(purchaseAmount);
        List<Integer> randomNumbers = Lotto.pickRandomNumbers();
        List<List<Integer>> issuedLottos = Lotto.issueLottos(lottoAmount, randomNumbers);
        OutputView.printIssuedLottos(issuedLottos);

        String winningNumber = InputView.readWinningNumber();
        int bonusWinningNumber = Integer.parseInt(InputView.readBonusNumber());
        List<Integer> winningLottos = WinningLotto.makeLotto(winningNumber);
        Map<WinningRank, Integer> results = WinningLotto.compareLotto(issuedLottos, winningLottos, bonusWinningNumber);

    }

}
