class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        // building lps array
        int[]lps=new int[m];
        int prevLps=0,i=1;
        while(i<m){
            if(needle.charAt(i)==needle.charAt(prevLps)){
                lps[i]=prevLps+1;
                prevLps++;
                i++;
            }
            else if(prevLps==0)i++;
            else
            prevLps=lps[prevLps-1];
        }
        //string matching
        int k=0,j=0;
        while(k<n){
            if(haystack.charAt(k)==needle.charAt(j)){
                k++;
                j++;
            }
            else if(j==0)k++;
            else
            j=lps[j-1];
            if(j==m)return k-j;
        }
        return -1;
    }
}