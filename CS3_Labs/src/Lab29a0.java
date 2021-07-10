// Lab29ast.java
// This is the student version of the Lab29a assignment.  Complete this file as is.


import java.io.*;
import java.util.*;


public class Lab29a0
{
    public static void main(String args[]) throws IOException
    {
        System.out.println("\nLab 29a \n");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter random starting seed  ===>>  ");
        int seed = Integer.parseInt(input.readLine());

        Maze maze = new Maze(seed);
        maze.displayMaze();
        maze.solveMaze();
        maze.displayMaze();
        maze.mazeSolution();
    }
}

class Coord  	// Coord is a class that stores a single maze location.
{
    private int rPos;
    private int cPos;
    public Coord (int r, int c) 		{ rPos = r; cPos = c; }
    public boolean isFree() 			{ return (rPos == 0 && cPos == 0); }
    public void setPos(int r, int c) 	{ rPos+= r; cPos+= c; }
    public int getrPos() 	                   { return  rPos;   }
    public int getcPos() 	             { return  cPos;   }
}

class Maze
{

    private char mat[][];			       // 2d character array that stores the maze display
    private Coord currentMove;		// object that stores current maze position
    private Stack visitStack;		// stack that stores location that have been visited




    public Maze(int seed)
    // constructor which generates the random maze, random starting location
    // and initializes Maze class values.  If the random value equals 0 the maze
    // store an 'X' otherwise it store an 'O' in the maze.
    {
        Random random = new Random(seed);
        int startRow, startCol;
        mat = new char[12][12];
        for (int r = 0; r < 12; r++)
            for (int c = 0; c < 12; c++)
            {
                if (r == 0 || c == 0 || r == 11 || c == 11)
                    mat[r][c] = 'X';
                else
                {
                    int rndInt = random.nextInt(2);
                    if (rndInt == 0)
                        mat[r][c] = 'X';
                    else
                        mat[r][c] = 'O';
                }
            }
        mat[0][0] = 'O';
        startRow = random.nextInt(12);
        startCol = 11;
        mat[startRow][startCol] = '.';
        visitStack = new Stack();
        currentMove = new Coord(startRow,startCol);
        visitStack.push(currentMove);
    }


    void displayMaze() throws IOException
    // displays the current maze configuration
    {
        System.out.println("\nRANDOM MAZE DISPLAY\n");
        for (int r = 0; r < 12; r++)
        {
            for (int c = 0; c < 12; c++)
                System.out.print(mat[r][c] + "  ");
            System.out.println();
        }
        System.out.println();
        pause();
    }


    public void solveMaze() throws IOException
    // This method solves the maze with private helper method <getMove>.
    // A loop is needed to repeat getting new moves until either a maze solution
    // is found or it is determined that there is no way out off the maze.
    {
        System.out.println("\n>>>>>   WORKING  ....  SOLVING MAZE   <<<<<\n");
        while(!currentMove.isFree()){ //While there is still a move available
            if(!getMove()){ //If there is no move available, backtrack one step
                if(visitStack.size()==1)
                    break;
                visitStack.pop();
                currentMove = (Coord) visitStack.peek();
            }
        }
    }


    public void mazeSolution()
    // Short method to display the result of the maze solution
    {
        if (currentMove.isFree())
            System.out.println("\nTHE MAZE HAS A SOLUTION.\n");
        else
            System.out.println("\nTHE MAZE HAS NO SOLUTION.\n");
    }


    private boolean inBounds(int r, int c)
    // This method determines if a coordinate position is inbounds or not
    {
        return r>=0 && r<12 && c>=0 && c<12;
    }


    private boolean getMove()
    // This method checks eight possible positions in a counter-clock wise manner
    // starting with the (-1,0) position.  If a position is found the method returns
    // true and the currentMove coordinates are altered to the new position
    {
        int[][] posMoves = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
        for(int i = 0; i<posMoves.length; i++){
            int tempX = currentMove.getrPos()+posMoves[i][0];
            int tempY = currentMove.getcPos()+posMoves[i][1];
            if(inBounds(tempX, tempY) && mat[tempX][tempY]=='O'){ //If this space is available, move there
                currentMove = new Coord(tempX, tempY);
                visitStack.push(currentMove);
                mat[tempX][tempY] = '.';
                return true;
            }
        }
        return false;
    }

    private void pause() throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String dummy;
        System.out.print("\nPress <Enter> to continue  ===>>  ");
        dummy = input.readLine();
    }

}
