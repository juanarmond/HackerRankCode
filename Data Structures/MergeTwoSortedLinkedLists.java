// This challenge is part of a tutorial track by MyCodeSchool
// You’re given the pointer to the head nodes of two sorted linked lists. The data in both lists will be sorted in ascending order. Change the next pointers to obtain a single, merged linked list which also has data in ascending order. Either head pointer given may be null meaning that the corresponding list is empty.
// Input Format
// You have to complete the SinglyLinkedListNode MergeLists(SinglyLinkedListNode headA, SinglyLinkedListNode headB) method which takes two arguments - the heads of the two sorted linked lists to merge. You should NOT read any input from stdin/console.
// The input is handled by the code in the editor and the format is as follows:
// The first line contains an integer , denoting the number of test cases. 
// The format for each test case is as follows:
// The first line contains an integer , denoting the length of the first linked list. 
// The next  lines contain an integer each, denoting the elements of the linked list. 
// The next line contains an integer , denoting the length of the second linked list. 
// The next  lines contain an integer each, denoting the elements of the second linked list.

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

    // Complete the mergeLists function below.
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
       SinglyLinkedList mergedList = new SinglyLinkedList();
        while(head1 != null || head2 != null){
            if(head1 == null){
                mergedList.insertNode(head2.data);
                head2 = head2.next;
            }else if(head2 == null){
                mergedList.insertNode(head1.data);
                head1 = head1.next;
            }else if(head1.data >= head2.data){
                mergedList.insertNode(head2.data);
                head2 = head2.next;
            }else{
                head1 = head1.next;
            }
        }
        return mergedList.head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();
            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                llist1.insertNode(llist1Item);
            }
          	SinglyLinkedList llist2 = new SinglyLinkedList();
            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                llist2.insertNode(llist2Item);
            }
            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);
            printSinglyLinkedList(llist3, " ", bufferedWriter);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
