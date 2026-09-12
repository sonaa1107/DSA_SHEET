class Solution {
    class Pair implements Comparable<Pair>{
        int ele;
        int freq;

        Pair(int e,int f){
            this.ele=e;
            this.freq=f;
        }
        public int compareTo(Pair p){
            if(this.freq!=p.freq){
                return this.freq-p.freq;
            }
            return p.ele-this.ele;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            pq.add(new Pair(e.getKey(),e.getValue()));
        }
        int[]ans=new int[nums.length];
        int index=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int freq=p.freq;
            int ele=p.ele;
            while(freq>0){
                ans[index++]=ele;
                freq--;
            }
        }
        return ans;
    }
}