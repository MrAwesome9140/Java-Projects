import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class A_Three {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("a_three.dat")));

        String temps;
        while((temps = br.readLine())!=null) {
            String[] temp = temps.split("\\s++");

            int S = Integer.parseInt(temp[0]);
            int[] board = new int[S+1];

            for (int i = 2; i < temp.length; i++) {
                board[Integer.parseInt(temp[i])] = 1;
            }

            int[] answers = new int[5];
            for(int i = 1; i<=5; i++){
                answers[i-1] = numPossible(board, i);
            }

            for(int i = 0; i<answers.length; i++) {
                if(i<answers.length-1)
                    System.out.print(answers[i]+" ");
                else
                    System.out.println(answers[i]);
            }
        }
    }

    static int numPossible(int[] board, int spacesLeft){
        int possibles = 0;
        for(int i = 1; i<board.length; i++){
            if(board[i]==1){
                int temp = i-1;
                int moved = 0;
                while(temp>=1 && board[temp]!=1 && moved<spacesLeft){
                    temp--;
                    moved++;
                }
                if(moved==spacesLeft)
                    possibles++;
            }
        }
        return possibles;
    }

}
