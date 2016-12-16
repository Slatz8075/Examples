
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author slatz8075
 */
public class whileLoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City kw = new City();
        Robot karel = new Robot(kw, 1,1,Direction.EAST);
        
        new Wall(kw,1,5,Direction.EAST);
        new Thing (kw,1,3);
        
        //while loop with no condition
        while(karel.frontIsClear()){
            //move the robot
            karel.move();
            //check for something to pick up
            if(karel.canPickThing()){
                //pick it up
                karel.pickThing();
            }
      }          
      //end loop  
      //turn the robot around
      karel.turnLeft();
      karel.turnLeft();
      
      //go home karel
      while(karel.getAvenue() != 1){
          karel.move();
      }
        
    }
}
