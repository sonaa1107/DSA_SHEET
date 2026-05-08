class Solution {
    static long MOD=(long)1e9+7;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long ans=(helper(5,even)*helper(4,odd))%MOD;
        return (int)ans;
    }
    long helper(int x,long n){
        if(n==0){
            return 1;
        }
        long small=helper(x,n/2);
        long res=(small*small)%MOD;
        if(n%2!=0){
            res=(res*x)%MOD;
        }
        return res;
    }
}