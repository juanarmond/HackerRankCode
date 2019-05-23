// Check out the resources on the page's right side to learn more about hashing. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.
// Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine. He cannot use substrings or concatenation to create the words he needs.
// Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
// For example, the note is "Attack at dawn". The magazine contains only "attack at dawn". The magazine has all the right words, but there's a case mismatch. The answer is .

static void checkMagazine(String[] magazine, String[] note) {
        boolean equal = true;
        Hashtable<String, Integer> mag = new Hashtable<>();
        // Hashtable<String, Integer> not = new Hashtable<>();
        
        for (String w : magazine) {
            mag.put(w, mag.getOrDefault(w, 0) + 1);
        }
        
        for (String w : note) {
            if (mag.getOrDefault(w, 0) == 0){
                equal = false;
                break;
            }else{
                mag.put(w, mag.get(w) - 1);
            }
        }
        
        if(equal){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }