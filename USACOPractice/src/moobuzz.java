import java.io.*;

public class moobuzz {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("moobuzz.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("moobuzz.out")));

        long n = Long.parseLong(br.readLine());
        br.close();

        long number = n%8;
        long start = (n/8)*15;

        int counter = 0;
        long num = 0;
        for(long i = start; i<start+15; i++){
            if(!(i%3==0 || i%5==0)){
                counter++;
                num = i;
            }
            if(counter==number){
                break;
            }
        }

        if(number == 0){
            bw.write((start-1)+"");
            bw.close();
            return;
        }

        bw.write(num+"");
        bw.close();

    }

}
