public class Triangle implements Shape {

    public double base;
    public double height;
    public double side3;

    public Triangle(double sidesinput1, double sidesinput2, double sidesinput3) {
        height = sidesinput1;
        base = sidesinput2;
        side3 = sidesinput3;
    }

    public double getPerimeter() {
        double perimeter = height + base + side3;
        return perimeter;
    }

    public double getArea() {
        double area = (height * base)/2;
        return area;
    }

    public String getName(){
        return "Triangle";
    }
}
