


/* Declare second integer, double, and String variables. */
         int n = 4;
         double dou =4.0;
         String st ="HackerRank";

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        Scanner in = new Scanner(System.in);
        int integ=0;double doubl=0;String str = "";
        while(in.hasNext()){
            if(in.hasNextInt()){
                integ = in.nextInt();
            }
            if(in.hasNextDouble()){
                doubl = in.nextDouble();
            }else{
                 str = in.nextLine();
            }
        }
        /* Print the sum of both integer variables on a new line. */
        System.out.println(n+integ);
        /* Print the sum of the double variables on a new line. */
        System.out.println(dou+doubl);
        /* Concatenate and print the String variables on a new line; 
            the 's' variable above should be printed first. */
        System.out.println(st+" "+ str);
        scan.close();