import java.util.Random;

/**
 * This class moves the robot in any random direction through the maze
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/9/2022
 **/

public class RandomRobot extends Robot {
    Random r = new Random();

    /**
     * Generates a random number between 1 and 4, and makes the robot move based on this number
     *
     * @param m the maze that the robot has to navigate
     */
    @Override
    public void move(Maze m) {
        int move =  r.nextInt(1, 4);
        String turn = "";
        switch (move) {
            case (1):
                if (maze[xPosition + 1][yPosition] == 0) {
                    xPosition++;
                    xyRotation += 90;
                    orientation = "right";
                }
            case (2):
                if (maze[xPosition - 1][yPosition] == 0) {
                    xPosition = xPosition - 1;
                    xyRotation -= 90;
                    orientation = "left";
                }
            case (3):
                if (maze[xPosition][yPosition + 1] == 0) {
                    yPosition++;
                    xyRotation = 0;
                    orientation = "front";
                }
            case (4):
                if (maze[xPosition][yPosition - 1] == 0) {
                    yPosition = yPosition - 1;
                    xyRotation += 180;
                    orientation = "down";
                }
            else {
                move(m);
            }
        }
    }
}
