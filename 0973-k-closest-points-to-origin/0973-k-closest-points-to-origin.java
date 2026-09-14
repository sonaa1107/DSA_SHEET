class Solution {
    class Tuple implements Comparable<Tuple>{
        int dist,x,y;
        public Tuple(int d,int x,int y){
            this.dist=d;
            this.x=x;
            this.y=y;
        }
        public int compareTo(Tuple t){
            return t.dist-this.dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple>pq=new PriorityQueue<>();
        int[][]ans=new int[k][2];
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            // System.out.println((int)Math.pow(x,2));
            int dist=(int)Math.pow(x,2)+(int)Math.pow(y,2);
            pq.add(new Tuple(dist,x,y));
            if(pq.size()>k)pq.poll();
        }
        int idx=0;
        while(!pq.isEmpty()){
            Tuple t=pq.poll();
            ans[idx][0]=t.x;
            ans[idx][1]=t.y;
            idx++;
        }
        return ans;
    }
}