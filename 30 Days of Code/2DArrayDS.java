// There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.
// For example, given the 2D array:



// Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int sum = Integer.MIN_VALUE;;
        int tmp = Integer.MIN_VALUE;;

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                tmp = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]
                        +arr[i+2][j+1]+arr[i+2][j+2];
                //System.out.println(tmp);
                if(tmp > sum){
                    sum = tmp;
                }
            }
        }
        return sum;
    }