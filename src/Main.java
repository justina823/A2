import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;



public class Main {


    public static void main(String[] args) {
        // set up 2 player
        int num=2;
        JOptionPane.showMessageDialog(null,"This is two player battle！！！");


        String[] PlayerList = new String[num]; //a list with player name
        Color[] colors; // a list with player selected color
        colors = new Color[num];

//        use for loop to ask user name and color
//        store in PlayerList and colors
        for (int i=0; i < num; i++){
            String player = JOptionPane.showInputDialog("Hello!! Please enter your name: ");
            Color c = JColorChooser.showDialog(null, "Choose a color for your Light Cycle", Color.WHITE);

            PlayerList[i]= player ;
            colors[i] =(c);
        }
//      tell user how to control the light
        JOptionPane.showMessageDialog(null,"player 1 use W =Upwards, S =Downwards, A= Leftwards, D=Rightwards,Space Bar = Move faster ");
        JOptionPane.showMessageDialog(null,"player 2 use Up =Upwards, Down =Downwards, Left= Leftwards, Right =Rightwards,Shift = Move faster ");

//        create frame of game and  title
        JFrame frame = new JFrame("Light Cycle");
        Grid grid = new Grid();

//      set up the scoreboard on right
//      grid in center
        ScoreBoard scoreBoard = new ScoreBoard();
        frame.add(grid, BorderLayout.CENTER);
        frame.add(scoreBoard, BorderLayout.EAST);
        

//        use for loop to add user name in scoreboard
        for (int x=0;x<num;x++){


            JLabel name = new JLabel("Name: " + PlayerList[x] + " | ");
            final JLabel score = new JLabel("Score: \n");

            scoreBoard.add(name, BorderLayout.EAST);
            scoreBoard.add(score, BorderLayout.EAST);
            frame.add(grid, BorderLayout.CENTER);
            frame.pack();


        }
//      using an arraylist to contain the size of light and color
        LightCycle player1 = new LightCycle(10, colors[0]);
        LightCycle player2 = new LightCycle(10, colors[1]);
//      using random start to draw the first point of light
//      add light cycle in grid
        player1.Random();
        grid.addLightCycle(player1);

        player2.Random();
        grid.addLightCycle(player2);


//      using timer to update the gird every 100 milliseconds
        Timer timer = new Timer(100, e -> {
            player1.move();
            player2.move();

            
            grid.repaint();

        });

        timer.start();

//       create the controller
        grid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_W){
                    player1.up();
                }
                if (code == KeyEvent.VK_S){
                    player1.down();
                }
                if (code == KeyEvent.VK_A){
                    player1.left();
                }
                if (code== KeyEvent.VK_D){
                    player1.right();
                }
                if (code== KeyEvent.VK_SPACE){
                    player1.faster();
                }
            }
        });
        grid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_UP){
                    player2.up();
                }
                if (code == KeyEvent.VK_DOWN){
                    player2.down();
                }
                if (code == KeyEvent.VK_LEFT){
                    player2.left();
                }
                if (code== KeyEvent.VK_RIGHT){
                    player2.right();
                }
                if (code== KeyEvent.VK_SHIFT){
                    player2.faster();
                }

            }
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        }


}

