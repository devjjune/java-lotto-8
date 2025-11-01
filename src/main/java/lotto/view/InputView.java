package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String purchaseAmountMessage = "구입금액을 입력해 주세요.";
    public static final String winningNumberMessage = "당첨 번호를 입력해 주세요.";
    public static final String bonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public static void readPurchaseAmount() {
        System.out.println(purchaseAmountMessage);
        String purchaseAmount = Console.readLine();

    }

    public static void readWinningNumber() {
        System.out.println(winningNumberMessage);
        String purchaseAmount = Console.readLine();

    }

    public static void readBonusNumber() {
        System.out.println(bonusNumberMessage);
        String purchaseAmount = Console.readLine();

    }

}
