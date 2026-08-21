class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    HashMap<Integer,Node>map=new HashMap<>();
    int capacity;
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    public void deleteNode(Node node){
            Node prevnode=node.prev;
            Node nextnode=node.next;
            prevnode.next=nextnode;
            nextnode.prev=prevnode;
    }
    public void insertAfterHead(Node node){
            Node afterHead=head.next;
            node.next=afterHead;
            node.prev=head;
            head.next=node;
            afterHead.prev=node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        //kyuki usko abhi use kiya h toh uthao or head ke baad lagaoo
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            deleteNode(node);
            insertAfterHead(node);
        }
        else{
            if(map.size()==capacity){
                Node leastUsedNode=tail.prev;
                map.remove(leastUsedNode.key);
                deleteNode(leastUsedNode);
            }
            Node newnode=new Node(key,value);
            map.put(key,newnode);
            insertAfterHead(newnode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */