// Objective 
// Welcome to the last day! Today, we're discussing bitwise operations. Check out the Tutorial tab for learning materials and an instructional video!
// Task 
// Given set . Find two integers,  and  (where ), from set  such that the value of  is the maximum possible and also less than a given integer, . In this case,  represents the bitwise AND operator.


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int andResult = 0;
            int bestResult = andResult;
            for(int i=1; i<n; i++){
                for(int j=i+1; j<=n; j++){
                    if ((i&j) < k) {
                        andResult = i&j;
                        if (andResult > bestResult){
                            bestResult = andResult;
                        }
                    }
                }
            }
            System.out.println(bestResult);
        }
        scanner.close();
    }
}
