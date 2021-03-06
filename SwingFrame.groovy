import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingFrame extends JFrame
{

    public SwingFrame()
    {
        this.setSize(1280, 1024);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(3);
        this.setTitle("Pi Swing Chess");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        GraphicsPanel panel = new GraphicsPanel();
        this.add(panel);
    }

    public static void main(String[] args)
    {

        System.setProperty("java.awt.headless", "true");

        SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    SwingFrame game = new SwingFrame();
                    game.setVisible(true);
                }
            });
    }
}
