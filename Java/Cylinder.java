package Java;

public class Cylinder<E> {
    E bottom;
    double height;
    public Cylinder(E bottom, double height){
        this.bottom = bottom;
        this.height = height;
    }
    public double volume(){
        String s = bottom.toString();
        double area = Double.parseDouble(s);
        return area * height;
    }
    public static void main(String[] args){
        Rectangle rect = new Rectangle(8, 5);
        Cylinder<Rectangle> c1 = new Cylinder<Rectangle>(rect, 12);
        System.out.println("长方体的体积为： " + c1.volume());
        Circle circle = new Circle(5);
        Cylinder<Circle> c2 = new Cylinder<Circle>(circle, 7);
        System.out.println("圆柱体的体积为： " + c2.volume());
    }
}
class Circle{
    double radius, area;
    public Circle(double radius){
        this.radius = radius;
    }
    public String toString(){
        area = 3.14 * radius * radius;
        return "" + area;
    }
}
class Rectangle{
    double length, width, area;
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public String toString(){
        area = length * width;
        return "" + area;
    }
}
