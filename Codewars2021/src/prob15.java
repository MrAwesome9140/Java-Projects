import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class prob15 {

    static ArrayList<Point> keep = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int numWord = Integer.parseInt(temp[0]);
        int size = Integer.parseInt(temp[1]);
        ArrayList<String> words = new ArrayList<>();
        int maxLength = -1;
        for(int i = 0; i<numWord; i++){
            words.add(sc.nextLine());
            maxLength = Math.max(maxLength, words.get(i).length());
        }
        int dim = size*2-1;
        char[][] puzzle = new char[dim][dim*2];
        for(int i = 0; i<dim; i++){
            String te = sc.nextLine();
            int curInd = 0;
            for(int k = 0; k<te.length(); k++){
                if(te.charAt(k)==' ')
                    curInd++;
                else{
                    puzzle[i][curInd] = te.charAt(k);
                    curInd+=2;
                }
            }
        }
        for(int i = 0; i<puzzle.length; i++){
            for(int j = 0; j<puzzle[i].length; j++){
                if(puzzle[i][j]!=' ') {

                }
            }
        }
    }


    static void check(char[][] puzzle, int maxLength, Point cur, ArrayList<String> words){
        StringBuffer temp = new StringBuffer();
        for(int i = cur.y; i<cur.y+maxLength && i<puzzle[0].length; i++){
            temp.append(puzzle[cur.x][i]);
            int index = words.indexOf(temp.toString());
        }
    }

}



