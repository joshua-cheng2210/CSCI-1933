import java.awt.Color;

public class Triangle {
    private double x_pos;
    private double y_pos;
    private double width;
    private double height;
    private Color color;

    public Triangle(double x, double y, double ww, double hh){
        this.x_pos = x;
        this.y_pos = y;
        this.width = ww;
        this.height = hh;
        this.color = Color.BLACK;
        // System.out.println("Hello world 5!!!!");
    }

    public double calcPerimeter(){
        return this.width * 3;
    }

    public double calculateArea(){
        return this.width * this.height * 0.5;
    }

    public void setColor(Color xxx){
        this.color = xxx;
    }

    public void setPos(double x, double y){
        this.x_pos = x;
        this.y_pos = y;
    }

    public void setHeight(double hh){
        this.height = hh;
    }

    public void setWidth(double ww){
        this.width = ww;
    }

    public Color getColor(){
        return this.color;
    }

    public double getXPos(){
        return x_pos;
    }

    public double getYPos(){
        return y_pos;
    }

    public double getHeight(){
        return this.height;
    }

    public double getWidth(){
        return this.width;
    }
}
