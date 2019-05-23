// Objective 
// Today, we're learning and practicing an algorithmic concept called Recursion. Check out the Tutorial tab for learning materials and an instructional video!
// Recursive Method for Calculating Factorial 

// Task 
// Write a factorial function that takes a positive integer,  as a parameter and prints the result of  ( factorial).
// Note: If you fail to use recursion or fail to name your recursive function factorial or Factorial, you will get a score of .

// Complete the factorial function below.

static int factorial(int n) {
    if (n == 0) {
        return 1;
    }
    return n * factorial(n - 1);

}