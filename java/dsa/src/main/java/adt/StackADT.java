package adt;

public interface StackADT
{
    void push(int data) throws Exception;

    // Removes and returns the last inserted element from stack
    int pop() throws Exception;

    // Return without removing the last inserted element from stack
    int top();

    int size();

    boolean isEmpty();

    boolean isFull();
}
