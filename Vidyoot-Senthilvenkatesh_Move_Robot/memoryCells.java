/**
 * This class is used by the MemoryRobot to store the dead ends
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/9/2022
 **/

public class memoryCells {

    public int xPosition = 0;
    public int yPosition = 0;
    public int xyRotation = 0;

    /**
     * Stores the current position and orientation of the robot to a variable
     *
     * @param xPosition the x position of the robot
     * @param yPosition the y position of the robot
     * @param xyRotation the orientation of the robot
     */
    public memoryCells(int xPosition, int yPosition, int xyRotation) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xyRotation = xyRotation;
    }
}
