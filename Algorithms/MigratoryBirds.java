// You have been asked to help study the population of birds migrating across the continent. Each type of bird you are interested in will be identified by an integer value. Each time a particular kind of bird is spotted, its id number will be added to your array of sightings. You would like to be able to find out which type of bird is most common given a list of sightings. Your task is to print the type number of that bird and if two or more types of birds are equally common, choose the type with the smallest ID number.
// For example, assume your bird sightings are of types . There are two each of types  and , and one sighting of type . Pick the lower of the two types seen twice: type .
// Function Description
// Complete the migratoryBirds function in the editor below. It should return the lowest type number of the most frequently sighted bird.
// migratoryBirds has the following parameter(s):
// arr: an array of integers representing types of birds sighted
// Input Format
// The first line contains an integer denoting , the number of birds sighted and reported in the array . 
// The second line describes  as  space-separated integers representing the type numbers of each bird sighted.
// Constraints

// It is guaranteed that each type is , , , , or .
// Output Format
// Print the type number of the most common bird; if two or more types of birds are equally common, choose the type with the smallest ID number.


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

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        int[] birds = new int[6];

        for(int i : arr){
            birds[i] =  birds[i]+1;
        }
        int tmp=birds[0];
        int maxBird = 1;
        for(int i=1; i<birds.length; i++){
            // System.out.println(i + " " + birds[i]);
            if(birds[i]>=tmp){
                //System.out.println(i + " " + birds[i]);
                tmp = birds[i];
                maxBird=i;
            }
        }
        int secMaxBird =0;
        for(int i=1; i<birds.length; i++){
            if(birds[i]==birds[maxBird]&& i<maxBird){
                secMaxBird = i;
            }
        }
        if(secMaxBird!=0){
            return secMaxBird;
        }else{
            return maxBird;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
