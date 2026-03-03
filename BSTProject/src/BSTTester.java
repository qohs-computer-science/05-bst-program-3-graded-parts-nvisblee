/*
 * TODO: Arun Mariappan
 * TODO: 2/26
 * TODO: 4
 * TODO: Program Description: This program essentially createes a binary search tree and adds values to it. It has many methods like add, delete, find, replace and transversal that uses recursion. Then we test these methods and print it out based on test cases in the BSTTester class. 
 */

import java.lang.Comparable;

public class BSTTester {
    public static void main(String[] args) {

        
        BST tree = new BST();
        System.out.println("the tests ");
        System.out.println("isEmpty: " + tree.isEmpty());
        System.out.println("size: " + tree.size());
        System.out.println();

        
        System.out.println("Adding Values ");
        Comparable[] values = { "O" ,"R","C" ,"H", "A" , "R" , "D" , "Q", "U" , "I","N","C","E" };

        for (Comparable v : values) {
            System.out.println("Adding: " + v);
            tree.add(v);
        }

        
        System.out.println("After adding:");
        System.out.println("isEmpty : " + tree.isEmpty());
        System.out.println("size: " + tree.size());
        System.out.println();

        
        System.out.println("Traversals");
        System.out.print("in order:  ");
        tree.printInOrder();

        System.out.print("Pre order: ");
        tree.printPreOrder();

        System.out.print("post order:");
        tree.printPostOrder();
    } // end main
} // end class