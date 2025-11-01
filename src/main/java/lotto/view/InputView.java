package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String purchaseAmountMessage = "구입금액을 입력해 주세요.";
    public static final String winningNumberMessage = "당첨 번호를 입력해 주세요.";
    public static final String bonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public static String readPurchaseAmount() {
        System.out.println(purchaseAmountMessage);
        String purchaseAmount = Console.readLine();

        return purchaseAmount;

    }

    public static String readWinningNumber() {
        System.out.println(winningNumberMessage);
        String winningNumber = Console.readLine();

        return winningNumber;

    }

    public static String readBonusNumber() {
        System.out.println(bonusNumberMessage);
        String bonusNumber = Console.readLine();

        return bonusNumber;

    }

}
