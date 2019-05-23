// Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.
// For example, the length of your array of zeros n=10. Your list of queries is as follows:
//     a b k
//     1 5 3
//     4 8 7
//     6 9 1
// Add the values of  between the indices  and  inclusive:
// index->  1 2 3  4  5 6 7 8 9 10
//     [0,0,0, 0, 0,0,0,0,0, 0]
//     [3,3,3, 3, 3,0,0,0,0, 0]
//     [3,3,3,10,10,7,7,7,0, 0]
//     [3,3,3,10,10,8,8,8,1, 0]
// The largest value is  after all operations are performed.
// Function Description
// Complete the function arrayManipulation in the editor below. It must return an integer, the maximum value in the resulting array.
// arrayManipulation has the following parameters:
// n - the number of elements in your array
// queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n];
        long max = 0;
        for(int i=0; i<queries.length; i++){
            int start = queries[i][0]-1;
            int end = queries[i][1];
            long value = queries[i][2];
            array[start] += value;
            if(end<n){
                array[end] -= value;
            }
        }
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += array[i];
            if(max<sum)
                max= sum;
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] queries = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }
        long result = arrayManipulation(n, queries);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
