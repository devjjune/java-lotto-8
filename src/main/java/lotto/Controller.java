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

        Lottos lottos = Service.purchaseLottos(purchaseAmount);
        OutputView.printIssuedLottos(issuedLottos);

        String winningNumber = InputView.readWinningNumber();
        int bonusWinningNumber = Integer.parseInt(InputView.readBonusNumber());
        List<Integer> winningLottos = WinningLotto.makeLotto(winningNumber);
        Map<WinningRank, Integer> results = WinningLotto.compareLotto(issuedLottos, winningLottos, bonusWinningNumber);

        int totalRevenue = Yields.calculateTotalRevenue(results);
        double profitRate = Yields.calculateYields(totalRevenue, purchaseAmount);

        OutputView.printStatistics(results, profitRate);


    }

}
