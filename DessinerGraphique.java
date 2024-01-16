import javax.swing.*;
import java.awt.*;

/**
 * Class pour dessiner les graphique comme triangle, cercle, quadrilatère etc
 */
public class DessinerGraphique extends JPanel {
    private Color color;

    public DessinerGraphique(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(color);

        int width = getWidth();
        int height = getHeight();

        /**
         * Dessiner selon le couleur et graphique
         */
        if (color.equals(Color.BLACK)) {
            int[] xPoints = {width / 2, width / 4, 3 * width / 4};
            int[] yPoints = {height / 4, 3 * height / 4, 3 * height / 4};
            g2d.fillPolygon(xPoints, yPoints, 3);
        } else if (color.equals(Color.PINK)) {
            int size = Math.min(width, height) / 2;
            int x = (width - size) / 2;
            int y = (height - size) / 2;
            g2d.fillRect(x, y, size, size);
        } else if (color.equals(Color.CYAN)) {
            int diameter = Math.min(width, height) / 2;
            int x = (width - diameter) / 2;
            int y = (height - diameter) / 2;
            g2d.fillOval(x, y, diameter, diameter);
        } else if (color.equals(Color.RED)) {
            int size = Math.min(width, height) / 2;
            int x = (width - size) / 2;
            int y = (height - size) / 2;

            g2d.setStroke(new BasicStroke(3.0f));
            g2d.drawLine(x, y, x + size, y + size);
            g2d.drawLine(x + size, y, x, y + size);
        }
    }

}
