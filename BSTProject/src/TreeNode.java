public class TreeNode
{
    private TreeNode left;
    private TreeNode right;
    private Comparable value;

    public TreeNode(Comparable initValue)
    {
        value = initValue;
        
        left = null;
        right = null;
    }

    public Comparable getValue()
    {
        
        return value;
    }

    public TreeNode getLeft()
    {
        
        return left;
    }

    public TreeNode getRight()
    {
        
        return right;
    }

    public void setValue(Comparable newValue)
    {
        
        value = newValue;
    }

    public void setLeft(TreeNode newLeft)
    {
        
        left = newLeft;
    }

    public void setRight(TreeNode newRight)
    {
        
        right = newRight;
    }
}