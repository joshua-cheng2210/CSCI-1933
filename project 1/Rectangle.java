import java.awt.Color;

public class Rectangle {
    private double x_pos;
    private double y_pos;
    private double width;
    private double height;
    private Color color;

    public Rectangle(double x, double y, double ww, double hh){
        this.x_pos = x;
        this.y_pos = y;
        this.width = ww;
        this.height = hh;
        this.color = Color.BLACK;
    }

    public double calculatePerimeter(){
        return (this.width + this.height) * 2;
    }

    public double calculateArea(){
        return this.width * this.height;
    }

    public void setColor(Color xxx){
        this.color = xxx;
    }

    public void setPos(double xx, double yy){
        this.x_pos = xx;
        this.y_pos = yy;
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
        return this.x_pos;
    }

    public double getYPos(){
        return this.y_pos;
    }

    public double getHeight(){
        return this.height;
    }

    public double getWidth(){
        return this.width;
    }
}
