package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class YieldsTest {
    @DisplayName("당첨결과에 따라 등수별 개수가 올바르게 계산된다.")
    @Test
    void 당첨결과에_따라_등수별_개수가_올바르게_계산된다() {
        List<Map<String, Object>> compareResult = List.of(
                Map.of("matchedCount", 6, "hasBonus", false),
                Map.of("matchedCount", 5, "hasBonus", true),
                Map.of("matchedCount", 5, "hasBonus", false),
                Map.of("matchedCount", 3, "hasBonus", false)
        );

        Yields yields = new Yields(compareResult, "4000");
        Map<WinningRank, Integer> rankCount = yields.getRankCount();

        assertThat(rankCount).isNotEmpty();
        assertThat(rankCount.size()).isGreaterThan(2);
    }

    @DisplayName("총 당첨 금액이 올바르게 계산된다.")
    @Test
    void 총_당첨_금액이_올바르게_계산된다() {
        List<Map<String, Object>> compareResult = List.of(
                Map.of("matchedCount", 6, "hasBonus", false),
                Map.of("matchedCount", 5, "hasBonus", true)
        );

        Yields yields = new Yields(compareResult, "2000");
        int totalRevenue = yields.getTotalRevenue();

        assertThat(totalRevenue).isEqualTo(2_000_000_000 + 30_000_000);
    }

    @DisplayName("수익률이 올바르게 계산된다.")
    @Test
    void 수익률이_올바르게_계산된다() {
        List<Map<String, Object>> compareResult = List.of(
                Map.of("matchedCount", 3, "hasBonus", false)
        );

        Yields yields = new Yields(compareResult, "1000");
        double profitRate = yields.getProfitRate();

        assertThat(profitRate).isEqualTo(500.0);
    }

    @DisplayName("미당첨시 총 수익과 수익률은 0이다.")
    @Test
    void 미당첨시_총_수익과_수익률은_0이다() {
        List<Map<String, Object>> compareResult = List.of(
                Map.of("matchedCount", 1, "hasBonus", false)
        );

        Yields yields = new Yields(compareResult, "1000");

        assertThat(yields.getTotalRevenue()).isEqualTo(0);
        assertThat(yields.getProfitRate()).isEqualTo(0.0);
    }
}
