package Lotterys;

import java.io.Serializable;

public class Operation implements Serializable {
    public String getOperation() {
        return operation;
    }

    private String operation;
    private Object extra;

    public Operation(String operation, Object extra) {

        this.operation = operation;
        this.extra = extra;
    }

    public Object getExtra() {
        return extra;
    }
}
