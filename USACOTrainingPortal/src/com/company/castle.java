/*
ID: aaroh.sh
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class castle {

    static int[][][] graph;
    static int[][] components;
    static HashMap<Integer, int[]> xyValues;
    static ArrayList<Integer> componentSizes;
    static int largestRoom;
    static int numRooms;
    static int modifiedLargestRoom;
    static int[] removedWall;
    static char wallDirect;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("castle.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("castle.out")));

        String[] strings = br.readLine().split(" ");

        int[] indexes = {0,3,0,0,2,0,0,0,1};
        //North 1st, South 2nd, East 3rd, West 4th
        xyValues = new HashMap<>();
        componentSizes = new ArrayList<>();

        xyValues.put(0, new int[]{-1, 0});
        xyValues.put(1, new int[]{1, 0});
        xyValues.put(2, new int[]{0, 1});
        xyValues.put(3, new int[]{0, -1});

        int[] vals = {8,4,2,1};

        int width = Integer.parseInt(strings[0]);
        int height = Integer.parseInt(strings[1]);

        components = new int[height+1][width+1];

        graph = new int[height+1][width+1][4];

        removedWall = new int[2];

        for(int h = 1; h<=height; h++){
            String[] t = br.readLine().split(" ");
            for(int w = 1; w<=width; w++){
                components[h][w] = -1;
                int cur = Integer.parseInt(t[w-1]);
                for(int i = 0; i<vals.length; i++){
                    if(cur>=vals[i]){
                        cur-=vals[i];
                        graph[h][w][indexes[vals[i]]] = 1;
                    }
                }
            }
        }

        findComponents(width, height);

        componentSizes.forEach((i) -> {
            numRooms++;
            largestRoom = Math.max(largestRoom, i);
        });

        findOptimalWall(width, height);

        bw.write(String.valueOf(numRooms));
        bw.newLine();
        bw.write(String.valueOf(largestRoom));
        bw.newLine();
        bw.write(String.valueOf(modifiedLargestRoom));
        bw.newLine();
        bw.write(String.valueOf(removedWall[0])+" "+String.valueOf(removedWall[1])+" "+String.valueOf(wallDirect));
        bw.newLine();
        bw.close();
    }

    static void findOptimalWall(int width, int height){
        for(int h = 1; h<=height; h++){
            for(int w = 1; w<=width; w++){
                for(int i = 0; i<graph[h][w].length; i+=2){
                    if(((i==0 && h>1) || (i==2 && w<width)) && graph[h][w][i]==1){
                        int tempSum = 0;
                        if(i==0){
                            if(components[h][w]!=components[h-1][w])
                                tempSum = componentSizes.get(components[h][w]-1) + componentSizes.get(components[h-1][w]-1);
                            else
                                tempSum = componentSizes.get(components[h][w]-1);
                            if(tempSum>modifiedLargestRoom){
                                modifiedLargestRoom = tempSum;
                                removedWall[0] = h;
                                removedWall[1] = w;
                                wallDirect = 'N';
                            }
                        }else{
                            if(components[h][w]!=components[h][w+1])
                                tempSum = componentSizes.get(components[h][w]-1) + componentSizes.get(components[h][w+1]-1);
                            else
                                tempSum = componentSizes.get(components[h][w]-1);
                            if(tempSum>modifiedLargestRoom){
                                modifiedLargestRoom = tempSum;
                                removedWall[0] = h;
                                removedWall[1] = w;
                                wallDirect = 'E';
                            }
                        }
                        if(tempSum == modifiedLargestRoom){
                            if(w<removedWall[1] || (w==removedWall[1] && h>removedWall[0]) || (w==removedWall[1] && h==removedWall[0] && i==0 && wallDirect=='E')){
                                modifiedLargestRoom = tempSum;
                                removedWall[0] = h;
                                removedWall[1] = w;
                                if(i==0)
                                    wallDirect = 'N';
                                else
                                    wallDirect = 'E';
                            }
                        }
                    }
                }
            }
        }
    }

    static void findComponents(int width, int height){
        int numComponent = 0;
        for(int h = 1; h<=height; h++){
            for(int w = 1; w<=width; w++){
                if(components[h][w]==-1){
                    componentSizes.add(1);
                    numComponent++;
                    components[h][w] = -2;
                    floodFill(numComponent, height, width);
                }
            }
        }
    }

    static void floodFill(int componentNum, int height, int width){
        int numVisited;
        do{
            numVisited = 0;
            for(int h = 1; h<=height; h++){
                for(int w = 1; w<=width; w++){
                    if(components[h][w]==-2){
                        numVisited++;
                        neighbors(h, w, componentNum);
                        components[h][w] = componentNum;
                    }
                }
            }
        }while(numVisited!=0);
    }

    static void neighbors(int h, int w, int componentNum){
        for(int i = 0; i<graph[h][w].length; i++){
            if(graph[h][w][i]!=1 && components[h+xyValues.get(i)[0]][w+xyValues.get(i)[1]]==-1){
                componentSizes.set(componentNum-1, componentSizes.get(componentNum-1)+1);
                components[h+xyValues.get(i)[0]][w+xyValues.get(i)[1]] = -2;
            }
        }
    }

}
