package stack;

import adt.StackADT;

public class FixedSizeArrayBasedStackImpl implements StackADT
{
    public static final int CAPACITY = 10;
    int[] arr;
    private int top = -1;

    public FixedSizeArrayBasedStackImpl()
    {
        this(CAPACITY);
    }

    private FixedSizeArrayBasedStackImpl(int capacity)
    {
        arr = new int[capacity];
    }

    @Override
    public void push(int data) throws Exception
    {
        if (top == CAPACITY - 1)
        {
            throw new Exception("The stack is full");
        }
        arr[++top] = data;
    }

    @Override
    public int pop() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("The stack is empty");
        }
        return arr[top--];
    }

    @Override
    public int top()
    {
        return arr[top];
    }

    @Override
    public int size()
    {
        return top + 1;
    }

    @Override
    public boolean isEmpty()
    {
        return top == -1;
    }

    @Override
    public boolean isFull()
    {
        return top == CAPACITY - 1;
    }
}
