package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ComparatorTest {
    @DisplayName("로또와 당첨 번호를 비교하여 일치하는 개수를 계산한다.")
    @Test
    void 일치개수_확인() {
        Lottos lottos = new Lottos("1000");
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        Comparator comparator = new Comparator(lottos, winningLotto);
        List<Map<String, Object>> result = comparator.getCompare();

        assertThat(result).isNotEmpty();
    }

    @DisplayName("보너스 번호가 포함된 경우 true가 반환된다.")
    @Test
    void 보너스번호_포함시_true() {
        List<List<Integer>> lottos = List.of(
                List.of(1, 2, 3, 4, 5, 7)
        );
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        Comparator comparator = new Comparator(
                new LottosStub(lottos),
                winningLotto
        );
        Map<String, Object> result = comparator.getCompare().get(0);

        assertThat(result.get("hasBonus")).isEqualTo(true);
    }

    @DisplayName("일치 번호가 없으면 matchedCount는 0이다.")
    @Test
    void 일치없음_확인() {
        List<List<Integer>> lottos = List.of(
                List.of(8, 9, 10, 11, 12, 13)
        );
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        Comparator comparator = new Comparator(
                new LottosStub(lottos),
                winningLotto
        );
        Map<String, Object> result = comparator.getCompare().get(0);

        assertThat(result.get("matchedCount")).isEqualTo(0);
    }

    static class LottosStub extends Lottos {
        private final List<List<Integer>> stubLottos;

        public LottosStub(List<List<Integer>> stubLottos) {
            super("0");
            this.stubLottos = stubLottos;
        }

        @Override
        public List<List<Integer>> getLottos() {
            return stubLottos;
        }
    }
}
