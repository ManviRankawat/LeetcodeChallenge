class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;

        for(int i = 1; i < prices.length; i++){
            int price = prices[i];
            buy1 = Math.max(buy1, -price);//Maximum profit while holding first stock
            sell1 = Math.max(sell1, buy1 + price); //Maximum profit after completing first transaction
            buy2 = Math.max(buy2, sell1 - price); //Maximum profit while holding second stock
            sell2 = Math.max(sell2, buy2 + price); //Maximum profit after completing both transactions
        }
        return sell2;
    }
}