class LFUCache {
    class Node{
            int key;
            int val;
            int freq;
            Node prev;
            Node next;

            Node(int key,int val){
                this.key=key;
                this.val=val;
                this.freq=1;
            }
    }
    class LRU{
        Node head=new Node(-1,-1);
        Node tail=new Node(-1,-1);
        int size;
        public LRU(){
            head.next=tail;
            tail.prev=head;
            size=0;
        }

        public void deleteNode(Node node){
            Node prevNode=node.prev;
            Node nextNode=node.next;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            size--;
        }
        public void insertAfterHead(Node node){
            Node afterHead=head.next;
            node.prev=head;
            node.next=afterHead;
            afterHead.prev=node;
            head.next=node;
            size++;
        }
        public Node removeLRU(){
            if(size==0)return null;
            Node node=tail.prev;
            deleteNode(node);
            return node;
        }
    }
    HashMap<Integer,LRU>freqmap;
    HashMap<Integer,Node>keymap;
    int capacity;
    int minfreq;
    public LFUCache(int capacity) {
        freqmap=new HashMap<>();
        keymap=new HashMap<>();
        this.capacity=capacity;
        minfreq=0;
    }
    
    public int get(int key) {
        if(!keymap.containsKey(key))return -1;
        Node node=keymap.get(key);
        int oldfreq=node.freq;
        LRU oldLRU=freqmap.get(oldfreq);
        oldLRU.deleteNode(node);

        if(oldLRU.size==0){
            freqmap.remove(oldfreq);
            if(minfreq==oldfreq)
            minfreq++;
        }
        node.freq++;
        LRU newLRU=freqmap.get(node.freq);
        if(newLRU==null){
            newLRU=new LRU();
            freqmap.put(node.freq,newLRU);
        }
        newLRU.insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(keymap.containsKey(key)){
            Node node=keymap.get(key);
            node.val=value;
            get(key);

        }
        else{
            if(keymap.size()==capacity){
                LRU lru=freqmap.get(minfreq);
                Node evictnode=lru.removeLRU();
                keymap.remove(evictnode.key);
            }
            Node newNode=new Node(key,value);
            keymap.put(key,newNode);
            minfreq=1;
            LRU lru=freqmap.get(1);
            if(lru==null){
                lru=new LRU();
                freqmap.put(minfreq,lru);            
            }
            lru.insertAfterHead(newNode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */