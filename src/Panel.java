import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
@SuppressWarnings("serial")
public class Panel extends JPanel {
    private Image bg;
    private String bgSource = "Images/partybox.png"; //TODO Put actual source
    public Panel() {
        //Background
        URL url = getClass().getResource(bgSource);
        ImageIcon icon = new ImageIcon(url);
        bg = icon.getImage();

    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, null);
    }

}
