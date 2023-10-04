class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;
        
        Node () {}
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private List<Node> bucketArray;
    private int size;
    private static final double THRESHOLD = 2.0;
    private static final int INC_FACT = 2;
    
    public MyHashMap() {
        this (4);
    }
    
    public MyHashMap (int capacity) {
        bucketArray = new ArrayList<>(capacity);
        size = 0;
        
        while (capacity -- > 0)
            bucketArray.add(null);
    }
    
    public void put (int key, int value) {
        int bucketNum = hashFunction (key);
        Node head = bucketArray.get(bucketNum);

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            } 
            
            head = head.next;
        }
        
        Node newNode = new Node (key, value);
        head = bucketArray.get(bucketNum);
        
        newNode.next = head;
        bucketArray.set(bucketNum, newNode);
        
        size += 1;
        double currLoadFact = (size * 1.0) / bucketArray.size();
        
        if (currLoadFact > THRESHOLD)
            rehash();
    }
    
    public int get(int key) {
        int bucketNum = hashFunction (key);
        Node head = bucketArray.get(bucketNum);
        
        while (head != null) {
            if (head.key == key)
                return head.value;
            
            head = head.next;
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int bucketNum = hashFunction (key);
        Node head = bucketArray.get(bucketNum);
        Node prev = null;
        
        while (head != null) {
            if (head.key == key)
                break;
            
            prev = head;
            head = head.next;
        }
        
        if (head == null)
            return;
        
        if (prev == null)
            bucketArray.set(bucketNum, head.next);
        else
            prev.next = head.next;
        
        head.next = null;
        size -= 1;
    }
    
    private int hashFunction (int key) {
        int bucketNum = key % bucketArray.size();
        return bucketNum < 0 ? bucketNum + bucketArray.size() : bucketNum;
    }
    
    private void rehash () {
        List<Node> newBucketList = new ArrayList<>(INC_FACT * bucketArray.size());
        
        for (int i = 0; i < INC_FACT * bucketArray.size(); i ++)
            newBucketList.add(null);
        
        List<Node> orgBucket = bucketArray;
        bucketArray = newBucketList;
        size = 0;
        
        for (Node node : orgBucket) {
            while (node != null) {
                put (node.key, node.value);
                node = node.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */