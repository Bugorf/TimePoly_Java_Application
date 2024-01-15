import java.util.HashMap;
import java.util.Map;

public class Joueur {
    private String playerColor;
    private int playerTime;

    public int postionActuel;
    Map<Integer, Integer> playerCapital = new HashMap<>();

    public Joueur(String playerColor, int playerTime) {
        this.playerTime = playerTime;
        this.playerColor = playerColor;

    }

    public int getPlayerTime() {
        return playerTime;
    }

    public String getPlayerColor() {
        return playerColor;
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
