package vicdominguez.coderbyte.solutions;

import java.util.Scanner;

public class eightQueens implements Runnable
{
    static class coordinates
    {
        private int x, y;
        coordinates()
        {
            this.x = 0;
            this.y = 0;
        }
        coordinates(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public void setX(int x)
        {
            this.x = x;
        }
        public void setY(int y)
        {
            this.y = y;
        }
        public int getX()
        {
            return x;
        }
        public int getY()
        {
            return y;
        }

    }

    private static int BOARD_SIZE = 8;
    private static int ELEMENTS_TO_READ = 8;
    private static int ELEMENTS_SIZE = 5;

    private static Character[][] board;
    private static coordinates[] queensBuffer;
    private static coordinates coordinatesToReturn;
    private static Boolean endFound;

    private static void initBoard()
    {
        for(int row = 0; row < BOARD_SIZE; row++)
        {
            for(int column = 0; column < BOARD_SIZE; column++)
            {
                board[row][column] = '-';
            }
        }
    }
    private static void readInputAndConversion(String[] queens)
    {
        for(int index = 0; index < ELEMENTS_TO_READ; index++)
        {
            for(int internalIndex = 0; internalIndex < ELEMENTS_SIZE; internalIndex++)
            {
                if(internalIndex == 1)
                    queensBuffer[index].setX(BOARD_SIZE -
                            (Character.getNumericValue(queens[index].toCharArray()[internalIndex])));
                if(internalIndex == 3)
                    queensBuffer[index].setY(
                            (Character.getNumericValue(queens[index].toCharArray()[internalIndex])) - 1);
            }
        }
    }

    private static void evaluate()
    {
        for(int queensIndex = 0; queensIndex < BOARD_SIZE && !endFound; queensIndex++)
        {
            coordinates temp = queensBuffer[queensIndex];

            if(temp.getX() != 0 && temp.getY()!= BOARD_SIZE - 1 && !endFound) //upper right angle (diagonal)
            {
                for(int xIndex = temp.getX() - 1, yIndex = temp.getY() + 1; xIndex >= 0 && yIndex < BOARD_SIZE; xIndex-- , yIndex++)
                {
                    setValues(temp,xIndex,yIndex);
                }
            }
            if(temp.getX() != 0 && !endFound) // upper upright
            {
                for(int xIndex = temp.getX() - 1, yIndex = temp.getY(); xIndex >= 0; xIndex--)
                {
                    setValues(temp,xIndex,yIndex);
                }
            }

            if (temp.getX() != 0 && temp.getY() != 0 && !endFound) // upper left angle
            {
                for (int xIndex = temp.getX() - 1, yIndex = temp.getY() - 1; xIndex >= 0 && yIndex >= 0; xIndex-- , yIndex--)// upper left angle
                {
                    setValues(temp,xIndex,yIndex);
                }
            }

            if(temp.getY() != 0 && !endFound) //left horizontal
            {
                for(int xIndex = temp.getX(), yIndex = temp.getY() - 1; yIndex >= 0; yIndex--)
                {
                    setValues(temp,xIndex,yIndex);
                }
            }
            if(temp.getX() != BOARD_SIZE - 1 && temp.getY()!= 0 && !endFound) //lower left angle (diagonal)
            {
                for(int xIndex = temp.getX() + 1, yIndex = temp.getY() - 1; xIndex < BOARD_SIZE && yIndex >= 0; xIndex++ , yIndex--)
                {
                    setValues(temp,xIndex,yIndex);
                }
            }
            if(temp.getX() != BOARD_SIZE - 1 && !endFound)  //lower upright
            {
                for(int xIndex = temp.getX() +1, yIndex = temp.getY(); xIndex < BOARD_SIZE; xIndex++)
                {
                    setValues(temp,xIndex,yIndex);
                }
            }

            if(temp.getX() != BOARD_SIZE - 1 && temp.getY()!= BOARD_SIZE -1 && !endFound) //lower right angle (diagonal)
            {
                for(int xIndex = temp.getX() + 1, yIndex = temp.getY() + 1; xIndex < BOARD_SIZE && yIndex < BOARD_SIZE; xIndex++ , yIndex++)
                {
                    setValues(temp,xIndex,yIndex);
                }
            }

            if(temp.getY() != BOARD_SIZE - 1 && !endFound) //right horizontal
            {
                for(int xIndex = temp.getX(), yIndex = temp.getY() + 1; yIndex < BOARD_SIZE; yIndex++)
                {
                    setValues(temp,xIndex,yIndex);
                }
            }

        }
    }

    private static void setValues(coordinates temp,int xIndex, int yIndex)
    {
        if(board[xIndex][yIndex] == '+')
        {
            endFound = Boolean.TRUE;
            coordinatesToReturn = temp;
        }
    }

    public static String EightQueens(String[] queens)
    {
        board = new Character[BOARD_SIZE][BOARD_SIZE];
        queensBuffer = new coordinates[ELEMENTS_TO_READ];
        endFound = Boolean.FALSE;
        coordinatesToReturn = new coordinates();
        String result;

        for(int index = 0; index < ELEMENTS_TO_READ; index++)
        {
            queensBuffer[index] = new coordinates();
        }

        initBoard();
        readInputAndConversion(queens);

        for(int index = 0; index < BOARD_SIZE; index++)
            board[queensBuffer[index].getX()][queensBuffer[index].getY()] = '+';

        evaluate();
        //transform output
        coordinatesToReturn.setX(8 - coordinatesToReturn.getX());
        coordinatesToReturn.setY(1 + coordinatesToReturn.getY());
        if(endFound)
        {
            result = "(" + coordinatesToReturn.getX() + "," + coordinatesToReturn.getY() + ")";
        }
        else
            result = "true";
        return result;
    }

    //TODO: parmeterize this solution
    public void run() {
        Scanner scan = new Scanner(System.in);
        String[] queens = {"(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)", "(7,7)", "(5,8)"};
        System.out.print(EightQueens(queens));
    }
}
