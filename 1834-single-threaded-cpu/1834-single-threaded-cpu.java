class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int[][]task=new int[n][3];
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            task[i][0]=tasks[i][0];
            task[i][1]=tasks[i][1];
            task[i][2]=i;
        }
        Arrays.sort(task,(a,b)->a[0]-b[0]);
        int time=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return a[0]-b[0];
        });
        int i=0;
        int j=0;
        while(!pq.isEmpty() || i<n){
            if(pq.isEmpty() && time<task[i][0]){
                time=task[i][0];
            }
            while(i<n && task[i][0]<=time){
                pq.offer(new int[]{task[i][1],task[i][2]});
                i++;
            }
            int[]arr=pq.poll();
            time+=arr[0];
            ans[j++]=arr[1];
        }
        return ans;
    }
}