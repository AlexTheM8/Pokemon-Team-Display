import java.awt.*;
import java.awt.event.*;
import java.net.URL;
//import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Panel extends JPanel {
    private TeamMember team[] = new TeamMember[6];
    private Image bg;
    private String bgSource = "Images/partybox.png";
    private Timer timer;
    private int inParty;
    // private ArrayList<TeamMember> allPokemon;

    public Panel() {
        // Background
        URL url = getClass().getResource(bgSource);
        ImageIcon icon = new ImageIcon(url);
        bg = icon.getImage();

        for (int i = 0; i < 6; i++) {
            team[i] = null;
        }

        inParty = 0;

        timer = new Timer(130, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();

    }

    public int getTeamSize() {
        return inParty;
    }

    public void addToTeam(TeamMember m) {
        if (inParty < 6) {
            team[inParty] = m;
            inParty++;
        }
        // allPokemon.add(m);
        // Else add to backup roster
    }

    public void removeFromTeam(int slot) {
        if (team[slot-1] != null) {
            for (int i = slot-1; i < inParty-1; i++) {
                team[i] = team[i+1];
                team[i].setSlot(i+1);
            }
            inParty--;
            team[inParty] = null;
        }
    }
    
    public void changeMember(int slot, String newPoke, String newName) {
        if (!newPoke.equals("N/A")) {
            team[slot-1].setDexNum(newPoke);
        }
        
        if (!newName.equals("")) {
            team[slot-1].setNick(newName);
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        for (int i = 0; i < 6; i++) {
            if (team[i] != null) {
                team[i].paint(g);
            }
        }
    }

}
