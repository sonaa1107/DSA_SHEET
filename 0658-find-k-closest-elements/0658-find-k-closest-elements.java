class Solution {
    class Pair implements Comparable<Pair>{
        int ele;
        int diff;

        Pair(int e,int d){
            this.ele=e;
            this.diff=d;
        }
        public int compareTo(Pair p){
            if(this.diff!=p.diff){
                return p.diff-this.diff;
            }
            return p.ele-this.ele;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int ele=arr[i];
            int diff=Math.abs(ele-x);
            pq.add(new Pair(ele,diff));
            if(pq.size()>k){
                pq.poll();
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().ele);
        }
        Collections.sort(ans);
        return ans;
    }

}