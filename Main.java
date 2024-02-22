 import java.util.*;

 import static java.lang.System.exit;

 public class Main{
    // Test main; all finds on same output line should be identical
    public static void main( String [ ] args )
    {
        System.out.print("Please input two numbers to specify the dimensions of the maze (min 1 ,max 20): \n");
        Scanner scanner = new Scanner(System.in);

        int width = 0, height = 0;
        try{

            width = scanner.nextInt();

            if(width > 20 || width < 1){
                throw new Exception();
            }

            height = scanner.nextInt();
            if(height > 20 || height < 1){
                throw new Exception();
            }

        }catch ( Exception e){
            System.out.println("the dimensions you entered were incorrect ");
            exit(10);

        }


        Maze maze = new Maze(width, height);

        maze.mazePrinter();


    }
 }