package Jeux;

import java.util.Random;

/**
 * Class pour traiter les evenement concernant le lancement du dé.
 */
public class De {
    public int obtenirChiffre() {
        Random random = new Random();
        return random.nextInt(1,6);

    }
}
