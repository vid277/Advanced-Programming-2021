public class Circle implements Shape{

    public double radius;

    public Circle(double radiusinput){
        radius = radiusinput;
    }

    public double getPerimeter() {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    public double getArea() {
        double area = (Math.PI * Math.pow(radius, 2));
        return area;
    }

    public String getName(){
        return "Circle";
    }
}
