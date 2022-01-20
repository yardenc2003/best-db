package workspace.dbScope.tableScope;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Key {
    private String name;
    private Class<?> type;
}
