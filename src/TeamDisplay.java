import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import helper.AutocompleteJComboBox;
import helper.StringSearchable;

@SuppressWarnings("serial")
public class TeamDisplay extends JFrame {
    private JPanel panel;
    private List<String> dex = Arrays.asList("bulbasaur", "ivysaur",
            "venusaur", "charmander", "charmeleon", "charizard", "squirtle",
            "wartortle", "blastoise", "caterpie", "metapod", "butterfree",
            "weedle", "kakuna", "beedrill", "pidgey", "pidgeotto", "pidgeot",
            "rattata", "raticate", "spearow", "fearow", "ekans", "arbok",
            "pikachu", "raichu", "sandshrew", "sandslash", "nidoranf",
            "nidorina", "nidoqueen", "nidoranm", "nidorino", "nidoking",
            "clefairy", "clefable", "vulpix", "ninetales", "jigglypuff",
            "wigglytuff", "zubat", "golbat", "oddish", "gloom", "vileplume",
            "paras", "parasect", "venonat", "venomoth", "diglett", "dugtrio",
            "meowth", "persian", "psyduck", "golduck", "mankey", "primeape",
            "growlithe", "arcanine", "poliwag", "poliwhirl", "poliwrath",
            "abra", "kadabra", "alakazam", "machop", "machoke", "machamp",
            "bellsprout", "weepinbell", "victreebel", "tentacool",
            "tentacruel", "geodude", "graveler", "golem", "ponyta", "rapidash",
            "slowpoke", "slowbro", "magnemite", "magneton", "farfetch’d",
            "doduo", "dodrio", "seel", "dewgong", "grimer", "muk", "shellder",
            "cloyster", "gastly", "haunter", "gengar", "onix", "drowzee",
            "hypno", "krabby", "kingler", "voltorb", "electrode", "exeggcute",
            "exeggutor", "cubone", "marowak", "hitmonlee", "hitmonchan",
            "lickitung", "koffing", "weezing", "rhyhorn", "rhydon", "chansey",
            "tangela", "kangaskhan", "horsea", "seadra", "goldeen", "seaking",
            "staryu", "starmie", "mr. mime", "scyther", "jynx", "electabuzz",
            "magmar", "pinsir", "tauros", "magikarp", "gyarados", "lapras",
            "ditto", "eevee", "vaporeon", "jolteon", "flareon", "porygon",
            "omanyte", "omastar", "kabuto", "kabutops", "aerodactyl",
            "snorlax", "articuno", "zapdos", "moltres", "dratini", "dragonair",
            "dragonite", "mewtwo", "mew", "chikorita", "bayleef", "meganium",
            "cyndaquil", "quilava", "typhlosion", "totodile", "croconaw",
            "feraligatr", "sentret", "furret", "hoothoot", "noctowl", "ledyba",
            "ledian", "spinarak", "ariados", "crobat", "chinchou", "lanturn",
            "pichu", "cleffa", "igglybuff", "togepi", "togetic", "natu",
            "xatu", "mareep", "flaaffy", "ampharos", "bellossom", "marill",
            "azumarill", "sudowoodo", "politoed", "hoppip", "skiploom",
            "jumpluff", "aipom", "sunkern", "sunflora", "yanma", "wooper",
            "quagsire", "espeon", "umbreon", "murkrow", "slowking",
            "misdreavus", "unown", "wobbuffet", "girafarig", "pineco",
            "forretress", "dunsparce", "gligar", "steelix", "snubbull",
            "granbull", "qwilfish", "scizor", "shuckle", "heracross",
            "sneasel", "teddiursa", "ursaring", "slugma", "magcargo", "swinub",
            "piloswine", "corsola", "remoraid", "octillery", "delibird",
            "mantine", "skarmory", "houndour", "houndoom", "kingdra", "phanpy",
            "donphan", "porygon2", "stantler", "smeargle", "tyrogue",
            "hitmontop", "smoochum", "elekid", "magby", "miltank", "blissey",
            "raikou", "entei", "suicune", "larvitar", "pupitar", "tyranitar",
            "lugia", "ho-oh", "celebi", "treecko", "grovyle", "sceptile",
            "torchic", "combusken", "blaziken", "mudkip", "marshtomp",
            "swampert", "poochyena", "mightyena", "zigzagoon", "linoone",
            "wurmple", "silcoon", "beautifly", "cascoon", "dustox", "lotad",
            "lombre", "ludicolo", "seedot", "nuzleaf", "shiftry", "taillow",
            "swellow", "wingull", "pelipper", "ralts", "kirlia", "gardevoir",
            "surskit", "masquerain", "shroomish", "breloom", "slakoth",
            "vigoroth", "slaking", "nincada", "ninjask", "shedinja", "whismur",
            "loudred", "exploud", "makuhita", "hariyama", "azurill",
            "nosepass", "skitty", "delcatty", "sableye", "mawile", "aron",
            "lairon", "aggron", "meditite", "medicham", "electrike",
            "manectric", "plusle", "minun", "volbeat", "illumise", "roselia",
            "gulpin", "swalot", "carvanha", "sharpedo", "wailmer", "wailord",
            "numel", "camerupt", "torkoal", "spoink", "grumpig", "spinda",
            "trapinch", "vibrava", "flygon", "cacnea", "cacturne", "swablu",
            "altaria", "zangoose", "seviper", "lunatone", "solrock",
            "barboach", "whiscash", "corphish", "crawdaunt", "baltoy",
            "claydol", "lileep", "cradily", "anorith", "armaldo", "feebas",
            "milotic", "castform", "kecleon", "shuppet", "banette", "duskull",
            "dusclops", "tropius", "chimecho", "absol", "wynaut", "snorunt",
            "glalie", "spheal", "sealeo", "walrein", "clamperl", "huntail",
            "gorebyss", "relicanth", "luvdisc", "bagon", "shelgon",
            "salamence", "beldum", "metang", "metagross", "regirock", "regice",
            "registeel", "latias", "latios", "kyogre", "groudon", "rayquaza",
            "jirachi", "deoxys", "turtwig", "grotle", "torterra", "chimchar",
            "monferno", "infernape", "piplup", "prinplup", "empoleon",
            "starly", "staravia", "staraptor", "bidoof", "bibarel",
            "kricketot", "kricketune", "shinx", "luxio", "luxray", "budew",
            "roserade", "cranidos", "rampardos", "shieldon", "bastiodon",
            "burmy", "wormadam", "mothim", "combee", "vespiquen", "pachirisu",
            "buizel", "floatzel", "cherubi", "cherrim", "shellos", "gastrodon",
            "ambipom", "drifloon", "drifblim", "buneary", "lopunny",
            "mismagius", "honchkrow", "glameow", "purugly", "chingling",
            "stunky", "skuntank", "bronzor", "bronzong", "bonsly", "mime jr.",
            "happiny", "chatot", "spiritomb", "gible", "gabite", "garchomp",
            "munchlax", "riolu", "lucario", "hippopotas", "hippowdon",
            "skorupi", "drapion", "croagunk", "toxicroak", "carnivine",
            "finneon", "lumineon", "mantyke", "snover", "abomasnow", "weavile",
            "magnezone", "lickilicky", "rhyperior", "tangrowth", "electivire",
            "magmortar", "togekiss", "yanmega", "leafeon", "glaceon",
            "gliscor", "mamoswine", "porygon-z", "gallade", "probopass",
            "dusknoir", "froslass", "rotom", "uxie", "mesprit", "azelf",
            "dialga", "palkia", "heatran", "regigigas", "giratina",
            "cresselia", "phione", "manaphy", "darkrai", "shaymin", "arceus",
            "victini", "snivy", "servine", "serperior", "tepig", "pignite",
            "emboar", "oshawott", "dewott", "samurott", "patrat", "watchog",
            "lillipup", "herdier", "stoutland", "purrloin", "liepard",
            "pansage", "simisage", "pansear", "simisear", "panpour",
            "simipour", "munna", "musharna", "pidove", "tranquill", "unfezant",
            "blitzle", "zebstrika", "roggenrola", "boldore", "gigalith",
            "woobat", "swoobat", "drilbur", "excadrill", "audino", "timburr",
            "gurdurr", "conkeldurr", "tympole", "palpitoad", "seismitoad",
            "throh", "sawk", "sewaddle", "swadloon", "leavanny", "venipede",
            "whirlipede", "scolipede", "cottonee", "whimsicott", "petilil",
            "lilligant", "basculin", "sandile", "krokorok", "krookodile",
            "darumaka", "darmanitan", "maractus", "dwebble", "crustle",
            "scraggy", "scrafty", "sigilyph", "yamask", "cofagrigus",
            "tirtouga", "carracosta", "archen", "archeops", "trubbish",
            "garbodor", "zorua", "zoroark", "minccino", "cinccino", "gothita",
            "gothorita", "gothitelle", "solosis", "duosion", "reuniclus",
            "ducklett", "swanna", "vanillite", "vanillish", "vanilluxe",
            "deerling", "sawsbuck", "emolga", "karrablast", "escavalier",
            "foongus", "amoonguss", "frillish", "jellicent", "alomomola",
            "joltik", "galvantula", "ferroseed", "ferrothorn", "klink",
            "klang", "klinklang", "tynamo", "eelektrik", "eelektross",
            "elgyem", "beheeyem", "litwick", "lampent", "chandelure", "axew",
            "fraxure", "haxorus", "cubchoo", "beartic", "cryogonal", "shelmet",
            "accelgor", "stunfisk", "mienfoo", "mienshao", "druddigon",
            "golett", "golurk", "pawniard", "bisharp", "bouffalant", "rufflet",
            "braviary", "vullaby", "mandibuzz", "heatmor", "durant", "deino",
            "zweilous", "hydreigon", "larvesta", "volcarona", "cobalion",
            "terrakion", "virizion", "tornadus", "thundurus", "reshiram",
            "zekrom", "landorus", "kyurem", "keldeo", "meloetta", "genesect");

    public TeamDisplay() {
        super("Team Display");

        panel = new Panel();
        setLayout(new GridLayout(2, 1));
        add(panel);

        // Underneath
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JPanel inp1 = new JPanel(new GridLayout(5, 2));
        
        // Pokemon
        inp1.add(new JLabel("Pokemon Name"));
        StringSearchable searchable = new StringSearchable(dex);
        AutocompleteJComboBox pName = new AutocompleteJComboBox(searchable);
        inp1.add(pName);
        
        // Nickname
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
                        String name = nName.getText();
                        if (name.isEmpty())
                            name = pName.getText().substring(0, 1).toUpperCase() + pName.getText().substring(1);
                        TeamMember t = new TeamMember(num, name, inParty);
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
                if (n > 0 && n <= 6)
                    ((Panel) panel).removeFromTeam(n);
                index.setText("");
            }
        });
        inp1.add(remove);
        inp1.add(index);

        // Change in case of mistake
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
        setSize(1280, 720);
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
        JFrame frame = new TeamDisplay();
        frame.setVisible(true);
    }
}
