package lotto;

public class Validator {
    private Validator() {

    }

    public static void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 공백일 수 없습니다.");
        }
    }

    public static void validatePurchaseAmount(String input) {
        validateNotBlank(input);
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }

        int amount = Integer.parseInt(input);
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위의 양의 정수여야 합니다.");
        }
    }

    public static void validateWinningNumberFormat(String input) {
        validateNotBlank(input);
        if (!input.matches("^[0-9,\\s]+$")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 쉼표만 포함해야 합니다.");
        }
    }

    public static void validateWinningNumberCount(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        }
    }

    public static void validateWinningNumberRange(String[] numbers) {
        for (String number : numbers) {
            int n = Integer.parseInt(number.trim());
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateBonusNumber(String input) {
        validateNotBlank(input);
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        int bonus = Integer.parseInt(input);
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}
