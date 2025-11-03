package lotto;

import lotto.model.*;

import java.util.List;
import java.util.Map;

public class Service {
    private Lottos purchasedLottos;
    private WinningLotto winningLotto;

    public Lottos purchaseLottos(String purchaseAmount) {
        return new Lottos(purchaseAmount);
    }

    public WinningLotto drawWinningLotto(String winningNumber, String bonusNumber) {
        return new WinningLotto(winningNumber, bonusNumber);
    }

    public Yields calculateResults(String purchaseAmount, Lottos lottos, WinningLotto winningLotto) {
        Comparator comparator = new Comparator(lottos, winningLotto);
        List<Map<String, Object>> compareResult = comparator.getCompare();

        return new Yields(compareResult, purchaseAmount);
    }

}
