package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @DisplayName("로또는 6개 번호를 생성한다.")
    @Test
    void 로또는_6개_번호를_생성한다() {
        LottoGenerator generator = new LottoGenerator();
        List<Integer> numbers = generator.getRandomNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("번호는 1부터 45 사이에 있다.")
    @Test
    void 번호는_1부터_45_사이에_있다() {
        LottoGenerator generator = new LottoGenerator();
        List<Integer> numbers = generator.getRandomNumbers();

        assertThat(numbers).allMatch(n -> n >= 1 && n <= 45);
    }

    @DisplayName("번호는 중복되지 않는다.")
    @Test
    void 번호는_중복되지_않는다() {
        LottoGenerator generator = new LottoGenerator();
        List<Integer> numbers = generator.getRandomNumbers();

        assertThat(new HashSet<>(numbers)).hasSize(6);
    }
}
