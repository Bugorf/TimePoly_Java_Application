package SpecialeCase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *  Class pour traiter l'événement concernant la carte trésor
 */
public class Tresor {

    /**
     * Dictionnaire pour enregistrer tous les trésor
     */
    Map<Integer, String[]> listTresor = new HashMap<>();

    public Tresor() {
        initListEvenement();
    }

    /**
     * Obtenir le Time par rapport au chance
     */
    public int getTresor(JButton jl) {
        Random random = new Random();
        int nbRandom = random.nextInt(1,2);

        JLabel label = new JLabel(listTresor.get(nbRandom)[0], SwingConstants.CENTER);
        JOptionPane.showMessageDialog(jl, label, "SpecialeCase.Tresor", JOptionPane.PLAIN_MESSAGE);
        return Integer.parseInt(listTresor.get(nbRandom)[1]);
    }

    /**
     * Initialiser la liste
     */
    public void initListEvenement() {
        listTresor.put(1, new String[] {"Vous avez réussi de faire projet, vous obtenez 1 an","1"});
        listTresor.put(2, new String[] {"Vous avez oublié PHP, vous perdez 3 ans","-3"});
    }

}
