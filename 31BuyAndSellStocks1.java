// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public int maxProfit(int[] prices) {
    int n = prices.length;

    int minm = prices[0];
    int profit = 0;

    for(int i = 1; i < n; i++){
        int cost = prices[i] - minm;
        profit = Math.max(cost, profit);
        minm = Math.min(minm, prices[i]);
    }
    return profit;
}
