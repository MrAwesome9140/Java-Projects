import java.io.*;
import java.util.*;

public class moop {

    static int N;
    static ArrayList<int[]> incX = new ArrayList<>();
    static ArrayList<int[]> incY = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("moop.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter("moop.out"));

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            incX.add(temp);
            incY.add(temp);
        }

        incX.sort(Comparator.comparingInt(o -> o[0]));
        incY.sort(Comparator.comparingInt(o -> o[1]));


        for(int i = 0; i<incX.size()-1; i++){
            int[] part1 = incX.get(i);
            int yPos = incY.indexOf(part1);
            if(yPos>=incY.size()-1)
                continue;
            List<int[]> subXs = incX.subList(i+1, incX.size());
            subXs.retainAll(incY.subList(yPos+1, incY.size()));
            subXs.forEach(array -> {
                if(array[0]>part1[0] && array[1]>part1[1]) {
                    incX.remove(array);
                    incY.remove(array);
                }
            });
        }

        bw.write(incX.size()+"");
        bw.close();

    }

}
