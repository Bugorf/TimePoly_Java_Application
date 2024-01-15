import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Plateau extends JFrame {

    private int chiffreDé;
    public JLabel DéMsg;
    JLabel tourMsg;
    int tour = 1;
    public Joueur j1;
    DrawShap yellowTriangle;
    public Joueur j2;
    DrawShap pinkSquare;
    public Joueur j3;
    DrawShap blueCircle;
    public Joueur j4;
    DrawShap redCross;

    public JLabel labelJ1;
    public JLabel labelJ2;
    public JLabel labelJ3;
    public JLabel labelJ4;

    public void init() {

        Container cp = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setResizable(false);

        GridBagLayout bagLayout = new GridBagLayout();
        setLayout(bagLayout);

        Avancer avancer = new Avancer();

        initJoueur();
        dessinerCase(cp);
        dessinerCaseJoueurs(cp);
        dessinerCaseDé(cp,avancer);
        dessinerBtnStart(cp,avancer);

        setVisible(true);

    }

    public void dessinerCase(Container cp) {
        for (int i = 1; i < 8; i++) {
            cp.add(createLabel(String.valueOf(i)),constraints(i,0,1,1,1,1));
        }
        for (int i = 1; i < 6; i++) {
            cp.add(createLabel(String.valueOf(i)),constraints(1,i,1,1,1,1));
        }

        for (int i = 1; i < 6; i++) {
            cp.add(createLabel(String.valueOf(i)),constraints(7,i,1,1,1,1));
        }
        for (int i = 1; i < 8; i++) {
            cp.add(createLabel(String.valueOf(i)),constraints(i,6,1,1,1,1));
        }

        DéMsg = createLabel("");
        cp.add(DéMsg,constraints(4,1,1,2,1,1));

        ImageIcon imageIcon = new ImageIcon("./image/wenhao.png");
        JButton chance = new JButton(imageIcon);

        ImageIcon imageIcon2 = new ImageIcon("./image/tresor.png");
        JButton evenement = new JButton(imageIcon2);

        add(chance,constraints(2,2,1,3,0,0));
        add(evenement,constraints(6,2,1,3,0,0));
    }

    public void dessinerCaseJoueurs(Container cp) {
        labelJ1 = createLabel("Joueur 1");
        labelJ1.setOpaque(true);
        labelJ2 = createLabel("Joueur 2");
        labelJ2.setOpaque(true);
        labelJ3 = createLabel("Joueur 3");
        labelJ3.setOpaque(true);
        labelJ4 = createLabel("Joueur 4");
        labelJ4.setOpaque(true);

        cp.add(labelJ1,constraints(8,0,1,1,1,1));
        cp.add(labelJ2,constraints(8,6,1,1,1,1));
        cp.add(labelJ3,constraints(0,0,1,1,1,1));
        cp.add(labelJ4,constraints(0,6,1,1,1,1));

    }

    public void dessinerDé(Container cp) {
        ImageIcon imageIcon = new ImageIcon("./image/d2.png");
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        switch (tour) {
            case 1:
                /*
                cp.add(createLabel("o"),constraints(8,2,1,1,1,1));
                cp.add(createLabel(""),constraints(8,4,1,1,1,1));
                cp.add(createLabel(""),constraints(0,2,1,1,1,1));
                cp.add(createLabel(""),constraints(0,4,1,1,1,1));

                 */
                labelJ1.setBackground(Color.CYAN);
                labelJ2.setBackground(null);
                labelJ3.setBackground(null);
                labelJ4.setBackground(null);
                break;
            case 2:
                labelJ2.setBackground(Color.CYAN);
                labelJ1.setBackground(null);
                labelJ3.setBackground(null);
                labelJ4.setBackground(null);
                /*
                cp.add(createLabel("o"),constraints(8,4,1,1,1,1));
                cp.add(createLabel(""),constraints(8,2,1,1,1,1));
                cp.add(createLabel(""),constraints(0,2,1,1,1,1));
                cp.add(createLabel(""),constraints(0,4,1,1,1,1));

                 */
                break;
            case 3:
                labelJ3.setBackground(Color.CYAN);
                labelJ2.setBackground(null);
                labelJ1.setBackground(null);
                labelJ4.setBackground(null);
                /*
                cp.add(createLabel("o"),constraints(0,2,1,1,1,1));
                cp.add(createLabel(""),constraints(8,4,1,1,1,1));
                cp.add(createLabel(""),constraints(8,2,1,1,1,1));
                cp.add(createLabel(""),constraints(0,4,1,1,1,1));

                 */
                break;
            case 4:
                labelJ4.setBackground(Color.CYAN);
                labelJ2.setBackground(null);
                labelJ3.setBackground(null);
                labelJ1.setBackground(null);
                /*
                cp.add(createLabel("o"),constraints(0,4,1,1,1,1));
                cp.add(createLabel(""),constraints(8,4,1,1,1,1));
                cp.add(createLabel(""),constraints(8,2,1,1,1,1));
                cp.add(createLabel(""),constraints(0,2,1,1,1,1));

                 */
                break;
        }
    }

    public void dessinerBtnStart(Container cp, Avancer avancer) {

        JButton jButton = new JButton("Start");
        cp.add(jButton,constraints(4,5,1,1,1,1));
        jButton.addActionListener(e -> {
            remove(jButton);

            tourMsg = createLabel("");
            afficherTourMsg();
            cp.add(tourMsg,constraints(4,5,1,1,1,1));
            labelJ1.setBackground(Color.CYAN);
            initSymboleJoueur(cp,avancer);
            revalidate();
        });


    }
    public void afficherTourMsg() {
        tourMsg.setText("C'est le tour de joueur " + tour);
    }
    public void dessinerCaseDé(Container cp, Avancer avancer) {
        ImageIcon imageIcon = new ImageIcon("./image/d2.png");
        JButton dé = new JButton(imageIcon);
        dé.setContentAreaFilled(false);
        add(dé, constraints(4, 3, 1, 1, 0, 0));

        dé.addActionListener(e -> {
            De de = new De();
            chiffreDé = de.obtenirChiffre();

            dessinerDé(cp);
            switch (tour) {
                case 1:
                    System.out.println("joueur1 posActuel: " + j1.postionActuel);
                    System.out.println("joueur1 posPrece: " + j1.positionPrecedent);
                    System.out.println("joueur1 dé: " + chiffreDé);
                    avancer.setPositionJoueur(j1,chiffreDé);
                    avancer.deplacerSymbole(cp,j1,yellowTriangle,tour);
                    break;
                case 2:
                    System.out.println("joueur2 posActuel: " + j2.postionActuel);
                    System.out.println("joueur2 posPrece: " + j2.positionPrecedent);
                    System.out.println("joueur2 dé: " + chiffreDé);
                    avancer.setPositionJoueur(j2,chiffreDé);
                    avancer.deplacerSymbole(cp,j2,pinkSquare,tour);
                    break;
                case 3:
                    System.out.println("joueur3 posActuel: " + j3.postionActuel);
                    System.out.println("joueur3 posPrece: " + j3.positionPrecedent);
                    System.out.println("joueur3 dé: " + chiffreDé);
                    avancer.setPositionJoueur(j3,chiffreDé);
                    avancer.deplacerSymbole(cp,j3,blueCircle,tour);
                    break;
                case 4:
                    System.out.println("joueur4 posActuel: " + j4.postionActuel);
                    System.out.println("joueur4 posPrece: " + j4.positionPrecedent);
                    System.out.println("joueur4 dé: " + chiffreDé);
                    avancer.setPositionJoueur(j4,chiffreDé);
                    avancer.deplacerSymbole(cp,j4,redCross,tour);
                    break;
            }



            if (tour < 4) {
                tour += 1;
            } else {
                tour = 1;
            }
            afficherTourMsg();
            DéMsg.setText(String.valueOf(chiffreDé));
        });
    }

    public void initSymboleJoueur(Container cp, Avancer avancer) {

        yellowTriangle = new DrawShap(Color.BLACK);
        yellowTriangle.setPreferredSize(new Dimension(30, 30));

        pinkSquare = new DrawShap(Color.PINK);
        pinkSquare.setPreferredSize(new Dimension(30, 30));

        blueCircle = new DrawShap(Color.BLUE);
        blueCircle.setPreferredSize(new Dimension(30, 30));

        redCross = new DrawShap(Color.RED);
        redCross.setPreferredSize(new Dimension(30, 30));

        avancer.deplacerSymbole(cp,j4,redCross,4);
        avancer.deplacerSymbole(cp,j3,blueCircle,3);
        avancer.deplacerSymbole(cp,j2,pinkSquare,2);
        avancer.deplacerSymbole(cp,j1,yellowTriangle,1);

    }
    public GridBagConstraints constraints(int gridx, int gridy, int gridwidth, int gridheight, int weightx, int weighty) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.weightx = weightx;
        constraints.weighty = weighty;

        return constraints;
    }

    public JLabel createLabel(String texte) {
        JLabel label = new JLabel(texte);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Font customFont = new Font("SansSerif", Font.BOLD, 15);
        label.setFont(customFont);

        return label;
    }


    public void initJoueur() {
        j1 = new Joueur();
        j2 = new Joueur();
        j3 = new Joueur();
        j4 = new Joueur();
    }

}
