// Check out the resources on the page's right side to learn more about arrays. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.
// A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .
// Given an array  of  integers and a number, , perform  left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.


   // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] combine = new int[a.length];
        
        System.arraycopy(a, d, combine, 0, a.length - d);
        System.arraycopy(a, 0, combine, a.length - d, d);

        System.out.println(Arrays.toString(combine));
        return combine;

        // int[] c = Arrays.copyOfRange(a, 0, d);
        // int[] b = Arrays.copyOfRange(a, d, a.length);
        // int[] combine = new int[a.length];
        
        // System.arraycopy(b, 0, combine, 0, b.length);
        // System.arraycopy(c, 0, combine, b.length, c.length);

        // System.out.println(Arrays.toString(combine));
        return combine;
    }