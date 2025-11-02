package lotto.view;

import java.util.List;

public class OutputView {
    public static void printIssuedLottos(List<List<Integer>> issuedLottos) {
        int issuedAmount = issuedLottos.size();
        System.out.println();
        System.out.println(issuedAmount + "개를 구매했습니다.");
        issuedLottos.forEach(lottos -> System.out.println(lottos));

    }

}
