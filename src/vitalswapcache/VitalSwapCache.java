package vitalswapcache;

/**
 *
 * @author Kayode Adeniran
 */
public class VitalSwapCache {
    
    public static void main(String[] args) {

        LRUCache cac = new LRUCache(2);

        cac.put("1", "1");
        cac.put("2", "2");
        System.out.println(cac.get("1"));
        cac.put("3", "3");
        System.out.println(cac.get("2"));
        cac.put("4", "4");
        System.out.println(cac.get("1"));
        System.out.println(cac.get("3"));
        System.out.println(cac.get("4"));

        cac.put("4", "Peter");
        cac.put("8z", "John");
        System.out.println(cac.get("3"));
        System.out.println(cac.get("4"));
    }
}
