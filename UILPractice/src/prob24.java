import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class prob24 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        String s;
        int temp = 0;
        while((s=br.readLine())!=null){
            if(!s.contains("-")){
                if(temp==0){

                }
            }
            else{
                temp++;
            }
        }

    }

}

class Coord{
    int x;
    int y;
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}
