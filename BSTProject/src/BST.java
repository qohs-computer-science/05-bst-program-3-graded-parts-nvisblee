import java.lang.Comparable;

public class BST implements BSTInterface
{

    private TreeNode root;
  
    private int size;

   
    public BST()
    {
       
        root = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    
    public void add(Comparable  newVal)
    {
        root = addHelper(root, newVal);
    }

    private TreeNode addHelper(TreeNode current,Comparable newVal)
    {
        if (current == null)
        {
            size++;
            return new TreeNode(newVal);
        
        }

        
        
        if (newVal.compareTo(current.getValue()) <= 0)
            current.setLeft(addHelper(current.getLeft(), newVal)); // having to use recursion to iterate through (addHelper method)
        else
            current.setRight(addHelper(current.getRight(), newVal)); // and here as well
        return current;
    }

    
    public boolean find(Comparable toFind)
    {
        
        return findHelper(root, toFind); 
    }

    private boolean findHelper(TreeNode current, Comparable toFind)
    {
        if (current == null)
            
            return false;

        
        
        
            int cmp = toFind.compareTo(current.getValue());

        if (cmp == 0)
            return true;
        else if (cmp < 0)
            return findHelper(current.getLeft(), toFind);
        
        else
            return findHelper(current.getRight(), toFind);
    }

   
    public boolean replace(Comparable oldVal, Comparable toAdd)
    {
        boolean existed = find(oldVal);

        if (existed)
            delete(oldVal);

        add(toAdd);
        return existed;
    }

    
    public boolean delete(Comparable oldVal)
    {
        if (!find(oldVal))
            return false;

        root = deleteHelper(root, oldVal);
        size--;
        return true;
    }

    private TreeNode deleteHelper(TreeNode current, Comparable oldVal)
    {
        if (current == null)
            
            return null;

        int cmp = oldVal.compareTo(current.getValue());

        if (cmp < 0)
            current.setLeft(deleteHelper(current.getLeft(), oldVal));
        else if (cmp > 0)
            current.setRight(deleteHelper(current.getRight(), oldVal));
        else
        {
            // no children here 
            if (current.getLeft() == null && current.getRight() == null)
                return null;

            // one child here
            if (current.getLeft() == null)
                return current.getRight();
            
            if (current.getRight() == null)
                return current.getLeft();

            // two  of the children here plz fix (fixed)
            Comparable successor = minValue(current.getRight());
            current.setValue(successor);
            current.setRight(deleteHelper(current.getRight(), successor));
        }

        return current;
    }

    private Comparable minValue(TreeNode node)
    {
        while (node.getLeft() != null)
            node = node.getLeft();

        return node.getValue();
    }

    
    public void printInOrder()
    {
        printInOrderHelper(root);
        
        System.out.println();
    }

    private void printInOrderHelper(TreeNode current)
    {
        if (current == null)
            return;

        printInOrderHelper(current.getLeft());
        System.out.print(current.getValue() + " ");
        printInOrderHelper(current.getRight());
    }

    public void printPreOrder()
    {
        printPreOrderHelper(root);
        System.out.println();
    }

    private void printPreOrderHelper(TreeNode current)
    {
        if (current == null)
            return;

        System.out.print(current.getValue() + " ");
        printPreOrderHelper(current.getLeft());
        printPreOrderHelper(current.getRight());
    }

    public void printPostOrder()
    {
        printPostOrderHelper(root);
        System.out.println();
    }

    private void printPostOrderHelper(TreeNode current)
    {
        if (current == null)
            return;

        printPostOrderHelper(current.getLeft());
        printPostOrderHelper(current.getRight());
        System.out.print(current.getValue() + " ");
    }
} // end class