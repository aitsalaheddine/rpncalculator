package com.cacib.domain.model;

import com.cacib.domain.port.exception.StackNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RpnCalculatorTest {

    private final RpnCalculator underTest = RpnCalculator.getInstance();

    @BeforeEach
    void setUp() {
        underTest.createStack();
    }

    @Test
    void shouldGetInstance() {
        assertThat(underTest).isInstanceOf(RpnCalculator.class);
    }

    @Test
    void shouldCreateStack() {
        assertThat(underTest.getAllStacks()).isNotEmpty();
    }

    @Test
    void shouldDeleteStack() {
        underTest.deleteStack(1);
        assertThat(underTest.getAllStacks()).isEmpty();
    }

    @Test
    @DisplayName("3 7 +")
    void shouldCalculate3and7GivenOperatorPlus() throws StackNotFoundException {
        underTest.pushToStack(1, 3);
        underTest.pushToStack(1, 7);
        underTest.calculate(1, OperatorEnum.ADDITION);
        assertThat(underTest.getStack(1).pull()).isEqualTo(10);
    }

    @Test
    @DisplayName("3 7 + 2 /")
    void shouldCalculateGivenTwoOperators() throws StackNotFoundException {
        underTest.pushToStack(1, 3);
        underTest.pushToStack(1, 7);
        underTest.calculate(1, OperatorEnum.ADDITION);
        underTest.pushToStack(1, 2);
        underTest.calculate(1, OperatorEnum.DIVISION);
        assertThat(underTest.getStack(1).pull()).isEqualTo(5);
    }

    @Test
    @DisplayName("1 2 3 4 + * +")
    void shouldCalculateGivenThreeOperators() throws StackNotFoundException {
        underTest.pushToStack(1, 1);
        underTest.pushToStack(1, 2);
        underTest.pushToStack(1, 3);
        underTest.pushToStack(1, 4);

        underTest.calculate(1, OperatorEnum.ADDITION);
        underTest.calculate(1, OperatorEnum.MULTIPLICATION);
        underTest.calculate(1, OperatorEnum.ADDITION);

        assertThat(underTest.getStack(1).pull()).isEqualTo(15);
    }
}