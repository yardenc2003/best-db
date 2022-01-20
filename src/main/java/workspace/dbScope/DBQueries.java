package workspace.dbScope;

import workspace.dbScope.tableScope.recordScope.DataType;

import java.util.Map;

public interface DBQueries {
    void createTable(String tableName, String key, Map<String, DataType> dataTypeMap);
    void insertRecord(String tableName, Map<String, Object> recordValues) throws Exception;
}
