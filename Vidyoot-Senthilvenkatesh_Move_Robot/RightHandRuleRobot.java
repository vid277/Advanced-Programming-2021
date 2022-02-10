/**
 * This class makes sure that the robot always sticks to the righthand side of the Maze
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/9/2022
 **/
public class RightHandRuleRobot extends Robot {

    /**
     * Checks the front, and the sides of the robot and makes the robot always stick to the right hand side.
     * ToDo Implement proper utilization of the xyRotation of the robot
     **/
    @Override
    public void move(Maze m) {
        if (maze[xPosition + 1][yPosition] == 1){
            if (maze[xPosition][yPosition + 1] == 1) {
                xPosition = xPosition - 1;
                xyRotation = xyRotation + 90;
            }
            else{
                yPosition++;
            }
        }
        else {
            xPosition++;
            xyRotation = xyRotation - 90;
        }
    }
}
