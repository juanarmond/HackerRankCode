// This challenge is part of a tutorial track by MyCodeSchool and is accompanied by a video lesson.
// You’re given the pointer to the head node of a linked list and the position of a node to delete. Delete the node at the given position and return the head node. A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. The list may become empty after you delete the node.
// Input Format
// You have to complete the deleteNode(SinglyLinkedListNode* llist, int position) method which takes two arguments - the head of the linked list and the position of the node to delete. You should NOT read any input from stdin/console. position will always be at least 0 and less than the number of the elements in the list.
// The first line of input contains an integer , denoting the number of elements in the linked list. 
// The next  lines contain an integer each in a new line, denoting the elements of the linked list in the order. 
// The last line contains an integer  denoting the position of the node that has to be deleted form the linked list.


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;
        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the deleteNode function below.
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        SinglyLinkedListNode tail = head;
        SinglyLinkedListNode tmp = tail;
        int pos = 1;
        if(position == 0){
            return tail.next;
        }
        if(position == 1){
            head.next = tail.next.next;
            return head;
        }else{
            while(tail.next != null){
                tail = tail.next;
                pos++;
                if(pos == position){
                    tmp = tail.next.next;
                    tail.next = null;
                    break;
                }
            }
            tail.next = tmp;
        } 
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        SinglyLinkedList llist = new SinglyLinkedList();
        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }
        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        SinglyLinkedListNode llist1 = deleteNode(llist.head, position);
        printSinglyLinkedList(llist1, " ", bufferedWriter);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
