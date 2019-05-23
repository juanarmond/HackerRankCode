// This challenge is part of a tutorial track by MyCodeSchool and is accompanied by a video lesson.
// You’re given the pointer to the head node of a linked list, an integer to add to the list and the position at which the integer must be inserted. Create a new node with the given integer, insert this node at the desired position and return the head node.
// A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. The head pointer given may be null meaning that the initial list is empty.
// As an example, if your list starts as  and you want to insert a node at position  with , your new list should be 
// Function Description Complete the function insertNodeAtPosition in the editor below. It must return a reference to the head node of your finished list.
// insertNodeAtPosition has the following parameters:
// head: a SinglyLinkedListNode pointer to the head of the list
// data: an integer value to insert as data in your new node
// position: an integer position to insert the new node, zero based indexing
// Input Format
// The first line contains an integer , the number of elements in the linked list. 
// Each of the next  lines contains an integer SinglyLinkedListNode[i].data. 
// The last line contains an integer .

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

    // Complete the insertNodeAtPosition function below.
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode tail = new SinglyLinkedListNode(data);
        SinglyLinkedListNode tmp = tail;
        if(head == null){
            head = tail;
        }else{
            tail = head;
            int pos = 1;
            while(tail.next != null){
                tail = tail.next;
                pos++;
                if(pos == position){
                    tmp = tail.next;
                    tail.next = new SinglyLinkedListNode(data);
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
        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);
        printSinglyLinkedList(llist_head, " ", bufferedWriter);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
