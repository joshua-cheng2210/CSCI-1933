// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;
import java.util.Random;

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area

    public FractalDrawer() {
    }  // contructor


    //accepts the variable String type as only "circle", "triangle" or "rectangle" and calls the appropriate method. this method returns the total area of all the shapes drawn
    public double drawFractal(String type) {
        Canvas board = new Canvas(1000,2000);
        int level = 1;
        if (type.equals("circle")){
            drawCircleFractal(150, 800, 400, Color.blue, board, level); 
        } else if (type.equals("triangle")){
            drawTriangleFractal(100, 100, 700, 450, Color.blue, board, level); 
        } else if (type.equals("rectangle")){
            drawRectangleFractal(400, 200, 600, 300, Color.blue, board, level); 
        }
        return totalArea; // calculate area in the recursive drawing shape method
    }

    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas board, int level){
        if (level >= 0){
            Triangle TT = new Triangle(x, y, width, height);
            TT.setColor(c);
            board.drawShape(TT);
            totalArea += TT.calculateArea();
            Random random = new Random();
            Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE};
            int randomIndex = random.nextInt(colors.length);
            c = colors[randomIndex];
            if (level >= 1){
                // bottom left triangle
                drawTriangleFractal(width/2, height/2, x - width/2, y, c, board, level - 1);
                //bottom right triangle
                drawTriangleFractal(width/2, height/2, x + width, y, c, board, level - 1);
                // top triangle
                drawTriangleFractal(width/2, height/2, x + width/4, y - height, c , board, level - 1);
            }
        }
    }

    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas board, int level) {
        if (level >= 0){
            Circle circle = new Circle(x, y, radius);
            circle.setColor(c);
            board.drawShape(circle);
            totalArea += circle.calculateArea();
            Random random = new Random();
            Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE};
            int randomIndex = random.nextInt(colors.length);
            c = colors[randomIndex];
            if (level >= 1){
                //top circle
                drawCircleFractal(radius/2, x, y - radius, c, board, level - 1);
                //left circle
                drawCircleFractal(radius/2, x - radius, y, c, board, level - 1);
                //bottom circle
                drawCircleFractal(radius/2, x, y + radius, c, board, level - 1);
                //right circle
                drawCircleFractal(radius/2, x + radius, y, c, board, level - 1);
            }
        }
    }

    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas board, int level) {
        if (level >= 0){
            Rectangle Rec = new Rectangle(x, y, width, height);
            Rec.setColor(c);
            board.drawShape(Rec);
            totalArea += Rec.calculateArea();
            Random random = new Random();
            Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE};
            int randomIndex = random.nextInt(colors.length);
            c = colors[randomIndex];
            if (level >= 1){
                //top left rectangle
                drawRectangleFractal(width/2, height/2, x-width/4, y-height/4, c, board, level - 1);
                //top right rectangle
                drawRectangleFractal(width/2, height/2, x+width*3/4, y-height/4, c, board, level - 1);
                //bottom left rectangle
                drawRectangleFractal(width/2, height/2, x-width/4, y+height*3/4, c , board, level - 1);
                //bottom right rectangle
                drawRectangleFractal(width/2, height/2, x+width*3/4, y+height*3/4, c , board, level - 1);
            }
        }
    }

    // ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        FractalDrawer draw = new FractalDrawer();
        Scanner scan = new Scanner(System.in);
        System.out.println("choices: \"circle\", \"triangle\", or \"rectangle\"");
        String input = scan.nextLine();
        double area = draw.drawFractal(input);
        System.out.println(area);
    }
}
