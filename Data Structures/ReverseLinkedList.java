// This challenge is part of a tutorial track by MyCodeSchool and is accompanied by a video lesson.
// You’re given the pointer to the head node of a linked list. Change the next pointers of the nodes so that their order is reversed. The head pointer given may be null meaning that the initial list is empty.
// Input Format
// You have to complete the SinglyLinkedListNode reverse(SinglyLinkedListNode head) method which takes one argument - the head of the linked list. You should NOT read any input from stdin/console.
// The input is handled by the code in the editor and the format is as follows:
// The first line contains an integer , denoting the number of test cases. 
// Each test case is of the following format:
// The first line contains an integer , denoting the number of elements in the linked list. 
// The next  lines contain an integer each, denoting the elements of the linked list.

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

    // Complete the reverse function below.
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {  
            return head;  
        }
        SinglyLinkedListNode tmp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }

    //Non recursion
    static SinglyLinkedListNode reverseNonRecusion(SinglyLinkedListNode head) {
        if(head == null || head.next == null){
        return head;
    }
	    SinglyLinkedListNode prev = null;
	    SinglyLinkedListNode current = head;
	    SinglyLinkedListNode next = null;
	    while (current != null) {
	       next = current.next;
	       current.next = prev;
	       prev = current;
	       current = next;
	    }
	    head = prev;
	    return head;   
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();
            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                llist.insertNode(llistItem);
            }
            SinglyLinkedListNode llist1 = reverse(llist.head);
            printSinglyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
