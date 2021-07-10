import java.io.*;

public class breedflip {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("breedflip.in")));
        br.readLine();
        String A = br.readLine();
        String B = br.readLine();
        br.close();

        char[] letsA = A.toCharArray();
        char[] letsB = B.toCharArray();

        int steps = 0;

        int i = 0;
        while (i<letsB.length){
            int temp = 0;
            int counter = i;
            while(letsA[counter]!=letsB[counter]){
                counter++;
                temp++;
            }

            if(temp>0){
                steps++;
                i = counter;
            }
            else{
                i++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("breedflip.out")));
        bw.write(String.valueOf(steps));
        bw.close();

    }

}
