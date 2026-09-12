class Solution {
    class Pair implements Comparable<Pair>{
        int ele;
        int freq;

        Pair(int e,int f){
            this.ele=e;
            this.freq=f;
        }
        public int compareTo(Pair p){
            return this.freq-p.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            pq.add(new Pair(e.getKey(),e.getValue()));
            if(pq.size()>k)pq.poll();
        }
        int[]ans=new int[k];
        int index=0;
        while(!pq.isEmpty()){
            ans[index++]=pq.poll().ele;
        }
        return ans;
    }
}