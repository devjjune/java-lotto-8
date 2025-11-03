package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {
    @DisplayName("purchaseLottos_로또를_구매한다")
    @Test
    void purchaseLottos_로또를_구매한다() {
        var service = new Service();
        var lottos = service.purchaseLottos("5000");

        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }

    @DisplayName("drawWinningLotto_당첨로또를_생성한다")
    @Test
    void drawWinningLotto_당첨로또를_생성한다() {
        var service = new Service();
        var winningLotto = service.drawWinningLotto("1,2,3,4,5,6", "7");

        assertThat(winningLotto.getWinningNumbers()).hasSize(6);
        assertThat(winningLotto.getBonusNumber()).isBetween(1, 45);
    }

    @DisplayName("calculateResults_결과를_계산한다")
    @Test
    void calculateResults_결과를_계산한다() {
        var service = new Service();
        var lottos = service.purchaseLottos("3000");
        var winningLotto = service.drawWinningLotto("1,2,3,4,5,6", "7");

        var yields = service.calculateResults("3000", lottos, winningLotto);

        assertThat(yields.getRankCount()).isNotNull();
        assertThat(yields.getProfitRate()).isGreaterThanOrEqualTo(0.0);
    }
}
