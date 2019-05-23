// It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. Initial positions increment by  from  at the front of the line to  at the back.
// Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe at most two others. For example, if  and  bribes , the queue will look like this: .
// Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!


// Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int count = 0;
        int expectedFirst = 1;
        int expectedSecond = 2;
        int expectedThird = 3;
        boolean flag = true;
        
        for(int i=0; i<q.length; i++){
            if (q[i] == expectedFirst) {
                expectedFirst = expectedSecond;
                expectedSecond = expectedThird;
                expectedThird++;
            } else if (q[i] == expectedSecond) {
                count++;
                expectedSecond = expectedThird;
                expectedThird++;
            } else if (q[i] == expectedThird) {
                count += 2;
                expectedThird++;
            } else {
                flag = false;
                System.out.println("Too chaotic");
                break;
            }
        }
        if(flag){
            System.out.println(count);
        }
    }