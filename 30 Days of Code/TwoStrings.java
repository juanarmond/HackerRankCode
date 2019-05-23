// Given two strings, determine if they share a common substring. A substring may be as small as one character.
// For example, the words "a", "and", "art" share the common substring . The words "be" and "cat" do not share a substring.
// Function Description
// Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on whether the strings share a common substring.
// twoStrings has the following parameter(s):
// s1, s2: two strings to analyze .

// Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        Hashtable<Character, Integer> c1 = new Hashtable<>();

        for (char c : s1.toCharArray()) {
            c1.put(c, c1.getOrDefault(c, 1));
        }

        for (char c : s2.toCharArray()) {
            if (c1.containsKey(c)) {
                return "YES";
            } else {
                c1.getOrDefault(c, 1);
            }
        }      
        return "NO";
    }