import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Table {
    private String keyName;
    private Map<String, CellInfo> cellInfoMap = new HashMap<>();
    private Hashtable<Object, ArrayList<Object>> records = new Hashtable<>();

    @SneakyThrows
    public Table(String keyName, Map<String, DataType> dataTypeMap){
        if (!dataTypeMap.containsKey(keyName)) {
            throw new Exception("Missing key DataType");
        }
        this.keyName = keyName;
        AtomicInteger counter = new AtomicInteger(0);
        dataTypeMap.forEach((cellName, cellType) -> {cellInfoMap.put(cellName, new CellInfo(cellType.type,
                counter.getAndIncrement()));});
    }

    public void printTestings(){
        System.out.println(this.records);
    }
}
