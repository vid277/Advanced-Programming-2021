/**
 * This is the circle class that calculates the circumference and area of the circle
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 1/28/2022
 */

public class Circle implements Shape{

    //Holds the radius of the circle
    public double radius;

    /**
     * This constructor takes in radius as an input and assigns it to the radius variable
     *
     * @param The radius of the circle
     */

    public Circle(double radiusinput){
        radius = radiusinput;
    }

    /**
     * This method calculates the circumference of the circle
     *
     * @return the circumference/perimeter of the circle
     */
    public double getPerimeter() {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    /**
     * This method calculates the area of the circle
     *
     * @return the area of the circle
     */
    public double getArea() {
        double area = (Math.PI * Math.pow(radius, 2));
        return area;
    }

    /**
     * Returns the name of the object
     *
     * @param the name of the object
     */
    public String getName(){
        return "Circle";
    }
}
