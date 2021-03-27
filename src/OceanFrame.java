import javax.swing.*;

public class OceanFrame extends JFrame {

    OceanFrame() {
        this.add(new OceanPanel());
        this.setTitle("GroBeach");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
