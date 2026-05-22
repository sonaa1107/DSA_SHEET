class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int point=0;
        int n=reward1.length;
        for(int i=0;i<n;i++){
            point+=reward2[i];
        }
        int[]diff=new int[n];
        for(int d=0;d<n;d++){
            diff[d]=reward1[d]-reward2[d];
        }
        Arrays.sort(diff);
        for(int i=n-k;i<n;i++){
            point+=diff[i];
        }
        return point;
    }
}