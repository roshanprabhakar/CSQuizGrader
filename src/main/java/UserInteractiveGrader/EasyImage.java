package UserInteractiveGrader;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EasyImage {

    private static final String separator = File.separator;
    private JFrame frame;
    private JLabel label;
    private QGMouseListener mouseListener = new QGMouseListener();
    String path;


    public EasyImage(String name) {
        this.path = "src" + separator + "ScannedImageSources" + separator + name;
        this.frame = new JFrame();
        this.label = new JLabel();
        frame.addMouseListener(mouseListener);
    }

    public void display() {
        ImageIcon icon = new ImageIcon(path);
        label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void display(ImageIcon icon) {
        label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ImageIcon resize(int w, int h) {

        ImageIcon icon = new ImageIcon(path);

        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if (icon.getIconWidth() > w) {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if (nh > h) {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }

    public void drawRectangleAt(int startX, int startY, int endX, int endY) {
        JFrame rectangle = new JFrame();
        rectangle.setLocation(new Point(startX, startY));
        rectangle.setSize(endX-startX, endY-startY);
        rectangle.setUndecorated(true);
        rectangle.setVisible(true);
    }

    public boolean mouseIsClicked() {
        return mouseListener.isClicked;
    }

    public boolean mouseIsReleased() {
        return !mouseListener.isClicked;
    }
}
