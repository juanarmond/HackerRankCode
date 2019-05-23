// Objective 
// Today, we're working with regular expressions. Check out the Tutorial tab for learning materials and an instructional video!
// Task 
// Consider a database table, Emails, which has the attributes First Name and Email ID. Given  rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends in .
// Input Format
// The first line contains an integer, , total number of rows in the table. 
// Each of the  subsequent lines contains  space-separated strings denoting a person's first name and email ID, respectively.


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    private static ArrayList<String> nameL = new ArrayList<>();

    public static void nameList(String n, String email){
        // This will match a sequence of 1 or more uppercase and lowercase English letters as well as spaces
        String myRegExString = "@gmail.com";
        // Create a Pattern object (compiled RegEx) and save it as 'p'
        Pattern p = Pattern.compile(myRegExString);
        // We need a Matcher to match our compiled RegEx to a String
        Matcher m = p.matcher(email);
        // if our Matcher finds a match
        if( m.find() ) {
            nameL.add(n);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        // ArrayList<String> nameL = new ArrayList<>();
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");
            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];
            nameList(firstName, emailID);
        }
        scanner.close();
        Collections.sort(nameL);
        for(String name: nameL){
            System.out.println(name);
        }
        
    }
}
