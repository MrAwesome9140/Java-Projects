/*
ID: aaroh.sh
LANG: JAVA
TASK: wormhole
*/

import java.util.*;
import java.io.*;

public class wormhole {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("wormhole.in")));
        int N = Integer.parseInt(br.readLine());
        Coords[] coords = new Coords[N];

        for(int i = 0; i<N; i++){
            String[] nums = br.readLine().split(" ");
            coords[i] = new Coords(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }

        Arrays.sort(coords, new Comparator<Coords>() {
            @Override
            public int compare(Coords o1, Coords o2) {
                return o1.y-o2.y==0?o1.x-o2.x:o1.y-o2.y;
            }
        });

        int currIndex = 0;
        int wormholes = 0;
        HashMap<Coords, Coords> pairs = new HashMap<>();
        while(currIndex<coords.length){
            Coords curr = coords[currIndex];
            int tempInd = currIndex+1;
            int sameLine = 0;
            int together = 0;
            while(tempInd<coords.length && curr.y==coords[tempInd].y){
                if(pairs.containsKey(coords[currIndex])){

                }
                else {
                    sameLine++;
                }
                tempInd++;
            }
            wormholes += (sameLine*(sameLine-1))/2;
            currIndex = tempInd;
        }

    }

}

class Coords{
    int x;
    int y;

    public Coords(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return (int)(0.5*(x+y)*(x+y+1)+(x*y));
    }
}
