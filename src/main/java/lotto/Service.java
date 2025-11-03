package lotto;

import lotto.model.Comparator;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

import java.util.List;

public class Service {
    private Lottos purchasedLottos;
    private WinningLotto winningLotto;

    public Lottos purchaseLottos(String purchaseAmount) {
        return new Lottos(purchaseAmount);
    }

    public WinningLotto drawWinningLotto(String winningNumber, String bonusNumber) {
        return new WinningLotto(winningNumber, bonusNumber);
    }

    public Comparator compareLottos(Lottos lottos, WinningLotto winningLotto) {
        return new Comparator(lottos, winningLotto);
    }

}
