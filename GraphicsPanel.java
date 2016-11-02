import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import java.io.File;

public class GraphicsPanel extends JPanel implements ActionListener 
{
    private Timer timer;
    private BufferedImage ball;
    private int mouseX, mouseY;

    public GraphicsPanel() 
    {
        try
        {
            ball = ImageIO.read(new File("ball.png"));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        setBackground(Color.BLACK);  

        addKeyListener(new KeyboardyMcKeyboardFace());  
        addMouseListener(new MouseyMcMouseFace());
        setFocusable(true);

        timer = new Timer(16, this);
        timer.start();                 

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX() - (int) this.getLocationOnScreen().getX();
        mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY() - (int) this.getLocationOnScreen().getY();        
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) 
    {     
        super.paintComponent(g);       

        g.drawImage (ball, mouseX - 40, mouseY - 40, this);
    }

    class KeyboardyMcKeyboardFace extends KeyAdapter 
    {
        @Override
        public void keyPressed(KeyEvent e) 
        {
            int keycode = e.getKeyCode();

            if (keycode == 'q' || keycode == 'Q') 
            {
                System.exit(0);
                return;
            }            
        }
    }

    class MouseyMcMouseFace implements MouseListener
    {
        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}        
    }
}