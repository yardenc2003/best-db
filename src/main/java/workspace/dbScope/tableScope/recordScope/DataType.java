package workspace.dbScope.tableScope.recordScope;

import java.util.Date;

public enum DataType {
    STRING(String.class),
    INT(Integer.class),
    DATE(Date.class);

    public Class<?> type; // the char with represents the specific terrain type

    DataType(Class<?> type) {
        this.type = type;
    }
}
