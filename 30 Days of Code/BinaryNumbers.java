// Objective 
// Today, we're working with binary numbers. Check out the Tutorial tab for learning materials and an instructional video!
// Task 
// Given a base- integer, , convert it to binary (base-). Then find and print the base- integer denoting the maximum number of consecutive 's in 's binary representation.

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        
        String bin = Integer.toBinaryString(n);
        int count = 1;
        int ones = 0;
        for(char c : bin.toCharArray()){
            if(c == '1'){
                ones++;
                if (ones > count) {
                    count = ones;
                }
                //System.out.println("1" + " " +ones);
            }else{
                ones = 0;
                //System.out.println("0" + " " +ones);
            }         
        }
        System.out.println(count);
    }
}
