package leetcode;
/**
 * ∫√Ã‚£°£°
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Hide Tags Array Dynamic Programming


 * @author Lowry
 *
 */
public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0)
            return 0;
        int head[] = new int[length];
        int tail[] = new int[length];
        int minH = prices[0];
        int maxT = prices[length-1];
        for(int i = 1; i < length; i ++){
            if(prices[i]<minH){
                minH = prices[i];
            }
            head[i] = prices[i]-minH > head[i-1]?prices[i]-minH:head[i-1];
        }
        for(int j = length-2 ; j >= 0; j --){
            if(prices[j]>maxT){
                maxT = prices[j];
            }
            tail[j] = maxT-prices[j] > tail[j+1]?maxT-prices[j]:tail[j+1];
        }
        int result = 0;
        for(int k=0;k<length;k++){
            if(head[k]+tail[k]>result)
                result = head[k]+tail[k];
        }
        return result;
    }
}
