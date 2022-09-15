package com.cacib.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public enum OperatorEnum {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String operator;
    private static final Map<OperatorEnum, IntBinaryOperator> OPERATORS;

    static {
        OPERATORS = new HashMap<>(4) {
            {
                put(ADDITION, Math::addExact);
                put(SUBTRACTION, Math::subtractExact);
                put(MULTIPLICATION, Math::multiplyExact);
                put(DIVISION, Math::floorDiv);
            }
        };
    }

    OperatorEnum(String operator) {
        this.operator = operator;
    }

    IntBinaryOperator toOperator() {
        return OPERATORS.get(this);
    }

    public static OperatorEnum valueOfOperator(String operator) {
        for (OperatorEnum e : values()) {
            if (e.operator.equals(operator)) {
                return e;
            }
        }
        return null;
    }

    public static List<OperatorEnum> getOperations() {
        return OPERATORS.keySet().stream().toList();
    }
}
