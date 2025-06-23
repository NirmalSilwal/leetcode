class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // dummy head and tail to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        // make sure the node we get is moved to first to access it as it is recently used now
        moveToFront(node); // helper method
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            if (map.size() == capacity) {
                // remove least recently used node
                Node lru = tail.prev;
                remove(lru); // helper method to remove lru node from our doubly linked list
                map.remove(lru.key); // remove lru from our map also and add new node
            }
            Node newNode = new Node(key, value);
            insertToFront(newNode); // helper method to add new node in front of our linked list as it is recently used here
            map.put(key, newNode);
        }
    } 

    // now writing helper implementations
    private void moveToFront(Node node) {
        remove(node);
        insertToFront(node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */