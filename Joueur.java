import java.util.HashMap;
import java.util.Map;

public class Joueur {
    private String playerColor;
    private int playerTime;

    public int postionActuel = 0;
    public int positionPrecedent = 0;
    Map<Integer, Integer> playerCapital = new HashMap<>();

    public Joueur() {
        this.playerTime = 0;

    }

    public int getPlayerTime() {
        return playerTime;
    }

    public void setPlayerTime(int playerTime) {
        this.playerTime = playerTime;
    }

    public void AjouterCapital(int numeroCase, int time) {
        playerCapital.put(numeroCase,time);
    }

    public Map<Integer, Integer> getPlayerCapital() {
        return playerCapital;
    }

    public void setPostionActuel(int postionActuel) {
        this.postionActuel = postionActuel;
    }
}
