import java.security.SecureRandom;
import java.util.Random;

public class Maze {

    Maze(int wwidth, int hheight) {

        width = wwidth;
        height = hheight;

        maze = new Block[height][width];


        int blockNum = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                maze[row][col] = new Block(blockNum++);
            }
        }

        // make an entrance
        maze[0][0].setHasLeftWall(false);

        // make the random maze path
        makeMazePath();



    }

    // connect to block above
    void connectUp(int blockNum){
         if(set.find(blockNum) != set.find(blockNum -width)){
             set.union(set.find(blockNum), set.find(blockNum -width));
             unionCount++;
             maze[(blockNum / width) -1 ][blockNum % width].setHasFloor(false);
         }

    }

    // connect to block to the right
    void connectRight(int blockNum){
        if(set.find(blockNum) != set.find(blockNum + 1)){
            set.union(set.find(blockNum),set.find(blockNum +1));
            unionCount++;
            maze[(blockNum / width)][(blockNum % width) +1].setHasLeftWall(false);
        }

    }

    // connect to block below
    void connectDown(int blockNum){
        if(set.find(blockNum) != set.find(blockNum + width)){
            set.union(set.find(blockNum),set.find(blockNum + width));
            unionCount++;
            maze[blockNum / width][blockNum % width].setHasFloor(false);
        }
    }

    // connect to block to the left
    void connectLeft(int blockNum){
        if(set.find(blockNum) != set.find(blockNum -1)) {
            set.union(set.find(blockNum), set.find(blockNum - 1));
            unionCount++;
            maze[blockNum / width][blockNum % width].setHasLeftWall(false);

        }
    }

    // this method creates the random maze path
    void makeMazePath(){
        setSize = height * width;
        set = new DisjSets(setSize);
        SecureRandom secureRandom = new SecureRandom();
        int blockNum;
        int upDownLeftOrRight;

        // loop until path is made
        for(unionCount = 0;  unionCount < setSize -1; ){
            blockNum = secureRandom.nextInt(setSize);
            upDownLeftOrRight = secureRandom.nextInt(4) + 1;

                // if up
                 if (upDownLeftOrRight == 1) {
                     if((blockNum / width) == 0 ){
                         continue;
                     }
                        connectUp(blockNum);
                        continue;
                 }
                 // if right
                 else if(upDownLeftOrRight == 2){
                     if((blockNum % width) == (width -1)){
                         continue;
                     }
                         connectRight(blockNum);
                         continue;
                }
                 // if down
                 else if(upDownLeftOrRight == 3){
                     if((blockNum / width) == (height -1) ){
                         continue;
                     }

                       connectDown(blockNum);
                       continue;
                 }
                 // if left
                    else if (upDownLeftOrRight == 4) {
                        if(blockNum % width == 0){
                            continue;
                        }
                       connectLeft(blockNum);
                       continue;
                    }


        }
    }


    // this method prints the maze
    void mazePrinter(){

        // first print the top of the maze
        for(int i = 0 ; i < width; i++){
            System.out.print(".__");
            if(i == width -1){
                System.out.println();
            }
        }


        // print the maze structure
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                if(maze[row][col].getLeftWall()){
                    System.out.print("|");
                } else{
                    System.out.print(".");
                }

                if(maze[row][col].getFloor()){
                    System.out.print("__");

                } else{
                    System.out.print("  ");
                }

                if(col == width - 1){
                   if(row == height -1){
                       System.out. println("");
                   } else{
                       System.out.println("|");
                   }
                }
                else{
                    continue;
                }
            }
        }

    }


    private int unionCount;
    private int setSize;
    private int height;
    private int width;
    private Block[][] maze;
    private DisjSets set;
}