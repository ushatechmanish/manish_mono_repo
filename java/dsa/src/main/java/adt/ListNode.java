package adt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode
{
    private final int data;
    private ListNode next;

    public ListNode(int data)
    {
        this.data = data;
    }
}
