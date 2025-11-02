package lotto.model;

import java.awt.*;

public enum WinningRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchCount;
    private final int prize;

    WinningRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

}
