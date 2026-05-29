class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]>ans=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while(i<n && intervals[i][1]<newInterval[0] ){
            ans.add(intervals[i]);
            i++;
        }
        if(i==n){
            ans.add(newInterval);
            int[][]a=new int[ans.size()][2];
            for(int j=0;j<ans.size();j++){
                a[j][0]=ans.get(j)[0];
                a[j][1]=ans.get(j)[1];
            }
            return a;
        }
        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        ans.add(newInterval);
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }
        int[][]a=new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
            a[j][0]=ans.get(j)[0];
            a[j][1]=ans.get(j)[1];
        }
        return a;
    }
}