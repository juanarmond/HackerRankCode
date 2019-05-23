// Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the Programmer (the day of the year) during a year in the inclusive range from  to .
// From  to , Russia's official calendar was the Julian calendar; since  they used the Gregorian calendar system. The transition from the Julian to Gregorian calendar system occurred in , when the next day after January  was February . This means that in , February  was the  day of the year in Russia.
// In both calendar systems, February is the only month with a variable amount of days; it has  days during a leap year, and days during all other years. In the Julian calendar, leap years are divisible by ; in the Gregorian calendar, leap years are either of the following:
// Divisible by .
// Divisible by  and not divisible by .
// Given a year, , find the date of the  day of that year according to the official Russian calendar during that year. Then print it in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is .
// For example, the given .   is divisible by , so it is a leap year. The  day of a leap year after  is September 12, so the answer is .
// Function Description
// Complete the dayOfProgrammer function in the editor below. It should return a string representing the date of the  day of the year given.
// dayOfProgrammer has the following parameter(s):
// year: an integer
// Input Format
// A single integer denoting year .
// Constraints

// Output Format
// Print the full date of Day of the Programmer during year  in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is .

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

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        String leap = "12";
        String notLeap = "13";
        boolean isLeap = false;
        if(year>=1700 && year<=1917){
            if(year%4==0){
                isLeap = true;
            }
        }else if(year >=1919){
            if(year%4==0 && year%100!=0){
                isLeap = true;
            }else if(year%100==0 && year%400==0){
                isLeap = true;
            }
        }else{//year ==1918
            return "26.09."+year;
        }
        if(isLeap){
            return leap+".09."+year;
        }else{
            return notLeap+".09."+year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
