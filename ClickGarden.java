import ecs100.*;
import java.awt.Color;
/**
 * Create a garden with each flower in an array
 * Can click on flowers to make them grow
 *
 * @author Janelle Woolley
 * @version 1.0 14/03/2023
 */
public class ClickGarden
{
    // class constants
    private static final int STARTX = 75;
    private static final int YPOS = 100;
    private static final int MAXFLOWERS = 5;
    
    // make an array of flowers
    private Flower[] flowerBed = new Flower[MAXFLOWERS]; //intialise array
    
    /**
     * Constructor for objects of class ClickGarden
     */
    public ClickGarden()
    {
        // initialise instance variables
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        
        //set up the flowers
        for (int i = 0; i < MAXFLOWERS; i++) {
            // set every flower to a random colour
            Color col = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            flowerBed[i] = new Flower(STARTX*(i+1), YPOS, 10, 50, col); // create the flower objs in the array
        }
        
        // draw each flower
        for (Flower flower : flowerBed) {
            flower.draw();
        }
        
        // set up mouse
        UI.setMouseListener(this::doMouse);
    }
    
    /**
     * select obj based on where the user clicks
     */
    private void doMouse(String action, double x, double y){
        if (action.equals("clicked")){
            // checks the loc of the x and y against the loc of the obj
            for(Flower flower : flowerBed) {
                if ((x >= flower.getLeft()) && (x<= flower.getRight()) && (y>=flower.getTop()) && (y<=flower.getBottom())){
                    flower.grow();
                }
            }
        }
    }
    
}
