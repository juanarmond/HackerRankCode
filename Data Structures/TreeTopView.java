// You are given a pointer to the root of a binary tree. Print the top view of the binary tree. 
// Top view means when you look the tree from the top the nodes, what you will see will be called the top view of the tree. See the example below. 
// You only have to complete the function. 
// For example :
//    1
//     \
//      2
//       \
//        5
//       /  \
//      3    6
//       \
//        4
// Top View : 1 -> 2 -> 5 -> 6

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
    public static void topView(Node root) {
        if(root!=null){

      // queue to peform BFS      
      Queue<Node> queue=new LinkedList<>(); 

      /**sorted look up to maintain the point visible at
     any horizontal distance x , where x may 
     vary [-h , h]  h is the height of tree
     this will be sorted by their horizontal distance 
      **/
       
      TreeMap<Integer,Integer> map=new TreeMap<>();  
      /**
   Look up to maintain the horizontal  distance of children 
   before we can consider them for eligibility 
   in the first lookup **/

      Map<Node,Integer> levelmap=new HashMap<>();   
      //Initialize with root,  root is always visible
      // horizontal distance of root is 0 ie center
      map.put(0,root.data);
      levelmap.put(root,0);
      queue.add(root);

      Node node;
      while(!queue.isEmpty()){
        node=queue.poll();

        /** Remove the parent node we will 
       populate the children's distances immediately **/
        int iLevel=levelmap.remove(node);  


        /** claim the spot if no nodes has reached 
        to this specific horizontal distance before **/   

        map.putIfAbsent(iLevel,node.data);


        if(node.left!=null){
          /** left child will  have 
     horizontal distance = parent's distance -1 **/
          levelmap.put(node.left,iLevel-1);
          /** enqueued for BFS **/
          queue.add(node.left);
        }
        if(node.right!=null){
          /** right child will  have 
        horizontal distance = parent's distance +1 **/
          levelmap.put(node.right,iLevel+1);
          /** enqueued for BFS **/
          queue.add(node.right);
        }  

      }
      for(Integer a:map.values())
        System.out.print(a+" ");
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
        topView(root);
    }   
}