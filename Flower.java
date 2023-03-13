import ecs100.*;
import java.awt.Color;
/**
 * Flower support class
 * Creates a flower of a size and colour
 * It can grow
 * It can tell the driver class where it is on the screen
 *
 * @author Janelle Woolley
 * @version 2.0 14/03/23
 */
public class Flower
{
    // instance variables
    private double flowerX;        // x position of the flower
    private double flowerY;        // y position of the flower
    
    private int flowerSize;        // flower size
    private int flowerHeight;      // flower height
    
    private double left;           // left of the flower
    private double top;            // top of the flower
    private double bottom;         // bottom of the flower
    
    private Color color;           // color of flower
    
    
    /**
     * Constructor for objects of class Flower
     */
    public Flower(double x, double y, int size, int stem, Color col)
    {
        // initialise instance variables
        flowerX = x;
        flowerY = y;
        flowerSize = size;
        flowerHeight = stem;
        color = col;
        
        // set the top, left and bottom
        setTop();
        setLeft();
        setBottom();
    }
    
    /**
     * getter left
     */
    public double getLeft() {
        return this.left;
    }
    
    /**
     * getter right
     */
    public double getRight() {
        return this.left + this.flowerSize;
    }
    
    /**
     * getter top
     */
    public double getTop() {
        return this.top;
    }
    
    /**
     * getter bottom
     */
    public double getBottom() {
        return this.bottom;
    }
    
    /**
     * set left
     */
    public void setLeft() {
        this.left = this.flowerX - this.flowerSize/2.0;
    }
    
    /**
     * set top
     */
    public void setTop() {
        this.top = this.flowerY - this.flowerSize/2.0;
    }
    
    /**
     * set bottom
     */
    public void setBottom() {
        this.bottom = this.flowerY + this.flowerHeight;
    }
    
    /**
     * Draws flower in the canvas
     */
    public void draw() {
        final int STEMWIDTH = 2;
        final int WAITMS = 500;
        // draw stem
        UI.setColor(Color.green);    // set color of stem
        UI.setLineWidth(STEMWIDTH);    // set width of stem
        UI.drawLine(flowerX, flowerY, flowerX, bottom);    // draw in stem
            
        // draw flower
        UI.setColor(this.color);    // set color of flower
        UI.fillOval(left, top, flowerSize, flowerSize);    // draw the flower
        UI.sleep(WAITMS);    // wait
    }
    
    /**
     * Erase a rectangle around the current instance
     */
    public void erase() {
        final int BUFFER = 1;
        UI.eraseRect(left, top, flowerSize+BUFFER, bottom+BUFFER);
    }
    
    /**
     * Make the flower grow
     */
    public void grow() {
        final int GROWSIZE = 10;
        this.erase(); // erase the flower
        this.flowerY -= GROWSIZE; //increase the height
        this.flowerSize += GROWSIZE; //increase the size of the bulb
        
        // set the new postion
        this.setTop();
        this.setLeft();
        
        this.draw();
    }
}