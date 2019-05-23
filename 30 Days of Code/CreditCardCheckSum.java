//Credit Card Checksums

//9795526789839145
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        long creditCard = scan.nextLong();
        
        //Reverse Number
        long reversedNumber = 0;
        long temp = 0;
        while (creditCard > 0) {
            temp = creditCard % 10;
            reversedNumber = reversedNumber * 10 + temp;
            creditCard = creditCard / 10;
        }
        //System.out.println(reversedNumber);

        //Sum of Odd positions
        int sum = 0;
        int mult = 0;
        for (int i = 0; i < 16; i++) {
            if (i % 2 != 0) {
                sum = (sum + (int) (reversedNumber % 10));
                reversedNumber = reversedNumber / 10;
            }else if(i % 2 == 0){
                if((int)(reversedNumber % 10)*2 >10){
                    if((int) (reversedNumber % 10) * 2 == 10){
                        mult = (mult + 1);
                        reversedNumber = reversedNumber / 10;
                    }
                    if ((int) (reversedNumber % 10) * 2 == 12) {
                        mult = (mult + 3);
                        reversedNumber = reversedNumber / 10;
                    }
                    if ((int) (reversedNumber % 10) * 2 == 14) {
                        mult = (mult + 5);
                        reversedNumber = reversedNumber / 10;
                    }
                    if ((int) (reversedNumber % 10) * 2 == 16) {
                        mult = (mult + 7);
                        reversedNumber = reversedNumber / 10;
                    }
                    if ((int) (reversedNumber % 10) * 2 == 18) {
                        mult = (mult + 9);
                        reversedNumber = reversedNumber / 10;
                    }
                    
                }else{
                    mult = (mult + ((int) (reversedNumber % 10)) * 2);
                    reversedNumber = reversedNumber / 10;
                }
                
            } else {
                reversedNumber = reversedNumber / 10;
            }
        }

        if ((sum+mult) % 10 == 0) {
            System.out.println("Yes");
            
        }else{
            System.out.println("No");
        }
        

        
    }
}

