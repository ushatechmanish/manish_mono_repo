package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FixedSizeArrayBasedStackImplTest
{

    @Test
    void testPushAndPop()
    {
        FixedSizeArrayBasedStackImpl stack = new FixedSizeArrayBasedStackImpl();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        try
        {
            stack.push(1);
            assertFalse(stack.isEmpty());
            assertEquals(1, stack.size());
            assertEquals(1, stack.top());

            stack.push(2);
            assertFalse(stack.isEmpty());
            assertEquals(2, stack.size());
            assertEquals(2, stack.top());

            int popped = stack.pop();
            assertEquals(2, popped);
            assertFalse(stack.isEmpty());
            assertEquals(1, stack.size());
            assertEquals(1, stack.top());

            popped = stack.pop();
            assertEquals(1, popped);
            assertTrue(stack.isEmpty());
            assertEquals(0, stack.size());

        } catch (Exception e)
        {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void testPopEmptyStack()
    {
        FixedSizeArrayBasedStackImpl stack = new FixedSizeArrayBasedStackImpl();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        // Should throw exception as stack is empty
        assertThrows(Exception.class, stack::pop);
    }

    @Test
    void testPushFullStack()
    {
        FixedSizeArrayBasedStackImpl stack = new FixedSizeArrayBasedStackImpl();
        assertFalse(stack.isFull());

        try
        {
            stack.push(1);
            stack.push(2);
            stack.push(2);
            stack.push(2);
            stack.push(2);
            stack.push(2);
            stack.push(2);
            stack.push(2);
            stack.push(2);
            stack.push(2);
            assertTrue(stack.isFull());

            assertThrows(Exception.class, () ->
            {
                stack.push(3); // Should throw exception as stack is full
            });

        } catch (Exception e)
        {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
