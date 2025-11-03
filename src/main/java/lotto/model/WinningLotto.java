package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningLotto(String winningNumber, String bonusNumber) {
        this.winningNumber = parseWinningNumber(winningNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private List<Integer> parseWinningNumber(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
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
