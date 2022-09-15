package com.cacib.domain.adapter;

import com.cacib.domain.model.OperatorEnum;
import com.cacib.domain.model.RpnCalculator;
import com.cacib.domain.model.Stack;
import com.cacib.domain.port.driving.CalculatorPort;
import com.cacib.domain.model.exception.StackNotFoundException;

import java.util.HashMap;

public class CalculatorAdapter implements CalculatorPort {

    private final RpnCalculator rpnCalculator = RpnCalculator.getInstance();

    public CalculatorAdapter() {
    }

    @Override
    public void createStack() {
        rpnCalculator.createStack();
    }

    @Override
    public HashMap<Integer, Stack> listAllStacks() {
        return rpnCalculator.getAllStacks();
    }

    @Override
    public Stack getStack(Integer id) {
        return rpnCalculator.getStack(id);
    }

    @Override
    public void deleteStack(Integer id) {
        rpnCalculator.deleteStack(id);
    }

    @Override
    public void pushToStack(Integer id, Integer value) {
        rpnCalculator.pushToStack(id, value);
    }

    @Override
    public void calculate(Integer id, String op) throws StackNotFoundException {
        rpnCalculator.calculate(id, OperatorEnum.valueOfOperator(op));
    }

    @Override
    public void clear() {
        rpnCalculator.getAllStacks().clear();
    }
}
