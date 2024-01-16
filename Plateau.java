import Jeux.De;
import Jeux.Joueur;
import SpecialeCase.Chance;
import SpecialeCase.Tresor;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Plateau extends JFrame {

    private int chiffreDé;
    public JLabel DéMsg;
    JLabel tourMsg;
    int tour = 1;
    public Joueur j1;
    DessinerGraphique yellowTriangle;
    public Joueur j2;
    DessinerGraphique pinkSquare;
    public Joueur j3;
    DessinerGraphique blueCircle;
    public Joueur j4;
    DessinerGraphique redCross;

    public JLabel labelJ1;
    public JLabel labelJ2;
    public JLabel labelJ3;
    public JLabel labelJ4;

    public JLabel TimelabelJ1;
    public JLabel TimelabelJ2;
    public JLabel TimelabelJ3;
    public JLabel TimelabelJ4;

    public JButton dé;

    public void init() {

        Container cp = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setResizable(false);
        setTitle("TimePoly");

        GridBagLayout bagLayout = new GridBagLayout();
        setLayout(bagLayout);

        Deplacement deplacement = new Deplacement();

        ImageIcon imageIcon = new ImageIcon("./image/Bienvenu.png");
        JLabel imageLabel = new JLabel(imageIcon);
        add(imageLabel, constraints(2,1,5,3,1,1));

        dessinerCase(cp);
        dessinerBtnStart(cp, deplacement, imageLabel);
        setVisible(true);

    }
    public void dessinerBtnStart(Container cp, Deplacement deplacement, JLabel bienvenue) {

        JButton jButton = new JButton("Start");
        cp.add(jButton,constraints(4,5,1,1,1,1));
        jButton.addActionListener(e -> {
            remove(jButton);
            remove(bienvenue);
            tourMsg = createLabel("");
            afficherTourMsg();
            cp.add(tourMsg,constraints(4,5,1,1,1,1));

            initJoueur();
            dessinerCaseJoueurs(cp);
            dessinerCaseDé(cp, deplacement);
            dessinerBtnCotés();
            dessinerChanceCase();
            dessinerTresorCase();
            dessinerDéResultatCase();

            labelJ1.setBackground(Color.YELLOW);
            initSymboleJoueur(cp, deplacement);
            revalidate();
        });


    }
    public void dessinerChanceCase() {
        ImageIcon imageIcon = new ImageIcon("./image/wenhao.png");
        JButton chance = new JButton(imageIcon);

        chance.addActionListener(e ->{
            new Chance().getChance(dé);
        });

        add(chance,constraints(2,2,1,3,0,0));
    }
    public void dessinerTresorCase() {
        ImageIcon imageIcon2 = new ImageIcon("./image/tresor.png");
        JButton evenement = new JButton(imageIcon2);

        evenement.addActionListener(e ->{
            new Tresor().getTresor(dé);
        });


        add(evenement,constraints(6,2,1,3,0,0));
    }
    public void dessinerBtnCotés() {
        JButton recommence = new JButton("Recommencer");
        JButton quitte = new JButton("Quitter");
        add(recommence,constraints(0,3,1,1,0,0));
        add(quitte,constraints(8,3,1,1,0,0));
        recommence.addActionListener(e -> {
            j1.setPlayerTime(0);
            j2.setPlayerTime(0);
            j3.setPlayerTime(0);
            j4.setPlayerTime(0);

            j1.postionActuel = 0;
            j2.postionActuel = 0;
            j3.postionActuel = 0;
            j4.postionActuel = 0;

            tour = 1;
            revalidate();
            repaint();
        });

        quitte.addActionListener(e -> {
            System.exit(0);
        });
    }
    public void dessinerDéResultatCase() {
        DéMsg = createLabel("");
        Font customFont = new Font("MonoSerif", Font.BOLD, 70);
        DéMsg.setFont(customFont);
        add(DéMsg,constraints(4,1,1,2,1,1));

    }
    public void dessinerCase(Container cp) {
        Deplacement deplacement = new Deplacement();
        deplacement.initPosMap();
        for (int i = 0; i < 24; i++) {
            if (i == 0) {
                createImageLabel(cp, deplacement.posMap.get(i),"./image/go.png");
            } else if (i == 6) {
                createImageLabel(cp, deplacement.posMap.get(i),"./image/sun1.png");
            } else if (i == 12) {
                createImageLabel(cp, deplacement.posMap.get(i),"./image/sun2.png");
            } else if ( i == 18) {
                createImageLabel(cp, deplacement.posMap.get(i),"./image/ins.png");
            } else if (i == 2 || i == 8 || i == 14 || i == 20) {
                createImageLabel(cp, deplacement.posMap.get(i),"./image/tresorCase.png");
            } else if (i == 4 || i == 10 || i == 16 || i == 22) {
                createImageLabel(cp, deplacement.posMap.get(i),"./image/wenhaoCase.png");
            } else if (i == 1 || i == 5 || i == 7 || i == 11 || i == 13 || i == 19 || i == 17 || i == 23 || i == 3 || i == 9 || i == 15 || i == 21 )  {
                createImageLabel(cp, deplacement.posMap.get(i),"./image/house.png");
            }

        }
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

    /**
     * Méthode pour mettre en oeuvre le changement du couleur des joueurs selon l'ordre
     */
    public void ordreCouleur(Container cp) {
        switch (tour) {
            case 1:
                labelJ1.setBackground(Color.YELLOW);
                labelJ2.setBackground(null);
                labelJ3.setBackground(null);
                labelJ4.setBackground(null);
                break;
            case 2:
                labelJ2.setBackground(Color.PINK);
                labelJ1.setBackground(null);
                labelJ3.setBackground(null);
                labelJ4.setBackground(null);
                break;
            case 3:
                labelJ3.setBackground(Color.CYAN);
                labelJ2.setBackground(null);
                labelJ1.setBackground(null);
                labelJ4.setBackground(null);
                break;
            case 4:
                labelJ4.setBackground(Color.RED);
                labelJ2.setBackground(null);
                labelJ3.setBackground(null);
                labelJ1.setBackground(null);
                break;
        }
    }

    public void afficherTourMsg() {
        tourMsg.setText("C'est le tour de joueur " + tour);
    }
    public void dessinerCaseDé(Container cp, Deplacement deplacement) {
        ImageIcon imageIcon = new ImageIcon("./image/d2.png");
        dé = new JButton(imageIcon);
        dé.setContentAreaFilled(false);
        add(dé, constraints(4, 3, 1, 1, 0, 0));

        dé.addActionListener(e -> {
            De de = new De();
            chiffreDé = de.obtenirChiffre();

            DéMsg.setText(String.valueOf(chiffreDé));
            switch (tour) {
                case 1:
                    if (j1.suspendu || j1.getPlayerTime() < 0) {
                        JOptionPane.showMessageDialog(dé, "Jeux.Joueur 1: Vous etre déjà mort ou en suspendu, veillez passez au prochain joueur", "Attention", JOptionPane.WARNING_MESSAGE);
                        j1.suspendu = false;
                    } else {
                        System.out.println("joueur1 posActuel: " + j1.postionActuel);
                        System.out.println("joueur1 posPrece: " + j1.positionPrecedent);
                        System.out.println("joueur1 dé: " + chiffreDé);
                        deplacement.setPositionJoueur(j1,chiffreDé);
                        deplacement.deplacerSymbole(cp,j1,yellowTriangle,tour);
                        verifierCase(j1);
                    }

                    break;
                case 2:
                    if (j2.suspendu || j2.getPlayerTime() < 0) {
                        JOptionPane.showMessageDialog(dé, "Jeux.Joueur 2: Vous etre déjà mort, veillez passez au prochain joueur", "Attention", JOptionPane.WARNING_MESSAGE);
                        j2.suspendu = false;
                    } else {
                        System.out.println("joueur2 posActuel: " + j2.postionActuel);
                        System.out.println("joueur2 posPrece: " + j2.positionPrecedent);
                        System.out.println("joueur2 dé: " + chiffreDé);
                        deplacement.setPositionJoueur(j2,chiffreDé);
                        deplacement.deplacerSymbole(cp,j2,pinkSquare,tour);
                        verifierCase(j2);
                    }

                    break;
                case 3:
                    if (j3.suspendu || j3.getPlayerTime() < 0) {
                        JOptionPane.showMessageDialog(dé, "Jeux.Joueur 3: Vous etre déjà mort, veillez passez au prochain joueur", "Attention", JOptionPane.WARNING_MESSAGE);tourMsg.setText("Jeux.Joueur 3: Vous etre déjà mort, veillez passez au prochain joueur");
                        j3.suspendu = false;
                    } else {
                        System.out.println("joueur3 posActuel: " + j3.postionActuel);
                        System.out.println("joueur3 posPrece: " + j3.positionPrecedent);
                        System.out.println("joueur3 dé: " + chiffreDé);
                        deplacement.setPositionJoueur(j3,chiffreDé);
                        deplacement.deplacerSymbole(cp,j3,blueCircle,tour);
                        verifierCase(j3);

                    }
                    break;
                case 4:
                    if (j4.suspendu || j4.getPlayerTime() < 0) {
                        JOptionPane.showMessageDialog(dé, "Jeux.Joueur 4: Vous etre déjà mort, veillez passez au prochain joueur", "Attention", JOptionPane.WARNING_MESSAGE);
                        j4.suspendu = false;
                    } else {
                        System.out.println("joueur4 posActuel: " + j4.postionActuel);
                        System.out.println("joueur4 posPrece: " + j4.positionPrecedent);
                        System.out.println("joueur4 dé: " + chiffreDé);
                        deplacement.setPositionJoueur(j4,chiffreDé);
                        deplacement.deplacerSymbole(cp,j4,redCross,tour);
                        verifierCase(j4);

                    }
                    break;
            }



            if (tour < 4) {
                tour += 1;
            } else {
                tour = 1;
            }
            afficherTourMsg();
            ordreCouleur(cp);
        });
    }
    public void verifierCase(Joueur joueur) {
        int i = joueur.postionActuel;

        if (joueur.postionActuel == 6 || joueur.postionActuel == 12 || joueur.postionActuel == 18) {
            joueur.suspendu = true;
        } else if (joueur.postionActuel == 0) {
            joueur.setPlayerTime(joueur.getPlayerTime() + new Tresor().getTresor(dé));
            actualiserTime(joueur);
        } else if (i == 2 || i == 8 || i == 14 || i == 20) {
            joueur.setPlayerTime(joueur.getPlayerTime() + new Tresor().getTresor(dé));
            actualiserTime(joueur);
        } else if (i == 4 || i == 10 || i == 16 || i == 22) {
            joueur.setPlayerTime(joueur.getPlayerTime() + Integer.parseInt(new Chance().getChance(dé)));
            actualiserTime(joueur);
        } else if (i == 1 || i == 5 || i == 7 || i == 11 || i == 13 || i == 19 || i == 17 || i == 23 || i == 3 || i == 9 || i == 15 || i == 21 )  {
            acheter(joueur);
        }
    }

    public void actualiserTime(Joueur joueur){
        switch (tour) {
            case 1:
                TimelabelJ1.setText("Time: " + joueur.getPlayerTime());
                break;
            case 2:
                TimelabelJ2.setText("Time: " + joueur.getPlayerTime());
                break;
            case 3:
                TimelabelJ3.setText("Time: " + joueur.getPlayerTime());
                break;
            case 4:
                TimelabelJ4.setText("Time: " + joueur.getPlayerTime());
                break;
        }

    }

    public void acheter(Joueur joueur) {
        ImageIcon customIcon = new ImageIcon("./image/house.png");
        int prix = new Random().nextInt(1,5);
        Object[] options = {"Oui", "Non"};
        int result = JOptionPane.showOptionDialog(
                dé,
                "Prix : " + prix + "\nVous voulez acheter cet appartement ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                options,
                options[0]
        );

        if (result == JOptionPane.YES_OPTION) {
            if (joueur.getPlayerTime() < prix){
                JOptionPane.showMessageDialog(dé, "Votre Time est insuffisant", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {
                joueur.ajouterCapital(joueur.postionActuel,prix);
            }
        }
    }
    public void initSymboleJoueur(Container cp, Deplacement deplacement) {

        yellowTriangle = new DessinerGraphique(Color.BLACK);
        yellowTriangle.setPreferredSize(new Dimension(30, 30));

        pinkSquare = new DessinerGraphique(Color.PINK);
        pinkSquare.setPreferredSize(new Dimension(30, 30));

        blueCircle = new DessinerGraphique(Color.CYAN);
        blueCircle.setPreferredSize(new Dimension(30, 30));

        redCross = new DessinerGraphique(Color.RED);
        redCross.setPreferredSize(new Dimension(30, 30));

        deplacement.deplacerSymbole(cp,j4,redCross,4);
        deplacement.deplacerSymbole(cp,j3,blueCircle,3);
        deplacement.deplacerSymbole(cp,j2,pinkSquare,2);
        deplacement.deplacerSymbole(cp,j1,yellowTriangle,1);

        initTimeLabel(cp);
    }
    public void initTimeLabel(Container cp) {
        TimelabelJ1 = createLabel("Time : " + j1.getPlayerTime());
        TimelabelJ2 = createLabel("Time : " + j2.getPlayerTime());
        TimelabelJ3 = createLabel("Time : " + j3.getPlayerTime());
        TimelabelJ4 = createLabel("Time : " + j4.getPlayerTime());

        cp.add(TimelabelJ1,constraints(8,1,1,1,1,1));
        cp.add(TimelabelJ2,constraints(8,5,1,1,1,1));
        cp.add(TimelabelJ3,constraints(0,1,1,1,1,1));
        cp.add(TimelabelJ4,constraints(0,5,1,1,1,1));
    }
    public void initJoueur() {
        j1 = new Joueur();
        j2 = new Joueur();
        j3 = new Joueur();
        j4 = new Joueur();
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

        Font customFont = new Font("SansSerif", Font.BOLD, 15);
        label.setFont(customFont);
        return label;
    }

    /**
     * Class pour créer des label avec image
     */
    public void createImageLabel(Container cp, int[] pos, String path) {
        ImageIcon imageIcon = new ImageIcon(path);
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setBackground(Color.WHITE);
        jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        cp.add(jLabel,constraints(pos[0],pos[1],1,1,1,1));
    }



}
