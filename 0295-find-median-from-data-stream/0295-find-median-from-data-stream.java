class MedianFinder {
    PriorityQueue<Integer>minheap;
    PriorityQueue<Integer>maxheap;

    public MedianFinder() {
        this.minheap=new PriorityQueue<>();
        this.maxheap=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxheap.isEmpty() || num<maxheap.peek()){
            maxheap.add(num);
        }else{
            minheap.add(num);
        }
        if(maxheap.size()>minheap.size()+1){
            minheap.add(maxheap.poll());
        }else if(minheap.size()>maxheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size()>minheap.size())return (double)(maxheap.peek());
        return (maxheap.peek()+minheap.peek())/2.0;

    }
    
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */