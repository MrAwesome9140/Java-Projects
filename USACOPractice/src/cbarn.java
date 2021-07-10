import java.io.*;
import java.util.*;
public class cbarn {

    static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("cbarn.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("cbarn.out")));

        int N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] copy = nums.clone();
        int[] distJoined = new int[N];
        Arrays.fill(distJoined, -1);
        int[][] finDists = new int[N][Arrays.stream(nums).max().getAsInt()];
        for(int i = 0; i<N; i++){
            Arrays.fill(finDists[i], -1);
        }
        int curIndex = 0;
        int curCows = 0;
        int distanceWalked = 0;
        while(!Complete()){
            if(curIndex==N)
                curIndex = 0;

            if(!alreadyChecked(distJoined, curIndex) && (curCows != 0 || nums[curIndex] != 0)) {
                if(nums[curIndex] != 0)
                    distJoined[curIndex] = distanceWalked;

                int min = indexOfMax(distJoined);
                int tempInd = 0;
                while (finDists[min][tempInd] != -1) {
                    tempInd++;
                }
                finDists[min][tempInd] = distanceWalked - distJoined[min];
                if(tempInd == copy[min]-1)
                    distJoined[min] = -1;
                curCows += nums[curIndex] - 1;
                nums[curIndex] = 1;
            }
            distanceWalked++;
            curIndex++;
        }

        int sum = 0;
        for(int i = 0; i<finDists.length; i++){
            for(int j = 0; j<nums[i]; j++){
                if(finDists[i][j] != -1) {
                    sum += Math.pow(finDists[i][j], 2);
                }
            }
        }

        System.out.println(sum);
    }

    private static boolean alreadyChecked(int[] distJoined, int curIndex){
        if(nums[curIndex]==0)
            return false;
        for(int i = 0; i<nums[curIndex]; i++){
            if(distJoined[i]==-1)
                return false;
        }
        return true;
    }

    private static int indexOfMax(int[] distJoined){
        int index = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i<distJoined.length; i++){
            if(distJoined[i]>=0 && distJoined[i]<minValue){
                minValue = distJoined[i];
                index = i;
            }
        }
        return index;
    }

    private static boolean Complete(){
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 1)
                return false;
        }
        return true;
    }

}
