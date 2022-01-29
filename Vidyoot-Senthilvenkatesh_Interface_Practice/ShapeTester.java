import java.util.ArrayList;

/**
 * This is the ShapeTester class that prints out the area and perimeter of each shape
 * It instantiates a new object for each shape and prints out the values for perimeter and area
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 1/28/2022
 */
public class ShapeTester {

    public static void main(String[] args){
        //Instantiates a new object and provides parameters for each shape object
        Shape squareObj = new Square(11.00, 10.00);
        Shape triangleObj = new Triangle(11.00, 10.00, 10.00, 10.00);
        Shape rectangleObj = new Rectangle(11.00, 10.00);
        Shape circleObj = new Circle(11.00);

        //Creates the ArrayList that contains the shape objects
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        //Adds all the shape objects to the ArrayList
        shapes.add(squareObj);
        shapes.add(triangleObj);
        shapes.add(rectangleObj);
        shapes.add(circleObj);

        //Loops through the ArrayList and prints out the values for area and perimeter using printf
        for (Shape shape : shapes){
            System.out.printf("The perimeter of %s is %f \nThe area of %s is %f  \n\n", shape.getName(), shape.getPerimeter(), shape.getName(), shape.getArea());
        }
    }
}
