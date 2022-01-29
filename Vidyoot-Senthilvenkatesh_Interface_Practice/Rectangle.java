/**
 * This is the Rectangle class that calculates the perimeter and area of the rectangle
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 1/28/2022
 */


public class Rectangle implements Shape {

    //Instance variables that hold the width and height of the rectangle
    public double width;
    public double height;


    /**
     * Takes in the sides of the rectangle as inputs
     * Stores the inputs in a variable
     *
     * @param One side of the rectangle
     * @param Another side of the rectangle
     */
    public Rectangle(double sidesinput1, double sidesinput2) {
        width = sidesinput1;
        height = sidesinput2;
    }

    /**
     * Calculates the perimeter of the rectangle given two points
     *
     * @return the perimeter of the rectangle
     */
    public double getPerimeter() {
        double perimeter = 2 * (width) + 2 * (height);
        return perimeter;
    }


    /**
     * Calculates the area of the rectangle given two points
     *
     * @return the area of the rectangle
     */
    public double getArea() {
        double area = width * height;
        return area;
    }


    /**
     * Returns the name of the object
     *
     * @param the name of the object
     */
    public String getName(){
        return "Rectangle";
    }
}
