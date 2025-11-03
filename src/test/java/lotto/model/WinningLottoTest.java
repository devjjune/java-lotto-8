package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("입력된 당첨번호는 쉼표를 기준으로 분리된다.")
    @Test
    void 입력된_당첨번호는_쉼표를_기준으로_분리된다() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", "7");
        List<Integer> numbers = winningLotto.getWinningNumbers();

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("보너스번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void 보너스번호가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 숫자 이외의 값이 포함되면 예외가 발생한다.")
    @Test
    void 당첨번호에_숫자_이외의_값이_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto("1,2,b,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호는 1 이상 45 이하 범위의 정수여야 한다.")
    @Test
    void 보너스번호는_1_이상_45_이하_범위의_정수여야_한다() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "45");
        assertThat(winningLotto.getBonusNumber()).isBetween(1, 45);
    }
}
