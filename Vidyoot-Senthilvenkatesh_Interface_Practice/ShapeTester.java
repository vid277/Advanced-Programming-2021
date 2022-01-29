import java.util.ArrayList;

public class ShapeTester {

    public static void main(String[] args){
        Shape squareObj = new Square(10.00, 10.00);
        Shape triangleObj = new Triangle(10.00, 10.00, 10.00);
        Shape rectangleObj = new Rectangle(11.00, 10.00);
        Shape circleObj = new Circle(10.00);

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(squareObj);
        shapes.add(triangleObj);
        shapes.add(rectangleObj);
        shapes.add(circleObj);

        for (Shape shape : shapes){
            System.out.printf("The perimeter of %s is %f \nThe area of %s is %f  \n\n", shape.getName(), shape.getPerimeter(), shape.getName(), shape.getArea());
        }
    }
}
