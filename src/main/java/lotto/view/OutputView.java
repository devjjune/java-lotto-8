package lotto.view;

import lotto.model.WinningRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printIssuedLottos(List<List<Integer>> issuedLottos) {
        int issuedAmount = issuedLottos.size();
        System.out.println();
        System.out.println(issuedAmount + "개를 구매했습니다.");
        issuedLottos.forEach(lottos -> System.out.println(lottos));

    }

    public static void printStatistics(Map<WinningRank, Integer> results, double profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.printf("3개 일치 (5,000원) - %d개%n", results.getOrDefault(WinningRank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", results.getOrDefault(WinningRank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", results.getOrDefault(WinningRank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results.getOrDefault(WinningRank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results.getOrDefault(WinningRank.FIRST, 0));

        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

}
