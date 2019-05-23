// A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .
// Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.
// Input Format
// The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform). 
// The second line contains  space-separated integers describing the respective elements of the array's initial state.


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void leftRotation(int i, int[] a){
        int[] arr = new int[a.length];
        if(i!=a.length){
            System.arraycopy(a, i, arr, 0, a.length-i);
        }
        if(i>=0){
            System.arraycopy(a, i-i, arr, a.length-i, i);
        }
        if(i==a.length){
            System.out.print(Arrays.toString(a).replace("[","").replace("]", "").replace(",", ""));
        }else{
            System.out.print(Arrays.toString(arr).replace("[","").replace("]", "").replace(",", ""));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        scanner.close();
        leftRotation(d, a);
    }
}
