import kareltherobot.*;
import java.awt.Color;

public class SmartBot extends Robot
{
    // pass parameters to parent constructor
    public SmartBot(int street, int avenue, Direction direction, int beepers, Color color)
    {
        super(street, avenue, direction, beepers, color);
    }
    
    // Robots already know how to . . .
    //  turnLeft()
    //  move()
    //  putBeeper()
    //  pickBeeper()
    //  turnOff()
    
    // Robots also can determine if . . .
    //  frontIsClear()
    //  nextToABeeper()

    // turn around to face opposite direction
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }
    
    // two wrongs don't make a right, but three lefts do!
    public void turnRight()
    {
        turnAround();
        turnLeft();
    }
    
    // prevents from moving through a wall
    public void move()
    {
        if(frontIsClear())
            super.move();
    }
    
    // determines if a wall is to the left
    public boolean wallToLeft()
    {
        turnLeft();
        boolean flag = !frontIsClear(); 
        turnRight();
        return flag;
    }

    // picks up all beepers on corner
    public void pickAll()           // rewrite this method recursively
    {
        while(nextToABeeper())
            pickBeeper();
    }

    // moves forward multiple times
    public void move(int numSteps)  // rewrite this method recursively
    {
        while(numSteps > 0)
        {
            move();
            numSteps --;
        }
    }

    // moves forward until finds beeper, then returns home
    public void findBeeper()        // rewrite this method recursively
    {
        int steps = 0;
        while(!nextToABeeper())
        {
            move();
            steps ++;
        }
        turnAround();
        move(steps);
    }
    
    // counts number of beepers in a pile, and puts them back
    public int countPile()          // rewrite this method recursively
    {
        int count = 0;
        while(nextToABeeper())
        {
            pickBeeper();
            count ++;
        }
        for(int i = 0; i < count; i ++)
            putBeeper();
        return count;
    }
}
