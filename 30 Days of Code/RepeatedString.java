// Lilah has a string, , of lowercase English letters that she repeated infinitely many times.
// Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.
// For example, if the string  and , the substring we consider is , the first  characters of her infinite string. There are  occurrences of a in the substring.

// Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long count = 0;
        long rest = 0;
        if(s.equals("a")){
            System.out.println(s);
            return n;
        }
        for(char c: s.toCharArray()){
            if(c == 'a'){
                count++;
            }
        }
        long t = (int) n/s.length();
        long res = (n%s.length());

        int i=0;
        while(i<res){
            if(s.charAt(i) == 'a'){
                rest++;
            }
            i++;
        }

        long total = (count * t + rest);
        // System.out.println(str.length());
        // System.out.println(str + " " + count);
        return total;
    }


    String s = in.next();
    long n = in.nextLong();
    long count =0;
    for(char c : s.toCharArray())
        if(c == 'a')
        count++;

     long factor = (n/s.length());
     long rem = (n%s.length());
     count =  factor*count  ;
    for(int i=0;i<rem;i++)
        if(s.charAt(i)=='a')
                count++;        
    System.out.println(count);
