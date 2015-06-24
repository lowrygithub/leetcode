package leetcode;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Hide Tags Array Greedy

 * @author Lowry
 *
 */
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
        int profit = 0;
        int length = prices.length;
        if(length>1){
            int pre = prices[0];
            for(int i=1;i<length;i++){
                if(prices[i]-pre>0)
                    profit+=prices[i]-pre;
                pre = prices[i];                    
            }
        }
        return profit;
    }
}
