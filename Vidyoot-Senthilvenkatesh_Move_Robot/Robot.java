/**
 * This class is implemented by all the types of robots, and it stores the position of the robot, as well as the rotation of the robot
 * This does not actually display anything to the terminal
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/9/2022
 **/

public abstract class Robot {

    public int maze[][];
    public int xPosition = 0;
    public int yPosition = 0;
    public int xyRotation = 0;
    public String orientation = "";
    public boolean isFinished = false;

    /**
     * This is the abstract method that is implemented by all the robots
     * Makes the robot move
     */
    public abstract void move(Maze m);
}
