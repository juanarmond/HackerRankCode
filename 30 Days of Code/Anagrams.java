// Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
// For example , the list of all anagrammatic pairs is  at positions  respectively.
// Function Description
// Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .
// sherlockAndAnagrams has the following parameter(s):
// s: a string .

// Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int start = 0 ;
        int end = start + 1; 
        int strLength = s.length(); 
        int counter = 0;

        HashMap<String,Integer> str = new HashMap<>();
        while(start < strLength){
            char[] c = s.substring(start,end).toCharArray();
            Arrays.sort(c);
            String temp = String.valueOf(c);

            if(!str.containsKey(temp))
                str.put(temp, 1);
            else{
                int freq = str.get(temp);
                counter += freq;
                str.put(temp, freq + 1);
            }
            end++;
            if(end > strLength){
                start++;
                end = start + 1;
            }
    }
    return counter;
}