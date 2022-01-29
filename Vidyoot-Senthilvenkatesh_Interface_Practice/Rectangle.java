public class Rectangle implements Shape {

    public double width;
    public double height;

    public Rectangle(double sidesinput1, double sidesinput2) {
        width = sidesinput1;
        height = sidesinput2;

        getPerimeter();
        getArea();
    }

    public double getPerimeter() {
        double perimeter = 2 * (width) + 2 * (height);
        System.out.printf("The perimeter of the rectangle is: %f  \n", perimeter);
        return perimeter;
    }

    public double getArea() {
        double area = width * height;
        System.out.printf("The area of the rectangle is: %f  \n \n", area);
        return area;
    }
}
