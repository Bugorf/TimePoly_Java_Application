import javax.swing.*;
import java.awt.*;

public class DrawShap extends JPanel {

    private Color color;

    public DrawShap(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 将 Graphics 转换为 Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // 设置绘制颜色
        g2d.setColor(color);

        int width = getWidth();
        int height = getHeight();

        // 根据颜色和形状参数绘制不同的图形
        if (color.equals(Color.BLACK)) {
            // 绘制黄色的三角形
            int[] xPoints = {width / 2, width / 4, 3 * width / 4};
            int[] yPoints = {height / 4, 3 * height / 4, 3 * height / 4};
            g2d.fillPolygon(xPoints, yPoints, 3);
        } else if (color.equals(Color.PINK)) {
            // 绘制紫色的正方形
            int size = Math.min(width, height) / 2;
            int x = (width - size) / 2;
            int y = (height - size) / 2;
            g2d.fillRect(x, y, size, size);
        } else if (color.equals(Color.CYAN)) {
            // 绘制蓝色的圆形
            int diameter = Math.min(width, height) / 2;
            int x = (width - diameter) / 2;
            int y = (height - diameter) / 2;
            g2d.fillOval(x, y, diameter, diameter);
        } else if (color.equals(Color.RED)) {
            // 绘制红色的叉
            int size = Math.min(width, height) / 2;
            int x = (width - size) / 2;
            int y = (height - size) / 2;

            g2d.setStroke(new BasicStroke(3.0f));
            // 左上到右下的线
            g2d.drawLine(x, y, x + size, y + size);

            // 右上到左下的线
            g2d.drawLine(x + size, y, x, y + size);
        }
    }

}
