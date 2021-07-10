import java.util.*;
import java.io.*;
import java.lang.*;

public class meetings {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader(new File("meetings.in")));
        String[] splits = br.readLine().split(" ");

        int N = Integer.parseInt(splits[0]);
        int L = Integer.parseInt(splits[1]);

        List<int[]> info = new ArrayList<>();

        int totalWeight = 0;

        for(int i = 0; i<N; i++){
            String[] temp = br.readLine().split(" ");

            int[] temp2 = new int[4];

            int weight = Integer.parseInt(temp[0]);
            totalWeight+=weight;
            temp2[1] = weight;
            int position = Integer.parseInt(temp[1]);
            temp2[2] = position;
            int velocity = Integer.parseInt(temp[2]);
            temp2[3] = velocity;
            if(velocity>0){
                temp2[0] = L-position;
            }
            else{
                temp2[0] = position;
            }
            info.add(temp2);
        }

        Collections.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        LinkedList<int[]> tempInfo = new LinkedList<>(info);

        int T = 0;

        while(totalWeight>0){
            int[] curTemp = tempInfo.pollFirst();
            T = curTemp[0];
            totalWeight-=curTemp[1]*2;
        }

        Collections.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        LinkedList<Integer> positions = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i<N; i++){
            int[] temp = info.get(i);
            if (temp[3] == -1) {
                while(positions.size()>0 && positions.peekFirst()+T*2<temp[2])
                    positions.pollFirst();
                ans+=positions.size();
            } else positions.offer(temp[2]);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("meetings.out")));
        bw.write(String.valueOf(ans));
        bw.close();

    }

}
