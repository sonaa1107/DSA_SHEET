class Solution {
    public int maxProfit(int[] prices) {
        int currmin=prices[0];
        int maxprofit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<currmin){
                currmin=prices[i];
            }
            else if(prices[i]>currmin){
                maxprofit=Math.max(prices[i]-currmin,maxprofit);
            }
        }
        return maxprofit;
    }
}