
import java.awt.Color;
/**
 * testing
 */
public class testing {

    public static void main(String[] args) {
        Canvas drawing = new Canvas(800,800);
        Triangle TT = new Triangle(100, 100, 100, 100);
        TT.setColor(Color.BLUE);
        drawing.drawShape(TT);
    }
}