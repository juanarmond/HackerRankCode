// Objective 
// In this challenge, we're getting started with conditional statements. Check out the Tutorial tab for learning materials and an instructional video!

private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if(N%2 == 1){
            System.out.println("Weird");
        }else{
            if(N<=5){
                System.out.println("Not Weird");
            }else if(N>=6 && N<=20){
                System.out.println("Weird");
            }else{
                System.out.println("Not Weird");
            }
        }
        

        scanner.close();
    }