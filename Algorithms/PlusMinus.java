// Given an array of integers, calculate the fractions of its elements that are positive, negative, and are zeros. Print the decimal value of each fraction on a new line.
// Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
// For example, given the array  there are  elements, two positive, two negative and one zero. Their ratios would be ,  and . It should be printed as
// 0.400000
// 0.400000
// 0.200000
// Function Description
// Complete the plusMinus function in the editor below. It should print out the ratio of positive, negative and zero items in the array, each on a separate line rounded to six decimals.
// plusMinus has the following parameter(s):
// arr: an array of integers
// Input Format
// The first line contains an integer, , denoting the size of the array. 
// The second line contains  space-separated integers describing an array of numbers .


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        float pos=0, neg=0, zero=0;
        for(int i: arr){
            if(i>0){
                pos+=1;
            }else if(i<0){
                neg+=1;
            }else{
                zero+=1;
            }
        }
        System.out.println(pos/arr.length);
        System.out.println(neg/arr.length);
        System.out.println(zero/arr.length);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
