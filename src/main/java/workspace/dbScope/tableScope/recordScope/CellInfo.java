package workspace.dbScope.tableScope.recordScope;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CellInfo {
    private Class<?> type;
    private int index;
}
