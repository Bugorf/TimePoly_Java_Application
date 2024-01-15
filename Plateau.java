import javax.swing.*;
import java.awt.*;

public class Plateau extends JFrame {

    public Plateau() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setResizable(false);
        setVisible(true);

        GridBagLayout bagLayout = new GridBagLayout();
        setLayout(bagLayout);

        for (int i = 0; i < 11; i++) {
            add(createLabel(String.valueOf(i)),constraints(i,0,1,1,1,1));
        }
        for (int i = 1; i < 10; i++) {
            add(createLabel(String.valueOf(i)),constraints(0,i,1,1,1,1));
        }

        for (int i = 1; i < 10; i++) {
            add(createLabel(String.valueOf(i)),constraints(10,i,1,1,1,1));
        }
        for (int i = 0; i < 11; i++) {
            add(createLabel(String.valueOf(i)),constraints(i,10,1,1,1,1));
        }
        add(createLabel("chance"),constraints(4,1,3,2,0,0));
        add(createLabel("TimePoly"),constraints(1,3,9,5,0,0));
        add(createLabel("evenement"),constraints(4,8,3,2,0,0));


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

    public static void main(String[] args) {
        new Plateau();
    }
}
