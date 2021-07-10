import java.util.*;
import java.io.*;

public class perimeter {

    static int[] temp = {0,1,0,-1,0};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("perimeter.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("perimeter.out")));

        int N = Integer.parseInt(br.readLine());

        char[][] thing = new char[N][N];

        for(int i = 0; i<N; i++){
            char[] t = br.readLine().toCharArray();
            thing[i] = t;
        }

        ArrayList<ArrayList<Coord>> blobs = new ArrayList<>();
        Graph g = new Graph();

        for(int i = 0; i<thing.length; i++){
            for(int j = 0; j<thing[i].length; j++){
                if(thing[i][j]=='#') {
                    Coord c = new Coord(i,j);
                    ArrayList<Coord> wow = new ArrayList<>();
                    for (int t = 1; t < temp.length; t++) {
                        if (i + temp[t] >= 0 && i + temp[t] < thing.length && j + temp[t - 1] >= 0 && j + temp[t - 1] < thing[i].length && thing[i + temp[t]][j + temp[t - 1]] == '#') {
                            wow.add(new Coord(i+temp[t], j+temp[t-1]));
                        }
                    }
                    int index = g.containsCoord(c);
                    if(index<0){
                        c.adjacentCoords = wow;
                        g.coords.add(c);
                    }
                    else{
                        g.coords.get(index).adjacentCoords.addAll(wow);
                    }
                }
            }
        }

    }


}

class Graph{

    ArrayList<Coord> coords = new ArrayList<>();

    public Graph(){

    }

    public int containsCoord(Coord coord){
        for(int i = 0; i<coords.size(); i++){
            if(coord.compareTo(coords.get(i))==0)
                return i;
        }
        return -1;
    }

}

class Coord{

    int x;
    int y;
    ArrayList<Coord> adjacentCoords = new ArrayList<>();

    public Coord(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int compareTo(Coord coord){
        return coord.x-x==0?coord.y-y:coord.x-x;
    }
}
