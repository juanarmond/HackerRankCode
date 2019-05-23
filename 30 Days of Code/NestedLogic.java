// Objective 
// Today's challenge puts your understanding of nested conditional statements to the test. You already have the knowledge to complete this challenge, but check out the Tutorial tab for a video on testing!
// Task 
// Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:
// If the book is returned on or before the expected return date, no fine will be charged (i.e.: .
// If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, .
// If the book is returned after the expected return month but still within the same calendar year as the expected return date, the .
// If the book is returned after the calendar year in which it was expected, there is a fixed fine of .
// Input Format
// The first line contains  space-separated integers denoting the respective , , and  on which the book was actually returned. 
// The second line contains  space-separated integers denoting the respective , , and  on which the book was expected to be returned (due date).

import java.io.*;
import java.util.*;

public class Solution {

    public static void calc(int[] act, int[] exp){
        // System.out.println(Arrays.toString(act));
        // System.out.println(Arrays.toString(exp));
        if(act[2]<exp[2]){
            System.out.println(0);
        }else if(act[2]>exp[2]){
            System.out.println(10000);
        }else if(act[1]>exp[1]){
            System.out.println(500*(act[1]-exp[1]));
        }else if(act[0]>exp[0]){
            System.out.println(15*(act[0]-exp[0]));
        }else{
            System.out.println(0);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int[] act = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] exp = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Minha
        // int input = 0;
        // int[] act = new int[3];
        // int[] exp = new int[3];
        // int pos = 0;
        // while(input<6){
        //     if(input < 3){
        //         act[pos] = sc.nextInt();
        //     }else{
        //         exp[pos] = sc.nextInt();
        //     }
        //     input++;
        //     pos++;
        //     if(input == 3){
        //         pos = 0;
        //     }

        // }
        calc(act, exp);
    }
}

