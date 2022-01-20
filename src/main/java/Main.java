import javafx.scene.control.Cell;

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
        DBMS dbms = new DBMS();
        Map<String, DataType> dataTypeMap = new HashMap<>();
        dataTypeMap.put("name", DataType.STRING);
        dataTypeMap.put("age", DataType.INT);
        dataTypeMap.put("birth_date", DataType.DATE);
        dbms.createTable("my cats", "name", dataTypeMap);
    }
}
