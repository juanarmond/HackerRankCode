// You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
// For example, given the array  we perform the following steps:

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swap=0;
        int tmp;
        int j=1;
        for(int i=0; i<arr.length; i++){
            while(j<arr.length){
                if(arr[i]==i+1){
                    break;
                }
                if(arr[i]!=j){
                    tmp = arr[i];
                    System.out.println(i + " " +arr[i] + " " +arr[tmp-1]);
                    arr[i] = arr[tmp-1];
                    arr[tmp-1] = tmp;
                    swap++;
                }else{
                    j++;
                    System.out.println(i + " " + arr[i]);
                    break;
                }
            }
        }
        return swap;
    }