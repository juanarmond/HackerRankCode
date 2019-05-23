/* John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
*/

// Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        int j = 1;
        for(int i=0; i<n; i++){
            while(j<ar.length){
                if(ar[i] == 0){
                    j++;
                    break;
                }
                if(ar[i] == ar[j]){
                    pairs++;
                    System.out.println(ar[i]+ " " + i + " " + ar[j]+ " " + j);
                    ar[j] = 0;
                    j++;
                    break;
                }
                j++;
                // System.out.println(ar[i] + " " + ar[j]);
            }
            j = i+2;
        }
        return pairs;

    }