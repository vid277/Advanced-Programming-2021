public class Circle implements Shape{

    public double radius;

    public Circle(double radiusinput){
        radius = radiusinput;

        getPerimeter();
        getArea();
    }

    public double getPerimeter() {
        double perimeter = 2 * Math.PI * radius;
        System.out.printf("The perimeter of the circle is: %f  \n", perimeter);
        return perimeter;
    }

    public double getArea() {
        double area = (Math.PI * Math.pow(radius, 2));
        System.out.printf("The area of the circle is: %f  \n \n", area);
        return area;
    }
}
