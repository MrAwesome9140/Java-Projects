/*
ID: aaroh.sh
LANG: JAVA
TASK: milk3
*/

import java.util.*;
import java.io.*;

public class milk3 {

    static boolean[][] searched;
    static boolean[] answers;
    static int a,b,c;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader(new File("milk3.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("milk3.out")));

        String[] strings = br.readLine().split(" ");

        a = Integer.parseInt(strings[0]);
        b = Integer.parseInt(strings[1]);
        c = Integer.parseInt(strings[2]);

        searched = new boolean[21][21];
        answers = new boolean[21];

        solve(0,0,c);

        for(int i = 0; i<c; i++){
            if(answers[i])
                bw.write(String.valueOf(i)+" ");
        }
        bw.write(String.valueOf(c));
        bw.newLine();
        bw.close();

    }

    static void solve(int A, int B, int C){
        if (searched[A][B])
            return;
        searched[A][B] = true;

        if(A == 0)
            answers[C] = true;

        if(A>0 && B<b)
            solve(Math.max(0,A+B-b),Math.min(b,A+B),C);
        if(A>0 && C<c)
            solve(Math.max(0,A+C-c),B,Math.min(c,A+C));
        if(B>0 && A<a)
            solve(Math.min(a,A+B),Math.max(0,B+A-a),C);
        if(B>0 && C<c)
            solve(A,Math.max(0,B+C-c),Math.min(c,B+C));
        if(C>0 && A<a)
            solve(Math.min(a,A+C),B,Math.max(0,C+A-a));
        if(C>0 && B<b)
            solve(A,Math.min(b,B+C),Math.max(0,C+B-b));
    }

}

class Prot{

    int A;
    int B;
    int C;

    public Prot(int A, int B, int C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public int hashCode() {
        int temp = (int) (0.5*(A+B)*(A+B+1)+B);
        return (int)(0.5*(temp+C)*(temp+C+1)+C);
    }
}
