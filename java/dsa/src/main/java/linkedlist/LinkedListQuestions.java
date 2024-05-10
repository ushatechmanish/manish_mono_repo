package linkedlist;

import adt.ListNode;
import util.PrintResult;

import java.util.function.BiConsumer;

public class LinkedListQuestions
{
    private static final BiConsumer<String, Object> printResult = new PrintResult();

    public static void main(String[] args) throws IllegalArgumentException
    {
        var obj = new LinkedListQuestions();
        ListNode head = obj.getLinkedListFromArray(4, 15, 7, 140);
        printResult.accept("Tranversing the linkedlist", obj.traverseLinkedList(head));
    }

    private String traverseLinkedList(ListNode head)
    {
        if (head == null) return "";
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current.getNext() != null)
        {
            sb.append(current.getData());
            sb.append("->");
            current = current.getNext();
        }
        sb.append(current.getData());
        return sb.toString();
    }

    private ListNode getLinkedListFromArray(int... entries)
    {
        if (entries.length == 0) return null;
        ListNode head = null;
        ListNode current = null;
        boolean isFirst = true;
        for (int entry : entries)
        {
            if (isFirst)
            {
                head = new ListNode(entry);
                current = head;
                isFirst = false;
                continue;
            }
            current.setNext(new ListNode(entry));
            current = current.getNext();

        }
        return head;
    }
}
