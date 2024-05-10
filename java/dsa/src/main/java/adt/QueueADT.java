package adt;

public interface QueueADT
{
    void enQueue(int data) throws Exception;

    int deQueue() throws Exception;

    int size();

    boolean isEmpty();

    /**
     * Returns the element at the front without removing it
     */
    int front() throws Exception;

    /**
     * Returns the element at the rear without removing it
     */
    int rear() throws Exception;
}
