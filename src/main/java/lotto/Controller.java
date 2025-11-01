package lotto;

import lotto.view.InputView;

public class Controller {
    public static void run() {
        InputView.readPurchaseAmount();
        InputView.readWinningNumber();
        InputView.readBonusNumber();

    }

}
