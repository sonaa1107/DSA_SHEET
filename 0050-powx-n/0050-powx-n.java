class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(n<0){
            x=1/x;
            N=-N;
        }
        return helper(x,N);
    }
    double helper(double x,long n){
        if(n==0){
            return 1;
        }
        double small=helper(x,n/2);
        if(n%2==0){
            return small*small;
        }else{
            return small*small*x;
        }
    }
}