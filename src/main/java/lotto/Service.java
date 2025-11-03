package lotto;

import lotto.model.Lottos;

public class Service {
    public static Lottos purchaseLottos(String purchaseAmount) {
        return new Lottos(purchaseAmount);
    }

}
