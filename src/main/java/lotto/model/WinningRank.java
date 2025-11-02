package lotto.model;

import java.awt.*;

public enum WinningRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    public final int matchCount;
    public final boolean bonus;
    public final int prize;

    WinningRank(int matchCount, boolean bonus, int prize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static WinningRank valueOf(int matchCount, boolean bonusMatch) {
        for (WinningRank rank : values()) {
            if (rank.matchCount == matchCount && rank.bonus == bonusMatch) {
                return rank;
            }
        }
        for (WinningRank rank : values()) {
            if (rank.matchCount == matchCount && !rank.bonus) {
                return rank;
            }
        }
        return null;
    }

}
