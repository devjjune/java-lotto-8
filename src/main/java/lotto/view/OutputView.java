package lotto.view;

import lotto.model.WinningRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printIssuedLottos(List<List<Integer>> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printStatistics(Map<WinningRank, Integer> rankCount, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("----");

        // 출력 순서를 등수 높은 순서로 정렬
        printRank(rankCount, WinningRank.FIFTH);
        printRank(rankCount, WinningRank.FOURTH);
        printRank(rankCount, WinningRank.THIRD);
        printRank(rankCount, WinningRank.SECOND);
        printRank(rankCount, WinningRank.FIRST);

        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static void printRank(Map<WinningRank, Integer> rankCount, WinningRank rank) {

        int count = rankCount.getOrDefault(rank, 0);
        String prize = String.format("%,d", rank.getPrize());

        if (rank == WinningRank.SECOND) {
            System.out.printf(
                    "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                    rank.getMatchCount(), prize, count
            );
        } else {
            System.out.printf(
                    "%d개 일치 (%s원) - %d개%n",
                    rank.getMatchCount(), prize, count
            );
        }
    }

}
