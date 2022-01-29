public class Rectangle implements Shape {

    public double width;
    public double height;

    public Rectangle(double sidesinput1, double sidesinput2) {
        width = sidesinput1;
        height = sidesinput2;
    }

    public double getPerimeter() {
        double perimeter = 2 * (width) + 2 * (height);
        return perimeter;
    }

    public double getArea() {
        double area = width * height;
        return area;
    }

    public String getName(){
        return "Rectangle";
    }
}
