package SpecialeCase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *  Class pour traiter l'événement concernant la carte Chance
 */
public class Chance {

    /**
     * Dictionnaire pour enregistrer tous les chance
     */
    Map<Integer, String[]> listChance = new HashMap<>();
    public Chance() {
        initListEvenement();

    }
    public String getChance(JButton jl) {
        Random random = new Random();
        int nbRandom = random.nextInt(1,3);

        JLabel label = new JLabel(listChance.get(nbRandom)[0], SwingConstants.CENTER);
        JOptionPane.showMessageDialog(jl, label, "SpecialeCase.Chance", JOptionPane.PLAIN_MESSAGE);
        return listChance.get(nbRandom)[1];
    }

    public void initListEvenement() {
        listChance.put(1, new String[] {"Vous avez obtenu une très bonne note, vous obtenez 1 an","1"});
        listChance.put(2, new String[] {"Vous passez beaucoup du temps sur Ins, vous perdez 2 ans","-2"});
        listChance.put(3, new String[] {"Vous avez validé l'année, vous obtenez 5 ans","5"});
    }

}
