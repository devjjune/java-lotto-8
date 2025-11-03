package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;

public class InputView {
    public static final String purchaseAmountMessage = "구입금액을 입력해 주세요.";
    public static final String winningNumberMessage = "당첨 번호를 입력해 주세요.";
    public static final String bonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public static String readPurchaseAmount() {
        System.out.println();
        System.out.println(purchaseAmountMessage);
        String purchaseAmount = Console.readLine();
        Validator.validateNotBlank(purchaseAmount);

        return purchaseAmount;

    }

    public static String readWinningNumber() {
        System.out.println();
        System.out.println(winningNumberMessage);
        String winningNumber = Console.readLine();
        Validator.validateNotBlank(winningNumber);

        return winningNumber;

    }

    public static String readBonusNumber() {
        System.out.println(bonusNumberMessage);
        String bonusNumber = Console.readLine();
        Validator.validateNotBlank(bonusNumber);

        return bonusNumber;

    }

}
