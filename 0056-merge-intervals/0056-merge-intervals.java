class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]>ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);//sort acc to start time
        int[]eve=intervals[0];
        int i=1,n=intervals.length;
        while(i<n){
            if(eve[1]>=intervals[i][0]){
                eve[0]=Math.min(eve[0],intervals[i][0]);
                eve[1]=Math.max(eve[1],intervals[i][1]);
            }
            else{
                ans.add(eve);
                eve=intervals[i];
            }
            i++;
        }
        ans.add(eve);

        int[][]a=new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
            a[j][0]=ans.get(j)[0];
            a[j][1]=ans.get(j)[1];
        }
        return a;
    }
}