import java.util.Map;

public interface DBQueries {
    void createTable(String tableName, String keyName, Map<String, CellInfo> cellInfoMap);
}
