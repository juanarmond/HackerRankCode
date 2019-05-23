// This challenge is part of a tutorial track by MyCodeSchool and is accompanied by a video lesson.
// You’re given the pointer to the head node of a linked list and an integer to add to the list. Create a new node with the given integer, insert this node at the head of the linked list and return the new head node. The head pointer given may be null meaning that the initial list is empty.
// Input Format
// You have to complete the SinglyLinkedListNode Insert(SinglyLinkedListNode head, int data) method which takes two arguments - the head of the linked list and the integer to insert. You should NOT read any input from stdin/console.
// The input is handled by code in the editor and is as follows:
// The first line contains an integer , denoting the number of elements to be inserted at the head of the list. 
// The next  lines contain an integer each, denoting the element to be inserted.

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

    // Complete the insertNodeAtHead function below.
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(data);
        if(llist == null){
            llist = head;
        }else{
            head.next = llist;
            llist = head;
        }
        return llist;
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
          	SinglyLinkedListNode llist_head = insertNodeAtHead(llist.head, llistItem);
          	llist.head = llist_head;
        }
        printSinglyLinkedList(llist.head, "\n", bufferedWriter);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
