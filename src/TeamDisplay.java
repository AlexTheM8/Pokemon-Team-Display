import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class TeamDisplay extends JFrame {
    private JPanel panel;
    
    public TeamDisplay() {
        super("Team Display");
        panel = new Panel();
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        //Frame defaults
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setResizable(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        JFrame frame = new TeamDisplay();
        frame.setVisible(true);

    }
}
