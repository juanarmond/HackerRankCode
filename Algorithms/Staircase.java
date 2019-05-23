// Consider a staircase of size :
//    #
//   ##
//  ###
// ####
// Observe that its base and height are both equal to , and the image is drawn using # symbols and spaces. The last line is not preceded by any spaces.
// Write a program that prints a staircase of size .
// Function Description
// Complete the staircase function in the editor below. It should print a staircase as described above.
// staircase has the following parameter(s):
// n: an integer
// Input Format
// A single integer, , denoting the size of the staircase.
// Constraints
//  .
// Output Format
// Print a staircase of size  using # symbols and spaces.
// Note: The last line must have  spaces in it.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        int c = 1;
        for(int i=n-1; i>=0; i--){
            String space = String.join("", Collections.nCopies(i, " "));
            String chr = String.join("", Collections.nCopies(c, "#"));
            System.out.println(space+chr);
            c++;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
