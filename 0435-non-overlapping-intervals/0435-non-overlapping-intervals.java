class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count=0;
        int endtime=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(endtime<=intervals[i][0]){ //non overlapping
                endtime=intervals[i][1];
            }
            else{
                count++;
            }
        }
        return count;
    }
}