package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Yields {
    private final List<Map<String, Object>> compareResult;
    private final String purchaseAmount;

    private final Map<WinningRank, Integer> rankCount;
    private final int totalRevenue;
    private final double profitRate;

    public Yields(List<Map<String, Object>> compareResult, String purchaseAmount) {
        this.compareResult = compareResult;
        this.purchaseAmount = purchaseAmount;
        this.rankCount = countWinningRanks();
        this.totalRevenue = calculateTotalRevenue(rankCount);
        this.profitRate = calculateProfitRate(totalRevenue, purchaseAmount);
    }

    private Map<WinningRank, Integer> countWinningRanks() {
        Map<WinningRank, Integer> rankCount = new EnumMap<>(WinningRank.class);

        for (Map<String, Object> result : compareResult) {
            int matchedCount = (int) result.get("matchedCount");
            boolean hasBonus = (boolean) result.get("hasBonus");

            WinningRank rank = WinningRank.of(matchedCount, hasBonus);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }

    private int calculateTotalRevenue(Map<WinningRank, Integer> rankCount) {
        int total = 0;
        for (Map.Entry<WinningRank, Integer> entry : rankCount.entrySet()) {
            total += entry.getKey().getPrize() * entry.getValue();
        }
        return total;
    }

    private double calculateProfitRate(int totalRevenue, String purchaseAmount) {
        int cost = Integer.parseInt(purchaseAmount);
        return ((double) totalRevenue / cost) * 100;
    }

    public Map<WinningRank, Integer> getRankCount() {
        return Map.copyOf(rankCount);
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public double getProfitRate() {
        return profitRate;
    }

}
