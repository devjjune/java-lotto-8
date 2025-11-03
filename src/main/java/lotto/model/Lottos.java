package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<List<Integer>> lottos;

    public Lottos(String purchaseAmount) {
        int lottoAmount = calculateLottoAmount(purchaseAmount);
        this.lottos = issueLottos(lottoAmount);
    }

    private int calculateLottoAmount(String purchaseAmount) {
        int lottoAmount = Integer.parseInt(purchaseAmount) / 1000;

        return lottoAmount;
    }

    private List<List<Integer>> issueLottos(int lottoAmount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<List<Integer>> issuedLottos = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> randomNumbers = lottoGenerator.getRandomNumbers();
            Collections.sort(randomNumbers);
            issuedLottos.add(new ArrayList<>(randomNumbers));
        }

        return issuedLottos;
    }

    public List<List<Integer>> getLottos() {
        return List.copyOf(lottos);
    }

}
