package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final List<Integer> randomNumbers;

    public LottoGenerator() {
        randomNumbers = this.pickRandomNumbers();
    }

    private List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> getRandomNumbers() {
        return new ArrayList<>(randomNumbers);
    }

}
