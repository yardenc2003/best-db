import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DBMS implements DBQueries {
    // option : add an object of metaData
    private Map<String, Table> scheme = new HashMap<>(); // one scheme per dbms for now

    @Override
    public void createTable(String tableName, String keyName, Map<String, DataType> dataTypeMap){
        this.scheme.put(tableName, new Table(keyName, dataTypeMap));
        this.scheme.get(tableName).printTestings();
    }
}
