// HackerLand University has the following grading policy:
// Every student receives a  in the inclusive range from  to .
// Any  less than  is a failing grade.
// Sam is a professor at the university and likes to round each student's  according to these rules:
// If the difference between the  and the next multiple of  is less than , round  up to the next multiple of .
// If the value of  is less than , no rounding occurs as the result will still be a failing grade.
// For example,  will be rounded to  but  will not be rounded because the rounding would result in a number that is less than .
// Given the initial value of  for each of Sam's  students, write code to automate the rounding process.
// Function Description
// Complete the function gradingStudents in the editor below. It should return an integer array consisting of rounded grades.
// gradingStudents has the following parameter(s):
// grades: an array of integers representing grades before rounding
// Input Format
// The first line contains a single integer, , the number of students. 
// Each line  of the  subsequent lines contains a single integer, , denoting student 's grade.


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        /*
         * Write your code here.
         */
        int[] results =  new int[grades.length];
        int i=0;
        for(int g : grades){
            if(g>=38 && (5-(g%5))<3){
                results[i] = g + (5 - g % 5);
                i++;
            }else{
                results[i] = g;
                i++;
            }
        }
        return results;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
