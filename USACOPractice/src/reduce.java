import java.awt.*;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class reduce {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("reduce.out"));
        int n = Integer.parseInt(br.readLine());
        Point[] locs=  new Point[n];
        for(int i = 0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            locs[i] = new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }
        Point[] xSorted = locs.clone();
        Point[] ySorted = locs.clone();
        Arrays.sort(xSorted, Comparator.comparingInt(a -> a.x));
        Arrays.sort(ySorted, Comparator.comparingInt(a -> a.y));
        int minX = xSorted[0].x;
        int maxX = xSorted[xSorted.length-1].x;
        int minY = ySorted[0].y;
        int maxY = ySorted[ySorted.length-1].y;

        int length = maxY-minY;
        int height = maxX-minX;

        int areaMinX = (xSorted[1].x-xSorted[0].x)*length;

    }

}
