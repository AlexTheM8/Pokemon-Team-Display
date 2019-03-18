import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
@SuppressWarnings("serial")
public class Panel extends JPanel {
    private TeamMember team[] = new TeamMember[6];
    private Image bg;
    private String bgSource = "Images/partybox.png";
    private Timer timer;
    
    public Panel() {
        //Background
        URL url = getClass().getResource(bgSource);
        ImageIcon icon = new ImageIcon(url);
        bg = icon.getImage();

        team[0] = new TeamMember("temp", "Alexander", 1);
        team[1] = new TeamMember("temp", "Alexander", 2);
        team[2] = new TeamMember("temp", "Alexander", 3);
        team[3] = new TeamMember("temp", "Alexander", 4);
        team[4] = new TeamMember("temp", "Alexander", 5);
        team[5] = new TeamMember("temp", "Alexander", 6);
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
        
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        team[0].paint(g);
        team[1].paint(g);
        team[2].paint(g);
        team[3].paint(g);
        team[4].paint(g);
        team[5].paint(g);
    }

}
