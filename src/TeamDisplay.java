import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TeamDisplay extends JFrame {
    private JPanel panel;
    private ArrayList<String> dex;
    private String dexFileName = "Pokedex.txt";

    public TeamDisplay() throws Exception {
        super("Team Display");

        // load pokedex data
        dex = new ArrayList<String>();
        
        File dexFile = new File(dexFileName);
        Scanner scan = new Scanner(dexFile);
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            str = str.toLowerCase();
            dex.add(str);
        }
        scan.close();
        
        // Code for team display
        panel = new Panel();
        setLayout(new GridLayout(3, 1));
        add(panel);

        // Underneath
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JPanel inp1 = new JPanel(new GridLayout(5, 2));
        inp1.add(new JLabel("Pokemon Name"));
        JTextField pName = new JTextField(10);
        inp1.add(pName);
        inp1.add(new JLabel("Nickname"));
        JTextField nName = new JTextField(10);
        inp1.add(nName);
        p1.add(inp1);
        add(p1);
        
        // Add to team
        JButton add = new JButton("Add To Team");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int inParty = ((Panel) panel).getTeamSize();
                if (inParty < 6) {
                    inParty++;
                    String num = getDexNum(pName.getText());
                    if (!num.equals("N/A")) {
                        TeamMember t = new TeamMember(num, nName.getText(),
                                inParty);
                        ((Panel) panel).addToTeam(t);
                    }
                }
                pName.setText("");
                nName.setText("");
            }
        });
        inp1.add(add);
        inp1.add(Box.createHorizontalGlue());

        // Remove from team
        JTextField index = new JTextField(5);
        JButton remove = new JButton("Remove From Team");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = index.getText();
                int n = Integer.parseInt(num);
                if (n > 0 && n <= 6) {
                    ((Panel) panel).removeFromTeam(n);
                }
                index.setText("");
            }
        });
        inp1.add(remove);
        inp1.add(index);
        
        //Change in case of mistake
        JButton makeChange = new JButton("Change");
        makeChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPoke = pName.getText();
                String newName = nName.getText();
                String slot = index.getText();
                if (slot != "") {
                    int num = Integer.parseInt(slot);
                    if (num > 0 && num <= ((Panel) panel).getTeamSize()) {
                        newPoke = getDexNum(newPoke);
                        ((Panel) panel).changeMember(num, newPoke, newName);
                    }
                }
                pName.setText("");
                nName.setText("");
                index.setText("");
            }
        });
        inp1.add(makeChange);

        // Frame defaults
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setResizable(true);
        setLocationRelativeTo(null);
    }

    public String getDexNum(String poke) {
        poke = poke.toLowerCase();
        if (dex.contains(poke)) {
            int index = dex.indexOf(poke) + 1;
            return String.format("%03d", index);
        }
        return "N/A";
    }

    public static void main(String[] args) {
        JFrame frame;
        try {
            frame = new TeamDisplay();
            frame.setVisible(true);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
