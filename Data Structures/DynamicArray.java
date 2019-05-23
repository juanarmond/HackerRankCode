// Create a list, , of  empty sequences, where each sequence is indexed from  to . The elements within each of the  sequences also use -indexing.
// Create an integer, , and initialize it to .
// The  types of queries that can be performed on your list of sequences () are described below:
// Query: 1 x y
// Find the sequence, , at index  in .
// Append integer  to sequence .
// Query: 2 x y
// Find the sequence, , at index  in .
// Find the value of element  in  (where  is the size of ) and assign it to .
// Print the new value of  on a new line
// Task 
// Given , , and  queries, execute each query.
// Note:  is the bitwise XOR operation, which corresponds to the ^ operator in most languages. Learn more about it on Wikipedia.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Create a list, segList, of N empty sequences, where each sequence is indexed from 0 to N-1. The elements within each of the N sequences also use 0-indexing.
    List<List<Integer>> segList = new ArrayList<>();
    for(int i=0; i<n; i++ ){
        List<Integer> num = new ArrayList<>();
        segList.add(num);
    }
    // Create an integer, lastAnswer, and initialize it to 0.
    Integer lastAnswer = 0;
    List<Integer> lA = new ArrayList<>();
    for(int i=0; i<queries.size(); i++){
        int q = queries.get(i).get(0);
        int x = queries.get(i).get(1);
        int y = queries.get(i).get(2);
        // Query: 1 x y - Append integer y to sequence 
        int pos = (x^lastAnswer)%n;
        if(q == 1){
            segList.get(pos).add(y);
        }else{
            // Query: 2 x y - Find the sequence, seq, at index pos in seqList
            // Find the value of element y % size in seq (where size is the size of seq) and assign it to .
            // Print the new value of lastAnswer on a new line
            lastAnswer = segList.get(pos).get(y%segList.get(pos).size());
            lA.add(lastAnswer);
        }
    }

    return lA;
}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        List<List<Integer>> queries = new ArrayList<>();
        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        List<Integer> result = dynamicArray(n, queries);
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
    }
}
