package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comparator {
    private final List<Map<String, Object>> compareResult;


    public Comparator(Lottos lottos, WinningLotto winningLotto){
        compareResult = compare(
                lottos.getLottos(),
                winningLotto.getWinningNumbers(),
                winningLotto.getBonusNumber()
        );
    }

    private List<Map<String, Object>> compare(List<List<Integer>> lottos, List<Integer> winningNumber, int bonusNumber) {
        List<Map<String, Object>> compareResult = new ArrayList<>();

        for (List<Integer> lotto : lottos) {
            List<Integer> temp = new ArrayList<>(lotto);
            temp.retainAll(winningNumber);

            int matchedCount = temp.size();
            boolean hasBonus = lotto.contains(bonusNumber);

            Map<String, Object> comparison = new HashMap<>();
            comparison.put("matchedCount", matchedCount);
            comparison.put("hasBonus", hasBonus);

            compareResult.add(comparison);

        }

        return compareResult;
    }

    public List<Map<String, Object>> getCompare() {
        return List.copyOf(compareResult);
    }

}
