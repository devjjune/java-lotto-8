package lotto.model;

import lotto.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningLotto(String winningNumber, String bonusNumber) {
        Validator.validateWinningNumberFormat(winningNumber);

        String[] tokens = winningNumber.split(",");
        Validator.validateWinningNumberCount(tokens);
        Validator.validateWinningNumberRange(tokens);

        this.winningNumber = parseWinningNumber(tokens);

        Validator.validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber.trim());
    }

    private List<Integer> parseWinningNumber(String[] tokens) {
        return Arrays.stream(tokens)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    public List<Integer> getWinningNumbers() {
        return List.copyOf(winningNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
