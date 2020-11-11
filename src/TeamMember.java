import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class TeamMember {
    private String nickname;
    private Image img;
    private String dexNum;
    private int slot;
    private int x;
    private int y = 60;

    public TeamMember(String num, String nick, int s) {
        dexNum = num;
        nickname = nick;
        setSlot(s);
        setImage();
    }

    public void setSlot(int s) {
        slot = s;
        if (slot > -1)
            x = 117 + ((s - 1) * 167);
    }

    public void setDexNum(String n) {
        dexNum = n;
        setImage();
    }

    public String getDexNum() {
        return dexNum;
    }

    public void setNick(String n) {
        nickname = n;
    }

    public String getNick() {
        return nickname;
    }

    private void setImage() {
        URL url = getClass().getResource("Images/Pokemon/" + dexNum + ".gif");
        ImageIcon icon = new ImageIcon(url);
        img = icon.getImage();
    }

    public void paint(Graphics g) {
        g.drawImage(img, x, y, null);
        g.setFont(new Font("GillSansMT", Font.PLAIN, 25));
        g.setColor(Color.WHITE);
        g.drawString(nickname, x, y + 165);
    }
}
