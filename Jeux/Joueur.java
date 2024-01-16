package Jeux;

import java.util.HashMap;
import java.util.Map;

/**
 * Class pour enregistrer tout les infos de joueurs.
 */
public class Joueur {
    private String playerColor;
    private int playerTime;
    public int tourJeux = 0;
    public boolean suspendu;
    public int postionActuel = 0;
    public int positionPrecedent = 0;
    Map<Integer, Integer> playerCapital = new HashMap<>();

    public Joueur() {
        this.playerTime = 20;

    }

    public int getPlayerTime() {
        return playerTime;
    }

    public void setPlayerTime(int playerTime) {
        this.playerTime = playerTime;
    }

    public void ajouterCapital(int numeroCase, int time) {
        playerCapital.put(numeroCase,time);
    }

    /**
     * Enregistre les capital du joueur
     */
    public Map<Integer, Integer> getPlayerCapital() {
        return playerCapital;
    }

    public void setPostionActuel(int postionActuel) {
        this.postionActuel = postionActuel;
    }
}
