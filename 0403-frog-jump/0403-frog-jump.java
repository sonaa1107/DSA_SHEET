class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        Boolean[][]dp=new Boolean[n][n+1];
        return helper(stones,0,0,map,dp);
    }
    boolean helper(int[]stones,int ind,int k,HashMap<Integer,Integer>map,Boolean[][]dp){
        if(ind==stones.length-1)return true;
        if(dp[ind][k]!=null)return dp[ind][k];
        for(int jump=k-1;jump<k+2;jump++){
            if(jump<=0)continue;
            int nextJump=stones[ind]+jump;
            if(map.containsKey(nextJump)){
                int nextInd=map.get(nextJump);
                if(helper(stones,nextInd,jump,map,dp))return dp[ind][k]= true;
            }
        }
        return dp[ind][k]=false;
    }
}