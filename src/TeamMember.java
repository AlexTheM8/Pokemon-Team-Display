import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
public class TeamMember {
    private String nickname;
    private Image img;
    private String pokeName;
    private int slot;
    private int x;
    private int y = 60;

    public TeamMember(String p, String n, int s) {
        pokeName = p;
        nickname = n;
        slot = s;
        x = 117 + ((s-1)*167);
            
        
        setImage(); //TODO Generalize
    }
    
    private void setImage() {
        URL url = getClass().getResource("Images/Pokemon/002.gif");
        ImageIcon icon = new ImageIcon(url);
        img = icon.getImage();
    }
    
    public void paint(Graphics g) {
        g.drawImage(img, x, y, null);
        Font small = new Font("TimesRoman", Font.PLAIN, 25);
        g.setFont(small);
        g.setColor(Color.WHITE);
        g.drawString(nickname, x, y + 168);
    }
}
