package queue;

import adt.QueueADT;

public class CircularArrayBasedQueueImpl implements QueueADT
{

    private static final int CAPACITY = 10;
    int[] arr;
    int front = -1;
    int rear = -1;
    int size = 0;

    public CircularArrayBasedQueueImpl()
    {
        this(CAPACITY);
    }

    private CircularArrayBasedQueueImpl(int capacity)
    {
        arr = new int[capacity];
    }

    @Override
    public void enQueue(int data) throws Exception
    {
        if (size == CAPACITY)
        {
            throw new Exception("The queue is full");
        }
        rear = rear + 1 % CAPACITY;
        arr[rear] = data;
        if (front == -1)
        {
            front = rear;
        }
        ++size;
    }

    @Override
    public int deQueue() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("The queue is empty");
        }
        --size;
        int result = arr[front];
        if (front == rear)
        {
            front = rear = -1;// to set the values again to -1 as in the initial
        } else
        {
            front = front + 1 % CAPACITY;
        }
        return result;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public int front() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("The queue is empty");
        }
        return arr[front];
    }

    @Override
    public int rear() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("The queue is empty");
        }
        return arr[rear];
    }
}

