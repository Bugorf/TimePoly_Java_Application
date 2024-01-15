import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Avancer {
    Map<Integer, int[]> posMap = new HashMap<>();

    public Avancer() {
        initPosMap();
    }

    public void initPosMap() {
        ArrayList<int[]> al = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                for (int j = 7; j >= 1; j--) {
                    al.add(new int[]{j,6});
                }
            } else if (i == 1) {
                for (int j = 5; j >= 0; j--) {
                    al.add(new int[]{1,j});
                }
            } else if (i == 2) {
                for (int j = 2; j < 8; j++) {
                    al.add(new int[]{j,0});
                }
            } else {
                for (int j = 1; j < 6; j++) {
                    al.add(new int[]{7,j});
                }
            }
        }

        for (int i = 0; i < 24; i++) {
            posMap.put(i,al.get(i));
        }
    }
    public int[] getPositionJoueur(Joueur joueur) {
        int pos = joueur.postionActuel;
        return posMap.get(pos);
    }

    public void setPositionJoueur(Joueur joueur, int pas) {
        System.out.println(joueur.postionActuel);
        if (joueur.postionActuel + pas <= 23) {
            joueur.positionPrecedent = joueur.postionActuel;
            joueur.postionActuel += pas;
        } else {
            joueur.positionPrecedent = joueur.postionActuel;
            joueur.postionActuel = joueur.postionActuel + pas - 23;
            joueur.tourJeux += 1;
            joueur.setPlayerTime(joueur.getPlayerTime() + 10);
        }
        System.out.println(joueur.postionActuel);
    }

    public void deplacerSymbole(Container cp, Joueur joueur, DrawShap symbole, int tour) {
        int[] pos = getPositionJoueur(joueur);
        GridBagConstraints c = new GridBagConstraints();
        switch (tour) {
            case 1:
                c.anchor = GridBagConstraints.NORTHEAST;
                break;
            case 2:
                c.anchor = GridBagConstraints.SOUTHWEST;
                break;
            case 3:
                c.anchor = GridBagConstraints.SOUTHEAST;
                break;
            case 4:
                c.anchor = GridBagConstraints.NORTHWEST;
                break;
        }
        c.gridx = pos[0];
        c.gridy = pos[1];
        c.gridheight = 1;
        c.gridwidth = 1;
        cp.add(symbole, c);

    }

}
