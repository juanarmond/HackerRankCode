// Objective 
// Today, we're going further with Binary Search Trees. Check out the Tutorial tab for learning materials and an instructional video!
// Task 
// A level-order traversal, also known as a breadth-first search, visits each level of a tree's nodes from left to right, top to bottom. You are given a pointer, , pointing to the root of a binary search tree. Complete the levelOrder function provided in your editor so that it prints the level-order traversal of the binary search tree.
// Hint: You'll find a queue helpful in completing this challenge 
// Input Format
// The locked stub code in your editor reads the following inputs and assembles them into a BST: 
// The first line contains an integer,  (the number of test cases). 
// The  subsequent lines each contain an integer, , denoting the value of an element that must be added to the BST.
// Output Format
// Print the  value of each node in the tree's level-order traversal as a single line of  space-separated integers.

// Breadth-first traversal – Java
// From DSA Lecture Notes
// void breadthFirst(TreeNode p) { 
// 	if (p != null){
// 		Queue<TreeNode> queue = new QueueImpl<TreeNode>(); 
// 		queue.enqueue(p); // add root
// 		while (!queue.isEmpty()) {
// 			p = queue.dequeue(); // remove visit(p); // visit
// 			if (p.left != null) // add left child
// 			queue.enqueue(p.left);
// 			if (p.right != null) // add right child
// 			queue.enqueue(p.right);
// 		} 
// 	}
// }


import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{

//Return the tree size
static int size(Node t) {
    if (t == null)
        return 0;
    return size(t.left) + 1 + size(t.right);
}

static void levelOrder(Node root){
      //Write your code here
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

public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}