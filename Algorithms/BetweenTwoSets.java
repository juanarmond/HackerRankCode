// You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:
// The elements of the first array are all factors of the integer being considered
// The integer being considered is a factor of all elements of the second array
// These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.
// For example, given the arrays  and , there are two numbers between them:  and .  , ,  and  for the first value. Similarly, ,  and , .
// Function Description
// Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.
// getTotalX has the following parameter(s):
// a: an array of integers
// b: an array of integers
// Input Format
// The first line contains two space-separated integers,  and , the number of elements in array  and the number of elements in array . 
// The second line contains  distinct space-separated integers describing  where . 
// The third line contains  distinct space-separated integers describing  where .
// Constraints

// Output Format
// Print the number of integers that are considered to be between  and .

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        
        int total = 0;
        int count = 0;
        for(int i=a[a.length-1]; i<=b[0]; i++){        
            for (Integer n : a) {
                if (i % n == 0) {
                    count += 1;
                }
            }
            for (Integer m : b) {
                if (m % i == 0) {
                    count += 1;
                }
            }
            if (count == (a.length + b.length)) {
                total += 1;
            }
            count = 0;
        }
        return total;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}
