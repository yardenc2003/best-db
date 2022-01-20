package workspace.dbScope.tableScope;

import lombok.Builder;

import java.util.Map;

@Builder
public class TableValidation {
    private Table table;

    private void validCellValueType(String cellName, Object cellValue) throws Exception {
        if (cellValue.getClass() != this.table.getCellType(cellName)) {
            throw new Exception(String.format("%s cell type is %s. got %s instead", cellName,
                    this.table.getCellType(cellName), cellValue.getClass()));
        }
    }

    private void validKeyValueType(Object keyValue) throws Exception {
        if (keyValue.getClass() != this.table.getKeyType()) {
            throw new Exception(String.format("%s key type is %s. got %s instead", this.table.getKeyName(),
                    this.table.getKeyType(), keyValue.getClass()));
        }
    }

    private void uniqueKeyValue(Object keyValue) throws Exception {
        if (this.table.getRecords().containsKey(keyValue)) {
            throw new Exception(String.format("%s key value must be unique, %s already exists!", this.table.getKeyName()
                    , keyValue));
        }
    }

    public void validKey(Object keyValue) throws Exception {
        this.validKeyValueType(keyValue);
        this.uniqueKeyValue(keyValue);
    }

    public void validCell(String cellName, Object cellValue) throws Exception {
        this.validCellValueType(cellName, cellValue);
    }

    public void validRecord(Object keyValue, Map<String, Object> cellsValues) throws Exception {
        // key validation
        this.validKey(keyValue);

        // cells value validation
        for (Map.Entry<String, Object> cell : cellsValues.entrySet()) {
            String cellName = cell.getKey();
            Object cellValue = cell.getValue();
            this.validCell(cellName, cellValue);
        }
    }
}
