package vitalswapcache;

/**
 *
 * @author Kayode Adeniran
 */
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache {

    private int capacity;
    private Map<String, Cache> cacheMap;
    private Cache head;
    private Cache tail;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * Constructor to create the cache with a given capacity
     */
    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.cacheMap = new ConcurrentHashMap<>();
        this.head = new Cache("-1", "-1");
        this.tail = new Cache("-1", "-1");
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    /**
     * the method that returns the value of any given key in our cache data structure
     */
    public String get(String key) {

        this.lock.writeLock().lock();

        Cache ce = null;

        try {

            if (!this.cacheMap.containsKey(key)) {

                return "Does Not Exist in this Cache";
            }

            ce = this.cacheMap.get(key);
            remove(ce);
            add(ce);

        } finally {

            this.lock.writeLock().unlock();
        }

        return ce.value;
    }

    
    /**
     * the method that inserts a key and value into our cache data structure
     */
    public void put(String key, String value) {

        this.lock.writeLock().lock();

        try {
            if (this.cacheMap.containsKey(key)) {

                Cache oldNode = this.cacheMap.get(key);
                remove(oldNode);
            }

            Cache che = new Cache(key, value);
            this.cacheMap.put(key, che);
            add(che);

            if (this.cacheMap.size() > this.capacity) {

                Cache nodeToDelete = this.tail.prev;
                remove(nodeToDelete);
                this.cacheMap.remove(nodeToDelete.key);
            }

        } finally {

            this.lock.writeLock().unlock();
        }
    }

    /**
     * this method adds a node after the head (the most recent used position)
     */
    private void add(Cache che) {

        Cache nextNode = head.next;

        head.next = che;
        che.prev = head;
        che.next = nextNode;
        nextNode.prev = che;
    }

    /**
     * this method remove a node from our cache data structure
     */
    private void remove(Cache node) {

        Cache prevNode = node.prev;
        Cache nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
