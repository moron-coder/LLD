package com.CP.InterviewQn;

import java.lang.Math;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    Integer[][] dp = new Integer[3001][2];

    int maxPointsOnSelling(int pos,int[] ar,boolean canBuy){
        int n=ar.length;
        if(pos>=n) return 0;
        if(dp[pos][canBuy?1:0]!=null) return dp[pos][canBuy?1:0];
        int ignoreAns = maxPointsOnSelling(pos+1,ar,canBuy);
        int buyIgnoreAns = (canBuy)?  Math.max(0,maxPointsOnSelling(pos+1,ar,false)-ar[pos]):0;
        int sellAns = (!canBuy)?ar[pos]+maxPointsOnSelling(pos+1,ar,true):0;
        return dp[pos][canBuy?1:0] = Math.max(ignoreAns,Math.max(buyIgnoreAns,sellAns));
    }

    public int maxProfit(int[] ar) {
        int n=ar.length;
        return maxPointsOnSelling(0,ar,true);
    }
}
