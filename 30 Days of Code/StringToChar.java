// Task 
// Given a string, , of length  that is indexed from  to , print its even-indexed and odd-indexed characters as  space-separated strings on a single line (see the Sample below for more detail).

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        while(i>0){
            String w = scan.next();
            String s1="";
            String s2 = "";
            
            for (int j = 0; j < w.length(); ++j) {
                if (j % 2 == 0)
                    s1 += w.charAt(j);
                else
                    s2 += w.charAt(j);
            }
            System.out.println(s1 + " " + s2);
            i--;
        }
    }
}