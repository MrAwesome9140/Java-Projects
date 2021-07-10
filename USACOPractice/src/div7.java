import java.io.*;

public class div7 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("div7.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("div7.out")));

        int n = Integer.parseInt(br.readLine());
        long[] ids = new long[n];

        for(int i = 0; i<n; i++){
            ids[i] = Long.parseLong(br.readLine());
        }



    }

}
