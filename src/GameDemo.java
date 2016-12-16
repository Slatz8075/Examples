
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author slatz8075
 */


public class GameDemo extends JComponent implements KeyListener{

    // Height and Width of our game
    static final int WIDTH = 768;
    static final int HEIGHT = 768;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    BufferedImage stage = ImageHelper.loadImage("First Stage.png");

    int angle = 0;
    double x = WIDTH/2;
    double y = HEIGHT/2;
    
    boolean moveForward = false;
    boolean moveBack = false;
    private boolean rotateR;
    private boolean rotateL;
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        // always clear the screen first!
        //create background color
        Color background = new Color(82, 82, 82);
        //clear the screen for a new animation
        g.clearRect(0, 0, WIDTH, HEIGHT);
        // GAME DRAWING GOES HERE \
        //set back ground to the stage back ground colour
        g.setColor(background);
        //
        g.fillRect(0,0,WIDTH,HEIGHT);
        //draw the stage image
        g.drawImage(stage, 0, 0, WIDTH,HEIGHT, null);
        //set the color of the player
        g.setColor(Color.RED);
        //
        g2d.translate(x+25, y+25);
        g2d.rotate(Math.toRadians(angle));
        
        g.fillRect(-6, -6, 12, 12);
        
        g2d.rotate(-Math.toRadians(angle));
        g2d.translate(-x-25, -y-25);
        // GAME DRAWING ENDS HERE
    }
    
    
    // The main game loop
    // In here is where all the logic for my game will go
    public void run()
    {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done)
        {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            if(rotateR){
                angle = (angle + 3)%360;
            }
            if(rotateL){
                angle = (angle - 3)%360;
            }
            if(moveForward){
               double dy = (-2*Math.cos(Math.toRadians(angle)))/1.3;
               double dx = (2*Math.sin(Math.toRadians(angle)))/1.3;
               y = y + dy;
               x = x + dx;
            }
            if(moveBack){
               double dy = (-2*Math.cos(Math.toRadians(angle)))/1.3;
               double dx = (2*Math.sin(Math.toRadians(angle)))/1.3;
               y = y - dy;
               x = x - dx;
            }

            // GAME LOGIC ENDS HERE 
            
            // update the drawing (calls paintComponent)
            repaint();
            
            
            
            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if(deltaTime > desiredTime)
            {
                //took too much time, don't wait
                try
                {
                    Thread.sleep(1);
                }catch(Exception e){};
            }else
            {
                try
                {
                    Thread.sleep(desiredTime - deltaTime);
                }catch(Exception e){};
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");
       
        // creates an instance of my game
        GameDemo game = new GameDemo();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        // adds the game to the window
        frame.add(game);
        frame.addKeyListener(game);
        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        
        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            moveForward = true;
        }
        if(key == KeyEvent.VK_S){
            moveBack = true;
        }
        if(key == KeyEvent.VK_D){
            rotateR = true;
        }
        if(key == KeyEvent.VK_A){
            rotateL = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            moveForward = false;
        }
        if(key == KeyEvent.VK_S){
            moveBack = false;
        }
        if(key == KeyEvent.VK_D){
            rotateR = false;
        }
        if(key == KeyEvent.VK_A){
            rotateL = false;
        }
    }
}