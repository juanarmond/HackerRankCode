// Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.
// For example, the length of your array of zeros . Your list of queries is as follows:

// Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] a = new long[n];
        int row = queries.length;
        for(int r=0; r<row; r++){
            int start = queries[r][0]-1;
            int end = queries[r][1]-1;
            int num = queries[r][2];
            a[start] += num;
            if (end+1 < n) {
                a[end+1] -= num;  
            }
        }
        long max=Long.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
            a[i] += a[i-1];
            max = Math.max(a[i], max);
        }
        return max;
    }