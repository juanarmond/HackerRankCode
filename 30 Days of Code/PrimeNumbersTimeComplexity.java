// Objective 
// Today we're learning about running time! Check out the Tutorial tab for learning materials and an instructional video!
// Task 
// A prime is a natural number greater than  that has no positive divisors other than  and itself. Given a number, , determine and print whether it's  or .
// Note: If possible, try to come up with a  primality algorithm, or see what sort of optimizations you come up with for an  algorithm. Be sure to check out the Editorial after submitting your code!
// Input Format
// The first line contains an integer, , the number of test cases. 
// Each of the  subsequent lines contains an integer, , to be tested for primality.


import java.io.*;
import java.util.*;

public class Solution {
    public static void prime(int n){
        double sqrt = Math.sqrt((double)n);
            boolean flag = true;
            // System.out.println(sqrt);
            for(int i=2; i<=sqrt;i++){
                if(n%i==0){
                    flag = false;
                    break;
                }
            }
            if(flag && n!=1){
                System.out.println("Prime");
            }else{
                System.out.println("Not prime");
            }     
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int input =sc.nextInt();
        while(input>0){
            int n = sc.nextInt();
            prime(n);
            input--;
        }
    }
}

