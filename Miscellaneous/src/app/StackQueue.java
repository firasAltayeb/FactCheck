package app;

import java.util.ArrayDeque;
import java.util.Deque;

class StackQueue {
    Deque<Integer> deque;
    public StackQueue() {
        deque = new ArrayDeque<>();
    }

    public void push(int x) {
        deque.addLast(x);
    }

    public int pop() {
        int size = deque.size();
        for(int i = 0; i < size - 1; i++)
            push(deque.pollFirst());
        return deque.pollFirst();
    }

    public int top() {
        int size = deque.size();
        for(int i = 0; i < size - 1; i++)
            push(deque.pollFirst());

        int res = deque.peekFirst();
        push(deque.pollFirst());
        return res;
    }

    public boolean empty() {
        return deque.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */