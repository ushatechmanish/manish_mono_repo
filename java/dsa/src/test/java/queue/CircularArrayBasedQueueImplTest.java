package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularArrayBasedQueueImplTest
{

    @Test
    void testEnqueueAndDequeue()
    {
        CircularArrayBasedQueueImpl queue = new CircularArrayBasedQueueImpl();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        try
        {
            queue.enQueue(1);
            assertFalse(queue.isEmpty());
            assertEquals(1, queue.size());
            assertEquals(1, queue.front());
            assertEquals(1, queue.rear());

            queue.enQueue(2);
            assertFalse(queue.isEmpty());
            assertEquals(2, queue.size());
            assertEquals(1, queue.front());
            assertEquals(2, queue.rear());

            int dequeued = queue.deQueue();
            assertEquals(1, dequeued);
            assertFalse(queue.isEmpty());
            assertEquals(1, queue.size());
            assertEquals(2, queue.front());
            assertEquals(2, queue.rear());

            dequeued = queue.deQueue();
            assertEquals(2, dequeued);
            assertTrue(queue.isEmpty());
            assertEquals(0, queue.size());

        } catch (Exception e)
        {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void testFrontAndRear()
    {
        CircularArrayBasedQueueImpl queue = new CircularArrayBasedQueueImpl();
        assertTrue(queue.isEmpty());

        try
        {
            queue.enQueue(1);
            assertEquals(1, queue.front());
            assertEquals(1, queue.rear());

            queue.enQueue(2);
            assertEquals(1, queue.front());
            assertEquals(2, queue.rear());

            queue.deQueue();
            assertEquals(2, queue.front());
            assertEquals(2, queue.rear());

            queue.deQueue();
            assertTrue(queue.isEmpty());

        } catch (Exception e)
        {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void testEmptyQueue()
    {
        CircularArrayBasedQueueImpl queue = new CircularArrayBasedQueueImpl();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        // Should throw exception as queue is empty
        assertThrows(Exception.class, queue::deQueue);

        // Should throw exception as queue is empty
        assertThrows(Exception.class, queue::front);

        // Should throw exception as queue is empty
        assertThrows(Exception.class, queue::rear);
    }

    @Test
    void testFullQueue()
    {
        CircularArrayBasedQueueImpl queue = new CircularArrayBasedQueueImpl();
        assertTrue(queue.isEmpty());

        try
        {
            for (int i = 0; i < 10; i++)
            {
                queue.enQueue(i);
            }
            assertFalse(queue.isEmpty());

            assertThrows(Exception.class, () ->
            {
                queue.enQueue(10); // Should throw exception as queue is full
            });

        } catch (Exception e)
        {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
