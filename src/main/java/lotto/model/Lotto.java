package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public static int calculateLottoAmount(String purchaseAmount) {
        int lottoAmount = Integer.parseInt(purchaseAmount) / 1000;

        return lottoAmount;
    }

    public static List<Integer> pickRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return randomNumbers;
    }

    public static List<List<Integer>> issueLottos(int lottoAmount, List<Integer> randomNumbers) {
        List<List<Integer>> issuedLottos = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            randomNumbers = pickRandomNumbers();
            Collections.sort(randomNumbers);
            issuedLottos.add(randomNumbers);

        }

        return issuedLottos;
    }
}
