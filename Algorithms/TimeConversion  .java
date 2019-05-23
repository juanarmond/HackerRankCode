// Given a time in -hour AM/PM format, convert it to military (24-hour) time.
// Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
// Function Description
// Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
// timeConversion has the following parameter(s):
// s: a string representing time in  hour format
// Input Format
// A single string  containing a time in -hour clock format (i.e.:  or ), where  and .
// Constraints
// All input times are valid


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */

        char[] c = s.toCharArray();

        if(c[8] == 'P'){
            if(c[0] == '0'){
                c[0] = '1';
                c[1] = (char)((int)(c[1])+2);
            }else if(c[0] == '1' && c[1] != '2'){
                c[0] = '2';
                c[1] = (char)((int)(c[1])+2);
            } 
        }else{
            if(c[0] == '1' && c[1] == '2'){
                c[0] = '0';
                c[1] = '0';
            }
        }
        char[] ch = Arrays.copyOf(c, c.length-2);
        String hour = new String(ch);
        return hour;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
