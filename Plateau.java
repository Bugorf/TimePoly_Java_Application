import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Plateau extends JFrame {

    private int chiffreDé;

    private int[] positionPlayer = {
            1111,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0};

    public void init() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setResizable(false);
        setVisible(true);

        GridBagLayout bagLayout = new GridBagLayout();
        setLayout(bagLayout);

        for (int i = 1; i < 11; i++) {
            add(createLabel(String.valueOf(i)),constraints(i,0,1,1,1,1));
        }
        for (int i = 1; i < 10; i++) {
            add(createLabel(String.valueOf(i)),constraints(1,i,1,1,1,1));
        }

        for (int i = 1; i < 10; i++) {
            add(createLabel(String.valueOf(i)),constraints(10,i,1,1,1,1));
        }
        for (int i = 1; i < 11; i++) {
            add(createLabel(String.valueOf(i)),constraints(i,10,1,1,1,1));
        }
        add(createLabel("chance"),constraints(4,1,3,2,0,0));

        JButton dé = new JButton("Dé");
        dé.setContentAreaFilled(false);

        DrawShap yellowTriangle = new DrawShap(Color.YELLOW);
        DrawShap pinkSquare = new DrawShap(Color.PINK);
        DrawShap blueCircle = new DrawShap(Color.BLUE);
        DrawShap redCross = new DrawShap(Color.RED);

        JPanel jp = new JPanel(new GridLayout());
        jp.add(redCross);
        jp.add(yellowTriangle);
        jp.add(pinkSquare);
        jp.add(blueCircle);

        dé.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                De de = new De();
                chiffreDé = de.obtenirChiffre();
                dé.setText(String.valueOf(chiffreDé));


                add(jp,constraints(setPositionPlayer()[0],setPositionPlayer()[1],1,1,0,0));
            }
        });

        add(dé,constraints(2,3,8,5,0,0));

        add(createLabel("evenement"),constraints(4,8,3,2,0,0));


        add(createLabel("p1"),constraints(11,0,1,1,1,1));
        add(createLabel("p1info"),constraints(11,1,1,1,1,1));

        add(createLabel("p2"),constraints(11,10,1,1,1,1));
        add(createLabel("p2info"),constraints(11,9,1,1,1,1));

        add(createLabel("p3"),constraints(0,0,1,1,1,1));
        add(createLabel("p3info"),constraints(0,1,1,1,1,1));

        add(createLabel("p4"),constraints(0,10,1,1,1,1));
        add(createLabel("p4info"),constraints(0,9,1,1,1,1));

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
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        return label;
    }

    public ArrayList<Integer> getPositionPlayer() {
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < positionPlayer.length; i++) {
            if (positionPlayer[i] != 0) {
                pos.add(i);
                }
            }
        return pos;
    }

    public int[] setPositionPlayer() {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<int[]> al = new ArrayList<>();

        Map<Integer, int[]> posMap = new HashMap<>();
        pos = getPositionPlayer();

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                for (int j = 10; j >= 0; j--) {
                    al.add(new int[]{j,10});
                }
            } else if (i == 1) {
                for (int j = 9; j >= 0; j--) {
                    al.add(new int[]{0,j});
                }
            } else if (i == 2) {
                for (int j = 1; j < 11; j++) {
                    al.add(new int[]{j,0});
                }
            } else {
                for (int j = 1; j < 10; j++) {
                    al.add(new int[]{10,j});
                }
            }

        }

        for (int i = 0; i < 40; i++) {
            posMap.put(i,al.get(i));
        }

        for (int i:pos) {
            return posMap.get(i);
        }
        return new int[0];
    }

}
