package workspace;

import workspace.dbScope.DBMS;
import workspace.dbScope.tableScope.DataType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        DBMS dbms = new DBMS();
        Map<String, DataType> dataTypeMap = new HashMap<>();
        dataTypeMap.put("name", DataType.STRING);
        dataTypeMap.put("age", DataType.INT);
        dataTypeMap.put("birth_date", DataType.DATE);
        dbms.createTable("my cats", "name", dataTypeMap);
        Map<String, Object> rec = new HashMap<>();
        rec.put("name", "pop");
        rec.put("age", 8);
        rec.put("birth_date", new Date());
        dbms.insertRecord("my cats", rec);
    }
}
