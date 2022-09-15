package com.cacib.domain.model;

import com.cacib.domain.port.exception.StackNotFoundException;

import java.util.HashMap;
import java.util.function.IntBinaryOperator;

public final class RpnCalculator {
    private static RpnCalculator INSTANCE;
    private final HashMap<Integer, Stack> stacks = new HashMap<>();

    RpnCalculator() {
    }

    public static RpnCalculator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RpnCalculator();
        }
        return INSTANCE;
    }

    public void createStack() {
        stacks.put(stacks.size() + 1, new Stack());
    }

    public void deleteStack(Integer id) {
        stacks.remove(id);
    }


    public HashMap<Integer, Stack> getAllStacks() {
        return stacks;
    }

    public Stack getStack(Integer id) {
        return stacks.get(id);
    }

    public void pushToStack(Integer id, Integer value) {
        stacks.get(id).push(value);
    }

    public void calculate(Integer stackId, OperatorEnum operator) throws StackNotFoundException {
        if (stacks.containsKey(stackId)) {
            Stack stack = stacks.get(stackId);
            if (!stack.isEmpty()) {
                Integer rightOperand = stack.pull();
                Integer leftOperand = stack.pull();
                IntBinaryOperator operation = operator.toOperator();
                stack.push(operation.applyAsInt(leftOperand, rightOperand));
            }
        } else throw new StackNotFoundException("Stack doesnt exit.");
    }
}
