import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Object> obs = new ArrayList<>();
        obs.add(3);
        for(Object o : obs){
            System.out.println("here");
            // System.out.println(String.class == String.class);
            System.out.println(o instanceof Integer);
            System.out.println(o instanceof Date);
        }
        Hashtable<Integer, String> h= new Hashtable<>();
        h.put(3, "HELLO");
        System.out.println(h.containsKey(3));
    }
}
