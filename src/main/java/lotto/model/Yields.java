package lotto.model;

import java.util.Map;

public class Yields {
    public static int calculateTotalRevenue(Map<WinningRank, Integer> results) {
        int totalRevenue = 0;

        for (Map.Entry<WinningRank, Integer> entry : results.entrySet()) {
            WinningRank rank = entry.getKey();
            int count = entry.getValue();
            totalRevenue += rank.prize * count;
        }

        return totalRevenue;
    }

    public static double calculateYields(int totalRevenue, String purchaseAmount) {
        int totalCost = Integer.parseInt(purchaseAmount);
        double profitRate = (double) totalRevenue / totalCost * 100;
        profitRate = Math.round(profitRate * 10) / 10.0;

        return profitRate;
    }
}
