
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class PageAccueil extends JFrame {

    public PageAccueil() {
        Container cp = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setResizable(false);
        setTitle("TimePoly");

        GridBagLayout bagLayout = new GridBagLayout();
        setLayout(bagLayout);

        initPlateau();
        setVisible(true);

    }

    public void initPlateau() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon("./image/TimePoly.png");
        JLabel imageLabel = new JLabel(imageIcon);
        mainPanel.add(imageLabel, BorderLayout.NORTH);

        ImageIcon imageIcon2 = new ImageIcon("./image/entrer.png");
        JButton entrer  = new JButton(imageIcon2);
        entrer.setContentAreaFilled(false);
        entrer.setBorder(null);
        mainPanel.add(entrer, BorderLayout.SOUTH);

        entrer.addActionListener(e->{
            Plateau plateau = new Plateau();
            plateau.init();
        });

        getContentPane().add(mainPanel);
    }

}
