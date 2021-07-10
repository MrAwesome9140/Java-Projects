import java.io.*;
import java.util.ArrayList;

public class sleepy {

    static int[] order;
    static int numSteps = 0;
    static ArrayList<Integer> distMoved = new ArrayList<>();
    static int[] curPos;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("sleepy.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("sleepy.out")));

        int n = Integer.parseInt(br.readLine());
        order = new int[n+1];
        curPos = new int[n+1];
        String[] temp = br.readLine().split(" ");
        br.close();
        for(int i = 0; i<temp.length; i++){
            int tempNum = Integer.parseInt(temp[i]);
            order[i+1] = tempNum;
            curPos[tempNum] = i+1;
        }

        solve(n);

        bw.write(String.valueOf(numSteps));
        bw.newLine();
        for(int i = 0; i<distMoved.size()-1; i++){
            bw.write(distMoved.get(i) +" ");
        }
        bw.write(distMoved.get(distMoved.size()-1)+"");
        bw.close();

    }

    static void solve(int n){
        int curLargest = n;
        while(!solved()){
            numSteps++;
            int cur = order[1];
            if(cur == curLargest){
                distMoved.add(curLargest-1);
                swapAndMove(curLargest);
                curLargest--;
                continue;
            }
            int curLargePos = curPos[curLargest];
            int i;
            for(i = cur+1; i<curLargest; i++){
                if(curPos[i]>curLargePos)
                    break;
            }
            if(i == curLargest){
                distMoved.add(curLargePos-1);
                swapAndMove(curLargePos);
            }
            else{
                distMoved.add(curPos[i]-1);
                swapAndMove(curPos[i]);
            }
//            int temp = 2;
//            while(temp <= n && order[temp]!=curLargest)
//                temp++;
//            if(temp > n){
//                swapAndMove(n);
//                distMoved.add(n-1);
//                continue;
//            }
//            temp++;
//            while(temp <= n && order[temp] <= cur)
//                temp++;
//            if(temp > n){
//                swapAndMove(n);
//                distMoved.add(n-1);
//                continue;
//            }
//            swapAndMove(temp-1);
//            distMoved.add(temp-2);
        }
    }

    static boolean solved(){
        for(int i = 1; i<order.length; i++){
            if(order[i] != i)
                return false;
        }
        return true;
    }

    static void swapAndMove(int newIndex){
        int temp = order[1];
        for(int i = 2; i<=newIndex; i++) {
            curPos[order[i]] = i-1;
            order[i-1] = order[i];
        }
        curPos[temp] = newIndex;
        order[newIndex] = temp;
    }

}
