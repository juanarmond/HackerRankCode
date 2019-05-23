// A binary tree is a tree which is characterized by one of the following properties:
// It can be empty (null).
// It contains a root node only.
// It contains a root node with a left subtree, a right subtree, or both. These subtrees are also binary trees.
// In-order traversal is performed as
// Traverse the left subtree.
// Visit root.
// Traverse the right subtree.
// For this in-order traversal, start from the left child of the root node and keep exploring the left subtree until you reach a leaf. When you reach a leaf, back up to its parent, check for a right child and visit it if there is one. If there is not a child, you've explored its left and right subtrees fully. If there is a right child, traverse its left subtree then its right in the same manner. Keep doing this until you have traversed the entire tree. You will only store the values of a node as you visit when one of the following is true:
// it is the first node visited, the first time visited
// it is a leaf, should only be visited once
// all of its subtrees have been explored, should only be visited once while this is true
// it is the root of the tree, the first time visited
// Swapping: Swapping subtrees of a node means that if initially node has left subtree L and right subtree R, then after swapping, the left subtree will be R and the right subtree, L.
// For example, in the following tree, we swap children of node 1.
//                                 Depth
//     1               1            [1]
//    / \             / \
//   2   3     ->    3   2          [2]
//    \   \           \   \
//     4   5           5   4        [3]
// In-order traversal of left tree is 2 4 1 3 5 and of right tree is 3 5 1 2 4.
// Swap operation:
// We define depth of a node as follows:
// The root node is at depth 1.
// If the depth of the parent node is d, then the depth of current node will be d+1.
// Given a tree and an integer, k, in one operation, we need to swap the subtrees of all the nodes at each depth h, where h ∈ [k, 2k, 3k,...]. In other words, if h is a multiple of k, swap the left and right subtrees of that level.
// You are given a tree of n nodes where nodes are indexed from [1..n] and it is rooted at 1. You have to perform t swap operations on it, and after each swap operation print the in-order traversal of the current state of the tree.
// Function Description
// Complete the swapNodes function in the editor below. It should return a two-dimensional array where each element is an array of integers representing the node indices of an in-order traversal after a swap operation.
// swapNodes has the following parameter(s): 
// - indexes: an array of integers representing index values of each , beginning with , the first element, as the root.
// - queries: an array of integers, each representing a  value.

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

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

public class Solution {

    /*
     * Complete the swapNodes function below.
     */
    static class BinaryNode
{
    BinaryNode leftNode;
    BinaryNode rightNode;
    int value;
    int depth;
    BinaryNode(int val, int depth) {
        this.value = val;
        this.depth = depth;
    }
    BinaryNode() {
        value = -1;
        leftNode = null;
        rightNode = null;
    }

    static int constructBinaryTree(List<BinaryNode> ndList, 
            int [][] arr, 
            int index) {
        int depth = 0;
        int startIndx = index;
        List<BinaryNode> tndList = new ArrayList<BinaryNode>();
        for (BinaryNode nd : ndList) {
            if (arr[startIndx][0] != -1) {
                nd.leftNode = new BinaryNode(arr[startIndx][0], nd.depth+1);
                tndList.add(nd.leftNode);
                depth = nd.leftNode.depth;
            }
            if (arr[startIndx][1] != -1) {
                nd.rightNode = new BinaryNode(arr[startIndx][1], nd.depth+1);
                tndList.add(nd.rightNode);
                depth = nd.rightNode.depth;
            }
            startIndx++;

        }
        if (tndList.size() > 0) {
            depth = BinaryNode.constructBinaryTree(tndList, arr, startIndx);
        }
        return depth;
    }

    static int lastIndex = 0;
    static void inOrderTraverse(BinaryNode nd, 
                int [] traverseResult, 
                int query
                ) {
         if (nd == null) return;
         /// QUERY LOGIC
         for (int i=1; (i * query) <= nd.depth; i++) {
             if ((i * query) == nd.depth) {
                 BinaryNode tnd = nd.rightNode;
                 nd.rightNode = nd.leftNode;
                 nd.leftNode = tnd;
                 break;
             }
         }
        /// QUERY LOGIC
         inOrderTraverse(nd.leftNode, traverseResult, query);
         traverseResult[lastIndex++] = nd.value;
         inOrderTraverse(nd.rightNode, traverseResult, query);
     }
}
/*
 * Complete the swapNodes function below.
 */
static int[][] swapNodes(int[][] indexes, int[] queries) {
    int [][] resultArr = new int[queries.length][];

    BinaryNode ndroot = new BinaryNode(1, 1);
    BinaryNode nd = ndroot;
    List<BinaryNode> ndList = new ArrayList<BinaryNode>();
    ndList.add(nd);

    // construct binary tree
    BinaryNode.constructBinaryTree(ndList, indexes, 0);
    for (int i = 0; i < queries.length; i++) {
        int [] traverseResult = new int[indexes.length];
        BinaryNode.lastIndex = 0;
        BinaryNode.inOrderTraverse(ndroot, traverseResult, queries[i]);
        resultArr[i] = traverseResult;
    }
    return resultArr;
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
