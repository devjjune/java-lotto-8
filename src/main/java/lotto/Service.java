package lotto;

import lotto.model.Lottos;
import lotto.model.WinningLotto;

public class Service {
    private Lottos purchasedLottos;
    private WinningLotto winningLotto;

    public Lottos purchaseLottos(String purchaseAmount) {
        return new Lottos(purchaseAmount);
    }

    public WinningLotto drawWinningLotto(String winningNumber, String bonusNumber) {
        return new WinningLotto(winningNumber, bonusNumber);
    }

}
