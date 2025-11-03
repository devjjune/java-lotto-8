package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.EnumMap;

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

    public static Map<WinningRank, Integer> compareLotto(List<List<Integer>> issuedLottos, List<Integer> winningLottos, int bonusWinningNumber) {
        Map<WinningRank, Integer> results = new EnumMap<>(WinningRank.class);

        for (List<Integer> sixNumbers : issuedLottos) {
            long matchCount = sixNumbers.stream()
                    .filter(winningLottos::contains)
                    .count();
            boolean bonusMatch = sixNumbers.contains(bonusWinningNumber);

            WinningRank rank = WinningRank.valueOf((int) matchCount, bonusMatch);
            results.put(rank, results.getOrDefault(rank, 0) + 1);

        }
        return results;

    }
}
