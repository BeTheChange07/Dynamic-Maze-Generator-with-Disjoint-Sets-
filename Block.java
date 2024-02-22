public class Block {
    Block(int num){
        hasLeftWall = true;
        hasFloor = true;
        blockNum = num;

    }

    boolean getLeftWall(){
        return hasLeftWall;
    }

    boolean getFloor(){
        return hasFloor;
    }


    void setHasLeftWall(boolean leftWall){
        hasLeftWall = leftWall;

    }

    void setHasFloor(boolean floor){
        hasFloor = floor;
    }



    private boolean hasLeftWall;
    private boolean hasFloor;
    private int  blockNum;

}
