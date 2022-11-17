import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class training {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner io = new Scanner(new File("training.dat"));
        int c = io.nextInt();
        for(int i = 0; i < c; i++){
            int l = io.nextInt();
            app arr[] = new app[l];
            for(int j = 0; j < l; j++){
                arr[j] = new app(io.nextInt(), io.nextInt());
            }
            Arrays.sort(arr);
            int cnt = 0;
            int e = -1;
            for (int j = 0; j < l; j++) {
                int st = arr[j].s;
                int end = arr[j].e;
                if(st >= e){
                    cnt++;
                    e =end;
                }
            }
            System.out.println(cnt);

        }

    }
    static class app implements Comparable<app>{
        int s, e;
        public app(int a, int b){
            s =a ;
            e = b;
        }

        @Override
        public int compareTo(app b) {
            if(this.e < b.e)
                return -1;
            else if (this.e > b.e){
                return 1;
            }
            else{
                return this.s - b.s;
            }
        }
    }
}
