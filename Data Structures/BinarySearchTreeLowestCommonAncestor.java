// You are given pointer to the root of the binary search tree and two values  and . You need to return the lowest common ancestor (LCA) of  and  in the binary search tree.
// image 
// In the diagram above, the lowest common ancestor of the nodes  and  is the node . Node  is the lowest node which has nodes  and  as descendants.
// Function Description
// Complete the function lca in the editor below. It should return a pointer to the lowest common ancestor node of the two values given.
// lca has the following parameters: 
// - root: a pointer to the root node of a binary search tree 
// - v1: a node.data value 
// - v2: a node.data value
// Input Format
// The first line contains an integer, , the number of nodes in the tree. 
// The second line contains  space-separated integers representing  values. 
// The third line contains two space-separated integers,  and .
// To use the test data, you will have to create the binary search tree yourself. Here on the platform, the tree will be created for you.

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

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        //Decide if you have to call rekursively
        //Samller than both
        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }
        //Bigger than both
        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }
        //Else solution already found
        return root;
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
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }   
}