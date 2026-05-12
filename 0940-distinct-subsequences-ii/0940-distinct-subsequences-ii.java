class Solution {
    public int distinctSubseqII(String s) {
        int MOD=1000000007;
        int n=s.length();
        long[]dp=new long[n+1];
        dp[0]=1;
        int[]lastOccur=new int[26];
        Arrays.fill(lastOccur,-1);
        for(int i=1;i<n+1;i++){
            dp[i]=(2*dp[i-1])%MOD;
            int ch=s.charAt(i-1)-'a';
            if(lastOccur[ch]!=-1){
                dp[i]=(dp[i]-dp[lastOccur[ch]]+MOD)%MOD;
            }
            lastOccur[ch]=i-1;
        }
        return (int)(dp[n]-1+MOD)%MOD;
    }
    
}