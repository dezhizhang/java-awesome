package shop.xiaozhicloud.ocp;

public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Rectangle());

    }
}

class GraphicEditor{
    public void drawShape(Shape s){
        s.draw();
    }
}


abstract class Shape {
    public abstract void draw();
}

class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("draw circle");
    }
}

class Rectangle extends Shape {

    @Override
    public void draw() {
        System.out.println("draw rectangle");
    }
}




