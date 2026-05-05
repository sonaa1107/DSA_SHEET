class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>set=new HashSet<>(wordDict);
        Boolean[]dp=new Boolean[s.length()];
        return check(s,0,set,dp);
    }
    boolean check(String s,int index,HashSet<String>set,Boolean[]dp){
        if(index==s.length()){
            return true;
        }
        if(dp[index] != null ){
            return dp[index];
        }
        for(int i=index;i<s.length();i++){
            String curr=s.substring(index,i+1);
            if(set.contains(curr)){
                if(check(s,i+1,set,dp)){
                    return dp[index]=true;
                }
            }

        }
        return dp[index]=false;
    }
}