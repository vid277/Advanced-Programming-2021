public class Square implements Shape{

    public double side1;
    public double side2;

    public Square(double sidesinput1, double sidesinput2) {
        side1 = sidesinput1;
        side2 = sidesinput2;
    }

    public double getPerimeter() {
        double perimeter = 2 * (side1 + side2);
        return perimeter;
    }

    public double getArea() {
        double area = side1 * side2;
        return area;
    }

    public String getName(){
        return "Square";
    }
}
