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
        OutputView.printIssuedLottos(issuedLottos);

        String winningNumber = InputView.readWinningNumber();
        String bonusNumber = InputView.readBonusNumber();
        WinningLotto winningLotto = service.drawWinningLotto(winningNumber, bonusNumber);
        Comparator comparator = service.compareLottos(lottos, winningLotto);

        int totalRevenue = Yields.calculateTotalRevenue(results);
        double profitRate = Yields.calculateYields(totalRevenue, purchaseAmount);

        OutputView.printStatistics(results, profitRate);


    }

}
