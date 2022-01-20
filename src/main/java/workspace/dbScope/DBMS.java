package workspace.dbScope;

import lombok.Data;
import workspace.dbScope.tableScope.recordScope.DataType;
import workspace.dbScope.tableScope.Table;

import java.util.HashMap;
import java.util.Map;

@Data
public class DBMS implements DBQueries {
    // option : add an object of metaData
    private Map<String, Table> scheme = new HashMap<>(); // one scheme

    @Override
    public void createTable(String tableName, String key, Map<String, DataType> dataTypeMap){
        this.scheme.put(tableName, new Table(tableName, key, dataTypeMap));
    }

    @Override
    public void insertRecord(String tableName, Map<String, Object> recordValues) throws Exception {
        if(!this.scheme.containsKey(tableName)){
            throw new Exception("Table does not exist!");
        }
        this.scheme.get(tableName).insert(recordValues);
        this.scheme.get(tableName).printTestings();
    }
}
