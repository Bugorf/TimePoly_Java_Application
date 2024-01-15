import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Chance {
    Map<Integer, String[]> listChance = new HashMap<>();
    public Chance() {
        initListEvenement();

    }
    public int getChance(JButton jl) {
        Random random = new Random();
        int nbRandom = random.nextInt(1,3);

        JLabel label = new JLabel(listChance.get(nbRandom)[0], SwingConstants.CENTER);
        JOptionPane.showMessageDialog(jl, label, "Chance", JOptionPane.PLAIN_MESSAGE);
        return Integer.parseInt(listChance.get(nbRandom)[1]);
    }

    public void initListEvenement() {
        listChance.put(1, new String[] {"Vous avez obtenu une très bonne note, vous obtenez 1 an","1"});
        listChance.put(2, new String[] {"Vous passez beaucoup du temps sur Ins, vous perdez 2 ans","Ins"});
        listChance.put(3, new String[] {"Vous avez validé l'année, vous obtenez un voyage","voyage"});
    }

}
