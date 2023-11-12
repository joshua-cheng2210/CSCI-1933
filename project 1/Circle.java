import java.math.MathContext;
import java.awt.Color;

public class Circle {
    private double x_position;
    private double y_position;
    private double radius;
    private Color color;

    public Circle(double x_pos, double y_pos, double rad){
        this.x_position = x_pos;
        this.y_position = y_pos;
        this.radius = rad;
        this.color = Color.BLACK;
    }

    public double calculatePerimeter(){
        return 2 * this.radius * Math.PI; // remember to check if this return is double
    }

    public double calculateArea(){
        return Math.PI * Math.pow(this.radius, 2.0);
    }

    public void setColor(Color xxx){
        this.color = xxx;
    }

    public void setPos(double x, double y){
        this.x_position = x;
        this.y_position = y;
    }
    
    public void setRadius(double new_radius){
        this.radius = new_radius;
    }

    public Color getColor(){
        return this.color;
    }

    public double getXPos(){
        return this.x_position;
    }

    public double getYPos(){
        return this.y_position;
    }

    public double getRadius(){
        return this.radius;
    }
}
