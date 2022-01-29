public class Triangle implements Shape {

    public double base;
    public double height;
    public double side3;

    public Triangle(double sidesinput1, double sidesinput2, double sidesinput3) {
        height = sidesinput1;
        base = sidesinput2;
        side3 = sidesinput3;


        getPerimeter();
        getArea();
    }

    public double getPerimeter() {
        double perimeter = height + base + side3;
        System.out.printf("The perimeter of the triangle is: %f  \n", perimeter);
        return perimeter;
    }

    public double getArea() {
        double area = (height * base)/2;
        System.out.printf("The area is of the triangle is: %f  \n \n", area);
        return area;
    }
}
