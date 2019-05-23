// Objective 
// Today we're discussing scope. Check out the Tutorial tab for learning materials and an instructional video!
// The absolute difference between two integers,  and , is written as . The maximum absolute difference between two integers in a set of positive integers, , is the largest absolute difference between any two integers in .
// The Difference class is started for you in the editor. It has a private integer array () for storing  non-negative integers, and a public integer () for storing the maximum absolute difference.
// Task 
// Complete the Difference class by writing the following:
// A class constructor that takes an array of integers as a parameter and saves it to the  instance variable.
// A computeDifference method that finds the maximum absolute difference between any  numbers in  and stores it in the  instance variable.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
    private int[] elements;
    public int maximumDifference;

    // A class constructor that takes an array of integers as a parameter and saves it      to the  instance variable.
    // Add your code here
    public Difference(int[] elements){
        this.elements = elements;
    }

    // A computeDifference method that finds the maximum absolute difference between        any  numbers in  and stores it in the  instance variable.

    public int computeDifference(){
        int min = elements[0];
        int max = elements[0];

        for(int n: elements){
            if(n < min){
                min = n;
            } 
            if (n > max) {
                max = n;
            }
        }

        maximumDifference = max - min;
        return maximumDifference;
    }



} // End of Difference class