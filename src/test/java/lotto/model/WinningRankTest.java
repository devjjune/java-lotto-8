package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankTest {
    @DisplayName("6개 일치 시 1등을 반환한다.")
    @Test
    void 일치6개_1등을_반환한다() {
        WinningRank rank = WinningRank.of(6, false);
        assertThat(rank).isEqualTo(WinningRank.FIRST);
    }

    @DisplayName("5개 일치하고 보너스 번호 일치 시 2등을 반환한다.")
    @Test
    void 일치5개_보너스일치_2등을_반환한다() {
        WinningRank rank = WinningRank.of(5, true);
        assertThat(rank).isEqualTo(WinningRank.SECOND);
    }

    @DisplayName("5개 일치하고 보너스 번호 불일치 시 3등을 반환한다.")
    @Test
    void 일치5개_보너스불일치_3등을_반환한다() {
        WinningRank rank = WinningRank.of(5, false);
        assertThat(rank).isEqualTo(WinningRank.THIRD);
    }

    @DisplayName("4개 일치 시 4등을 반환한다.")
    @Test
    void 일치4개_4등을_반환한다() {
        WinningRank rank = WinningRank.of(4, false);
        assertThat(rank).isEqualTo(WinningRank.FOURTH);
    }

    @DisplayName("3개 일치 시 5등을 반환한다.")
    @Test
    void 일치3개_5등을_반환한다() {
        WinningRank rank = WinningRank.of(3, false);
        assertThat(rank).isEqualTo(WinningRank.FIFTH);
    }

    @DisplayName("일치 개수가 3개 미만이면 null을 반환한다.")
    @Test
    void 일치3개미만_null을_반환한다() {
        WinningRank rank = WinningRank.of(2, false);
        assertThat(rank).isNull();
    }
}
