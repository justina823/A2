import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel{
    //  an arraylist to contain the two light cycles
    private final ArrayList<LightCycle> lightCycles = new ArrayList<>();
// set up grid
    Grid() {
        setFocusable(true);
        setPreferredSize(new Dimension(600,600));
        setBackground(new Color(45, 45, 45));
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setFocusable(true);
    }

//    add light cycles to array list
    void addLightCycle(LightCycle lightCycle) {

        lightCycles.add(lightCycle);
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for(LightCycle light : lightCycles)
        {
            light.draw(graphics);

        }
    }



}
