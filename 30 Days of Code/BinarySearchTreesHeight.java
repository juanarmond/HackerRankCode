// Objective 
// Today, we're working with Binary Search Trees (BSTs). Check out the Tutorial tab for learning materials and an instructional video!
// Task 
// The height of a binary search tree is the number of edges between the tree's root and its furthest leaf. You are given a pointer, , pointing to the root of a binary search tree. Complete the getHeight function provided in your editor so that it returns the height of the binary search tree.
// Input Format
// The locked stub code in your editor reads the following inputs and assembles them into a binary search tree: 
// The first line contains an integer, , denoting the number of nodes in the tree. 
// Each of the  subsequent lines contains an integer, , denoting the value of an element that must be added to the BST.

// Recursion in trees
// Tree algorithms can be defined recursively, by evaluating the current tree and the trees branching from it
// From DSA Lecture Notes
// public int size(TreeNode t) { 
//     if (t == null)
//         return 0;
//     return size(t.left) + 1 + size(t.right);
//     }
// public int height(TreeNode t) {
//     if (t == null) return 0;
//     return 1 + Math.max(height(t.left), height(t.right)); }
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

    //Recursive
    public static int getHeight(Node root){
      //Write your code here
        if(root == null){
            return -1;
        }else{
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }

    //Return the tree size
    // static int size(Node t) {
    //     if (t == null)
    //         return 0;
    //     return size(t.left) + 1 + size(t.right);
    // }

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
        int height=getHeight(root);
        System.out.println(height);
    }
}