// Objective 
// Today, we're delving into Inheritance. Check out the attached tutorial for learning materials and an instructional video!
// Task 
// You are given two classes, Person and Student, where Person is the base class and Student is the derived class. Completed code for Person and a declaration for Student are provided for you in the editor. Observe that Student inherits all the properties of Person.
// Complete the Student class by writing the following:
// A Student class constructor, which has  parameters:
// A string, .
// A string, .
// An integer, .
// An integer array (or vector) of test scores, .
// A char calculate() method that calculates a Student object's average and returns the grade character representative of their calculated average:


class Student extends Person{
    private int[] testScores;
    
    /*  
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    // Write your constructor here
    Student(String fName, String lName, int id, int[] testScores){
        super(fName, lName, id);
        this.testScores = testScores;
    }

    /*  
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    // Write your method here

    public char calculate(){
        // System.out.println("Name: " + lName, ", " + fName);
        // System.out.println("ID: " + id); 

        int sum = 0;
        char grade;
        for(int i=0; i< testScores.length; i++){
            sum += testScores[i];
        }
        int avg = sum/testScores.length;
        
        if (avg <= 100 && avg >= 90)
             grade = 'O';
        else if (avg < 90 && avg >= 80)
            grade = 'E';
        else if (avg < 80 && avg >= 70)
            grade = 'A';
        else if (avg < 70 && avg >= 55)
            grade = 'P';
        else if (avg < 55 && avg >= 40)
            grade = 'D';
        else
            grade = 'T';

        return grade;

        // System.out.println("Grade: " + sum/scores.length);

    }
}