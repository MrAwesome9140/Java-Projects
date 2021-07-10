import java.io.*;
import java.util.*;

public class balancing {

    static int[][] coords;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("balancing.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("balancing.out")));

        int N = Integer.parseInt(br.readLine());
        coords = new int[N+1][2];

        for(int i = 0; i<N; i++){
            String[] temp = br.readLine().split("\\s++");
            coords[i][0] = Integer.parseInt(temp[0]);
            coords[i][1] = Integer.parseInt(temp[1]);
        }

        double medianX;
        double medianY;

        if(coords.length%2==0){
            medianX = (coords[coords.length/2][0]+coords[coords.length/2+1][0])/2.0;
            medianY = (coords[coords.length/2][1]+coords[coords.length/2+1][1])/2.0;
        }
        else{
            medianX = coords[coords.length/2][0];
            medianY = coords[coords.length/2][1];
        }

        double finalX = Math.round(medianX/2)*2;
        double finalY = Math.round(medianY/2)*2;

        double finalX2 = finalX-2;
        double finalY2 = finalY-2;

        double finalX3 = finalX+2;
        double finalY3 = finalY+2;

        int M1 = Integer.MIN_VALUE;

        M1 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]<finalX && x[1]<finalY).count(), M1);
        M1 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]>finalX && x[1]<finalY).count(), M1);
        M1 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]>finalX && x[1]>finalY).count(), M1);
        M1 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]<finalX && x[1]>finalY).count(), M1);

        int M2 = Integer.MIN_VALUE;

        M2 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]<finalX2 && x[1]<finalY2).count(), M2);
        System.out.println((int)Arrays.stream(coords).filter(x -> x[0]<finalX2 && x[1]<finalY2).count());
        M2 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]>finalX2 && x[1]<finalY2).count(), M2);
        System.out.println((int)Arrays.stream(coords).filter(x -> x[0]>finalX2 && x[1]<finalY2).count());
        M2 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]>finalX2 && x[1]>finalY2).count(), M2);
        System.out.println((int)Arrays.stream(coords).filter(x -> x[0]>finalX2 && x[1]>finalY2).count());
        M2 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]<finalX2 && x[1]>finalY2).count(), M2);
        System.out.println((int)Arrays.stream(coords).filter(x -> x[0]<finalX2 && x[1]>finalY2).count());

        int M3 = Integer.MIN_VALUE;

        M3 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]<finalX3 && x[1]<finalY3).count(), M3);
        M3 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]>finalX3 && x[1]<finalY3).count(), M3);
        M3 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]>finalX3 && x[1]>finalY3).count(), M3);
        M3 = Math.max((int)Arrays.stream(coords).filter(x -> x[0]<finalX3 && x[1]>finalY3).count(), M3);

        System.out.println(Math.min(M1, Math.min(M2, M3)));


    }

}
