import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OceanPanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 870;
    static final int SCREEN_HEIGHT = 600;
    //static final int UNIT_SIZE = 25;
    //static final int OCEAN_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    Random random;

    OceanPanel() {
        this.random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.darkGray);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBubbles(g);
    }

    public void drawBubbles(Graphics g) {
        int num_of_bubbles = (random.nextInt(15));
        g.setColor(Color.white);
        for(int i = 0; i < num_of_bubbles; i++) {
            g.fillOval((random.nextInt(870-1) + 100), (random.nextInt(230-1) + 300), 10, 10);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
