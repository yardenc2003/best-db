import lombok.Data;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

@Data
public class Table {
    private String keyName;
    private Map<String, CellInfo> cellInfoMap;
    private Hashtable<Object, ArrayList<Object>> records = new Hashtable<>();

    public Table(String keyName, Map<String, CellInfo> cellInfoMap) {
        if (cellInfoMap.containsKey(keyName)) {
            this.keyName = keyName;
            this.cellInfoMap = cellInfoMap;
        }
    }
}
