package com.cacib.domain.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {

    private final Deque<Integer> stack = new ArrayDeque<>();

    public void push(Integer element) {
        stack.addLast(element);
    }

    public Integer pull() {
        return stack.removeLast();
    }

    public Deque<Integer> getStack() {
        return stack;
    }

    public boolean isEmpty() {
        return stack.size() < 2;
    }

    public void clearStack() {
        stack.clear();
    }
}
