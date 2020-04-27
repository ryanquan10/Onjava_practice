package typeinfo;

import java.util.stream.Stream;

public class Shapes {

    public static void main(String[] args) {
        Stream.of(new Circle(),new Square(),new Triangle())
                .forEach(Shape::draw);
    }
}

abstract class Shape{
    void draw(){
        System.out.println(this+".draw");
    }

    @Override
    public abstract String toString();




}


class Triangle extends Shape {
    @Override
    public String toString() { return "Triangle"; }
}
class Circle extends Shape {
    @Override
    public String toString() { return "Circle"; }
}
class Square extends Shape{

    @Override
    public String toString() { return "Square"; }
}


