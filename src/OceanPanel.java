import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OceanPanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 870;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int OCEAN_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    Random random;

    OceanPanel() {
        this.random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.darkGray);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
