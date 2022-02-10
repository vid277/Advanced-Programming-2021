import java.util.ArrayList;

/**
 * This class is currently used to make the robot store the location of the dead ends, to not visit it again
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/9/2022
 **/

public class MemoryRobot extends Robot {

    public ArrayList<memoryCells> cells = new ArrayList<>();

    public boolean front;
    public boolean back;
    public boolean right;
    public boolean left;

    /**
     * Checks if the sides surrounding the robot are open or closed
     * If more than 3 sides are closed, then the robot stores the location as a dead end
     *
     * @param m the maze that the robot has to navigate
     */
    @Override
    public void move(Maze m) {
        //ToDo: Implement moving
        if (maze[xPosition][yPosition + 1] == 1){
            front = true;
        }
        if (maze[xPosition - 1][yPosition] == 1){
            left = true;
        }
        if (maze[xPosition + 1][yPosition] == 1){
            right = true;
        }
        if (maze[xPosition][yPosition - 1] == 1){
            back = true;
        }

        if ((back && right && left) || (back && right && front) || (right && front && left) || (left && back && front)) {
            cells.add(new memoryCells(xPosition, yPosition, xyRotation));
        }
    }
}
