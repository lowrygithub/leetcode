package leetcode;
/**
 * Best Time to Buy and Sell Stock Total Accepted: 37330 Total Submissions: 116877 My Submissions Question Solution 
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * @author Lowry
 *
 */
public class BestTimetoBuyandSellStock {
	  public int maxProfit(int[] prices) {
	        int maxProfit = 0;
	        int length = prices.length;
	        int min;
	        if(length>1){
	            min = prices[0];
	            for(int i=1;i<length;i++){
	                if(prices[i]-min>maxProfit)
	                    maxProfit = prices[i]-min;
	                if(prices[i]<min)
	                    min = prices[i];
	            }
	        }
	        return maxProfit;
	    }
}
