package lotto.model;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.EnumMap;

public class WinningLotto {

    public static List<Integer> makeLotto(String winningNumber) {
        List<String> winningNumbers = Arrays.asList(winningNumber.split(","));

        List<Integer> winningLottos = winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningLottos;

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
