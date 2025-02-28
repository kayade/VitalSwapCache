package vitalswapcache;

/**
 *
 * @author Kayode Adeniran
 */

public class Cache {

    String key;
    String value;
    Cache next;
    Cache prev;
    
    public Cache(String key, String value) {
        
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
