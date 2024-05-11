package tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTreeNode
{
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode()
    {
    }

    public BinaryTreeNode(int data)
    {
        this.data = data;
    }
}
