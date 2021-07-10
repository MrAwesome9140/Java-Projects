package com.company;

import java.util.*;

public class KnightsLab {

    static int[][] access = new int[9][9];
    static int[][] searched = new int[9][9];
    static int[] colDifs = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
    static int[] rowDifs = new int[]{2, 2, 1, -1, -2, -2, -1, 1};
    //    static HashMap<Integer, List<int[]>> visited = new HashMap<>();
    static int moves = 0;
//    static ArrayList<int[]> added = new ArrayList<>();

    public static void main(String[] args){

        int a = 40;



        if(a<30)
            System.out.println("a is less than 30");
        else if(a<40)
            System.out.println("a is less than 40");
        else
            System.out.println("a is greater than or equal to 40");


//        for(int i = 1; i<=8; i++){
//            for(int j = 1; j<=8; j++){
//                visited.put((i-1)*8+j, new ArrayList<int[]>());
//            }
//        }

        for(int i = 0; i<searched.length; i++){
            Arrays.fill(searched[i], -1);
        }

        generateAccess();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row start  ===>>  ");
        int row = sc.nextInt();

        System.out.print("Enter col start  ===>>  ");
        int col = sc.nextInt();
        System.out.println();

//        int row = 1;
//        int col = 3;

        solve(row, col);

        for(int i = 1; i<searched.length; i++){
            for(int j = 1; j<searched.length; j++){
                System.out.print(String.format("%02d", searched[i][j])+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("The knight made " + moves + " moves");

    }

    static void solve(int row, int col){
//        added.add(new int[]{row,col});
        searched[row][col] = moves++;
        int[] temp;
        while((temp = nextMove(row, col))[0] != -1){
//            access[row][col]--;
            row = temp[0];
            col = temp[1];
//            added.add(new int[]{row, col});
            searched[row][col] = moves++;
        }
//        if(moves != 64){
//            int[] alt = backtrack();
//            solve(alt[0], alt[1]);
//        }
    }

//    static int[] backtrack(){
//        moves--;
//        int[] last = added.remove(added.size()-1);
//        int[] newStart = added.get(added.size()-1);
//        int[] alternateMove = nextMove(newStart[0], newStart[1]);
//        searched[last[0]][last[1]] = -1;
//        if(alternateMove[0] == -1){
//            return backtrack();
//        }
//        return alternateMove;
//    }

    static int[] nextMove(int row, int col){
        int[] newSpace = new int[2];
        Arrays.fill(newSpace, -1);
        int minAccess = Integer.MAX_VALUE;
        for(int i = 0; i<8; i++){
            if(row+rowDifs[i]>=1 && col+colDifs[i]>=1 && row+rowDifs[i]<=8 && col+colDifs[i]<=8) {
                int tempAccess = access[row + rowDifs[i]][col + colDifs[i]];
                if (tempAccess < minAccess && searched[row + rowDifs[i]][col + colDifs[i]] == -1) {
//                    access[row+rowDifs[i]][col+colDifs[i]]--;
                    minAccess = tempAccess;
                    newSpace[0] = row + rowDifs[i];
                    newSpace[1] = col + colDifs[i];
                }
            }
        }
        return newSpace;
    }

    static void generateAccess(){
        for(int i = 1; i<9; i++){
            for(int j = 1; j<9; j++){
                if((i==1 && j==1) || (i==8 && j==8) || (i==1 && j==8) || (i==8 && j==1)){
                    access[i][j] = 2;
                }
                else if(((i==1 || i==8) && (j==2 || j==7)) || ((j==1 || j==8) && (i==2 || i==7))){
                    access[i][j] = 3;
                }
                else if((i==1 || i==8) || (j==1 || j==8) || (i==2 && (j==2 || j==7)) || (i==7 && (j==2 || j==7))){
                    access[i][j] = 4;
                }
                else if(i==2 || i==7 || j==2 || j==7){
                    access[i][j] = 6;
                }
                else{
                    access[i][j] = 8;
                }
            }
        }
    }

}
