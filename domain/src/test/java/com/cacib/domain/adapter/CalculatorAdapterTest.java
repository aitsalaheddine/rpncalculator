package com.cacib.domain.adapter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorAdapterTest {

    private final CalculatorAdapter underTest = new CalculatorAdapter();

    @BeforeEach
    void setUp() {
        underTest.createStack();
    }

    @AfterEach
    void tearDown() {
        underTest.clear();
    }

    @Test
    void shouldCreateStack() {
        underTest.createStack();
        assertThat(underTest.listAllStacks().size()).isEqualTo(2);
    }
}