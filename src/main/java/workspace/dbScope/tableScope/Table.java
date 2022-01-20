package workspace.dbScope.tableScope;

import lombok.Data;
import lombok.SneakyThrows;
import workspace.dbScope.tableScope.recordScope.CellInfo;
import workspace.dbScope.tableScope.recordScope.DataType;
import workspace.dbScope.tableScope.recordScope.Key;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Table implements TableQueries {
    private String name; // table name
    private Key key; // primary key
    private Map<String, CellInfo> cellInfoMap = new HashMap<>(); // info obout the cells according to its name
    private Hashtable<Object, List<Object>> records = new Hashtable<>(); // records container

    @SneakyThrows
    public Table(String name, String keyName, Map<String, DataType> dataTypeMap) {
        // general settings
        this.name = name;

        // key settings
        if (!dataTypeMap.containsKey(keyName)) {
            throw new Exception("Missing key DataType");
        }
        this.key = new Key(keyName, dataTypeMap.remove(keyName).type);

        // other cells settings
        AtomicInteger counter = new AtomicInteger(0);
        // saves info about the cells (type & index)
        dataTypeMap.forEach((cellName, cellType) -> {
            cellInfoMap.put(cellName, new CellInfo(cellType.type,
                    counter.getAndIncrement()));
        });
    }

    public void printTestings() {
        System.out.println(this.records);
    }

    public Class<?> getKeyType() {
        return this.key.getType();
    }

    public String getKeyName() {
        return this.key.getName();
    }

    public Class<?> getCellType(String cellName) {
        return this.cellInfoMap.get(cellName).getType();
    }

    public int getCellIndex(String cellName) {
        return this.cellInfoMap.get(cellName).getIndex();
    }

    @SneakyThrows
    @Override
    public void insert(Map<String, Object> recordValues) {
        // check if the given record (key + cells) values are valid
        TableValidation tableValidation = new TableValidation(this);
        Object keyValue = recordValues.remove(this.key.getName());
        tableValidation.validRecord(keyValue, recordValues);

        // record insertion
        Object[] record = new Object[this.cellInfoMap.size()];
        for (Map.Entry<String, Object> cell : recordValues.entrySet()) {
            String cellName = cell.getKey();
            Object cellValue = cell.getValue();
            int cellIndex = this.getCellIndex(cellName);
            record[cellIndex] = cellValue;
        }
        this.records.put(keyValue, Arrays.asList(record));
    }
}
