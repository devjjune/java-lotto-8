package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @DisplayName("구매 금액만큼 로또가 발행된다.")
    @Test
    void 구매_금액만큼_로또가_발행된다() {
        Lottos lottos = new Lottos("8000");
        List<List<Integer>> issuedLottos = lottos.getLottos();

        assertThat(issuedLottos).hasSize(8);
    }

    @DisplayName("각 로또는 6개의 번호를 가진다.")
    @Test
    void 각_로또는_6개의_번호를_가진다() {
        Lottos lottos = new Lottos("3000");
        List<List<Integer>> issuedLottos = lottos.getLottos();

        issuedLottos.forEach(lotto ->
                assertThat(lotto).hasSize(6)
        );
    }

    @DisplayName("로또번호는 범위 내에서 중복되지 않는다.")
    @Test
    void 로또번호는_범위_내에서_중복되지_않는다() {
        Lottos lottos = new Lottos("2000");
        List<List<Integer>> issuedLottos = lottos.getLottos();

        issuedLottos.forEach(lotto -> {
            assertThat(lotto).allMatch(n -> n >= 1 && n <= 45);
            assertThat(new HashSet<>(lotto)).hasSize(6);
        });
    }
}
