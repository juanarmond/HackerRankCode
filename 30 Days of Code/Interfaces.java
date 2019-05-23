// Objective 
// Today, we're learning about Interfaces. Check out the Tutorial tab for learning materials and an instructional video!
// Task 
// The AdvancedArithmetic interface and the method declaration for the abstract divisorSum(n) method are provided for you in the editor below.
// Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface. The implementation for the divisorSum(n) method must return the sum of all divisors of .
// Input Format
// A single line containing an integer, n.

import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
   int divisorSum(int n);
}
class Calculator implements AdvancedArithmetic {
    //Looping fom 0 to half of n.
    public int divisorSum(int n) {
        int sum = n;
        for(int i=1; i<=n/2; i++){
            if(n%i==0){
                sum+=i;
            }
        }
        return sum;
    }

    // Looping from 0 to n.
    // public int divisorSum(int n) {
    //     int sum = 0;
    //     for(int i=1; i<=n; i++){
    //         if(n%i==0){
    //             sum+=i;
    //         }
    //     }
    //     return sum;
    // }

}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
        AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}