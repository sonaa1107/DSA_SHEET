class Solution {
    public int repeatedStringMatch(String a, String b) {
        int m=a.length();
        int n=b.length();
        int repeat=(n+m-1)/m;
        int maxlength=(repeat+1)*m;
        int[]lps=build(b);
        int i=0,j=0;
        while(i<maxlength){
            char ch=a.charAt(i%m);
            if(ch==b.charAt(j)){
                i++;
                j++;
            }
            else if(j==0)i++;
            else j=lps[j-1];
            if(j==n){
                return (i+m-1)/m;
            }
        }
        return -1;
    }
    int[] build(String b){
        int[]lps=new int[b.length()];
        int prevLps=0,i=1;
        while(i<b.length()){
            if(b.charAt(i)==b.charAt(prevLps)){
                lps[i]=prevLps+1;
                prevLps++;
                i++;
            }
            else if(prevLps==0){
                i++;
            }
            else prevLps=lps[prevLps-1];
        }
        return lps;
    }
}