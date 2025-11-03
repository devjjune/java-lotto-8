package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void run() {
        String purchaseAmount = InputView.readPurchaseAmount();

        Lottos lottos = service.purchaseLottos(purchaseAmount);
        OutputView.printIssuedLottos(lottos.getLottos());

        String winningNumber = InputView.readWinningNumber();
        String bonusNumber = InputView.readBonusNumber();

        WinningLotto winningLotto = service.drawWinningLotto(winningNumber, bonusNumber);

        Yields yields = service.calculateResults(purchaseAmount, lottos, winningLotto);

        OutputView.printStatistics(yields.getRankCount(), yields.getProfitRate());


    }

}
