
/**
 * This is the square class that calculates the perimeter and area of the square
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 1/28/2022
*/
public class Square implements Shape{

    //Instance variables that store length of each side
    public double side1;
    public double side2;

    /**
     * Takes in the sides of the square as inputs
     * Stores the inputs in a variable
     *
     * @param One side of the square
     * @param Another side of the square
     */
    public Square(double sidesinput1, double sidesinput2) {
        side1 = sidesinput1;
        side2 = sidesinput2;
    }

    /**
     * Calculates the perimeter of the square using the two given points.
     *
     * @return the perimeter of the square
     */
    public double getPerimeter() {
        double perimeter = 2 * (side1 + side2);
        return perimeter;
    }

    /**
     * Calculates the area of the square using the two given points.
     *
     * @return the area of the square
     */
    public double getArea() {
        double area = side1 * side2;
        return area;
    }

    /**
     * Returns the name of the object
     *
     * @param the name of the object
     */
    public String getName(){
        return "Square";
    }
}
