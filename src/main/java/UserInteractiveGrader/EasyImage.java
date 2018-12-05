package UserInteractiveGrader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.File;

public class EasyImage implements MouseListener {

    private static final String separator = File.separator;
    String path;
    private JFrame frame;
    public boolean isPressed;
    private JLabel label;


    public EasyImage(String name) {
        this.path = "src" + separator + "ScannedImageSources" + separator + name;
        this.frame = new JFrame();
        this.label = new JLabel();
        frame.addMouseListener(this);
    }

    public void display(ImageIcon icon) {
        label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void displayFromXandY(int x, int y) {
        frame.setLocation(new Point(x, y));
    }

    public void close() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    public int getWidth() {
        return new ImageIcon(path).getIconWidth();
    }

    public int getHeight() {
        return new ImageIcon(path).getIconHeight();
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
        rectangle.setSize(endX - startX, endY - startY);
        rectangle.getContentPane().setBackground(Color.GRAY);
        rectangle.getRootPane().putClientProperty("Window.alpha", new Float(0.3f));
        rectangle.setUndecorated(true);
        rectangle.setVisible(true);
    }

    // --- Mouse Listener Interface Methods ---
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        isPressed = true;
    }

    public void mouseReleased(MouseEvent e) {
        isPressed = false;
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}


