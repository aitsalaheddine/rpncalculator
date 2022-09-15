package com.cacib.domain.port.driving;

import com.cacib.domain.model.OperatorEnum;
import com.cacib.domain.model.Stack;
import com.cacib.domain.model.exception.StackNotFoundException;

import java.util.HashMap;
import java.util.List;

public interface CalculatorPort {
    void createStack();

    HashMap<Integer, Stack> listAllStacks();

    Stack getStack(Integer id);

    void deleteStack(Integer id);

    void pushToStack(Integer id, Integer value);

    void calculate(Integer id, String value) throws StackNotFoundException;

    default List<OperatorEnum> getOperations() {
        return OperatorEnum.getOperations();
    }

    ;
}
