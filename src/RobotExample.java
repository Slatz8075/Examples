
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author slatz8075
 */
public class RobotExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a city for the robot
        City kw = new City();
        //Create a Robot
        Robot Karel = new Robot(kw,3,4,Direction.EAST);
        Robot Jeff = new Robot(kw,1,2,Direction.SOUTH);
        Robot Steve = new Robot(kw,5,6,Direction.SOUTH);
        Jeff.setColor(Color.blue);
        Steve.setColor(Color.yellow);
        
        //create walls
        new Wall(kw,4,5,Direction.EAST);
        new Wall(kw,4,5,Direction.SOUTH);
        new Thing(kw,3,5);
        
        //Get Karel to move
        Karel.move();
        Karel.turnLeft();
        Karel.turnLeft();
        Karel.turnLeft();
        Karel.pickThing();
        Karel.move();
        Karel.putThing();
        //get Jeff to move + faster
        Jeff.setSpeed(2.5);
        Jeff.move();
        Jeff.move();
        Jeff.move();
        Jeff.turnLeft();
        Jeff.move();
        Jeff.move();
        Jeff.move();
        //Get Steve to move and change color
        //create a variable to stop the movement
        int moves = 0;
        //loop 4 times
        while (moves < 12) {
            Steve.turnLeft();
            //add 1 to the movement counter
            moves = moves +1;
        }
        
    }
}
