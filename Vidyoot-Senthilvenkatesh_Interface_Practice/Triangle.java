/**
 * This is the triangle class that calculates the perimeter and area of the triangle
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 1/28/2022
 */

public class Triangle implements Shape {

    //Instance variables that hold the base, height, and two of the sides of the triangle
    public double base;
    public double height;
    public double side3;
    public double side2;

    /**
     * Takes in the length of each sides of the triangle, as well as the base, and assigns them to a variable
     *
     * @param the length of the base of the triangle
     * @param the length of the height of the triangle
     * @param the length of the second side of the
     * @param the length of the third side of the triangle
     */
    public Triangle(double sidesinput1, double sidesinput2, double sidesinput3, double sidesinput4) {
        height = sidesinput1;
        base = sidesinput2;
        side3 = sidesinput3;
        side2 = sidesinput4;
    }

    /**
     * Calculates the perimeter of the triangle using the given points
     *
     * @return the perimeter of the triangle
     */
    public double getPerimeter() {
        double perimeter = side2 + base + side3;
        return perimeter;
    }

    /**
     * Calculates the area of the triangle using the given points
     *
     * @return the area of the triangle
     */
    public double getArea() {
        double area = (height * base)/2;
        return area;
    }


    /**
     * Returns the name of the object
     *
     * @param the name of the object
     */
    public String getName(){
        return "Triangle";
    }
}
