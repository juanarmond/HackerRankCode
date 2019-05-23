// You are given a pointer to the root of a binary tree. You need to print the level order traversal of this tree. In level order traversal, we visit the nodes level by level from left to right. You only have to complete the function. For example:
//      1
//       \
//        2
//         \
//          5
//         /  \
//        3    6
//         \
//          4  
// For the above tree, the level order traversal is 1 -> 2 -> 5 -> 3 -> 6 -> 4.
// Input Format
// You are given a function,

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
        if (root != null){
            Queue<Node> queue = new LinkedList<>();
            queue.add(root); // add root
        while (!queue.isEmpty()) {
            Node cur = queue.remove(); // remove
            System.out.print(cur.data + " "); // visit
            if (cur.left != null) // add left child
                queue.add(cur.left);
            if (cur.right != null) // add right child
                queue.add(cur.right);
            }
        }     
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}