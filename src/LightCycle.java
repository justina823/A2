import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Point;
import java.awt.*;
public class LightCycle {
    private int x, y;
    private int xDirection, yDirection;
    private int velocity = 5;
    private final ArrayList<Point> dataPoints = new ArrayList<>();
    private final int size;
    private final Color color;
    private static final Random random = new Random();
    boolean live = true;

// default the light cycle start with moving right
    LightCycle(int size, Color color) {
        x = 0;
        y = 0;
        xDirection = velocity;
        yDirection = 0;
        this.size = size;
        this.color = color;
    }
//    move up
    public void up(){
        xDirection = 0;
        yDirection = -velocity;

    }
//    move down

    public void down(){
        xDirection = 0;
        yDirection = velocity;
    }
//    move left
    public void left(){
        xDirection = -velocity;
        yDirection = 0;
    }
//    move right
    public void right(){
        xDirection = velocity;
        yDirection = 0;
    }
//    move faster
    public void faster(){
        velocity = 10;
    }

//    move the point
    void move() {

        x = x + xDirection;
        y = y + yDirection;
//      if the LightCycle still alive, keep moving
        if (live){
            Point point = new Point(x, y);
            dataPoints.add(point);
        }
//        touch the wall, LightCycle die
        if(x==0 && y==0)

            live= false;
 //        touch the wall, LightCycle die
        if(x==600 && y==600)

            live= false;
    }

//   draw the line of light into gird
    void draw(Graphics graphics) {

        graphics.setColor(color);
        graphics.fillRect(x, y, size, size);  // current point
        for(Point point : dataPoints) {
            graphics.fillRect(point.x,point.y,size,size); // traveled point
        }

    }
//    random number between 1-600
    void Random() {
        x = random.nextInt(600);
        y = random.nextInt(600);
    }


}


