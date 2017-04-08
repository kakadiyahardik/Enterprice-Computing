package Lab02;
public class TriangleTester {
public static void main(String[] args) {
Triangle t1 = new Triangle();
Triangle t2 = null;
Triangle t3 = new Triangle();
t2 = new Triangle(7, 7, 5);
t3.resize(7, 7, 5);
//test area and perimeter
System.out.println("Area of t1: " + t1.area());
System.out.println("Perimeter of t1: " + t1.perimeter());
System.out.println("Area of t2: " + t2.area());
System.out.println("Perimeter of t2: " + t2.perimeter());
System.out.println("Area of t3: " + t3.area());
System.out.println("Perimeter of t3: " + t3.perimeter());
}
}