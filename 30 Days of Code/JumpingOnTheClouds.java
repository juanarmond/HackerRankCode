// Emma is playing a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or . She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. It is always possible to win the game.
// For each game, Emma will get an array of clouds numbered  if they are safe or  if they must be avoided. For example,  indexed from . The number on each cloud is its index in the list so she must avoid the clouds at indexes  and . She could follow the following two paths:  or . The first path takes jumps while the second takes .

// Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jump = -1;
        for(int i=0; i<c.length; i++, jump++){
            if(i<c.length-2 && c[i+2] == 0){
                i++;
            }
        }
        return jump;
    }