package UserInteractiveGrader;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EasyImage {

    private static final String separator = File.separator;
    String path;

    public EasyImage(String name) {
        this.path = "src" + separator + "ScannedImageSources" + separator + name;
    }

    public void display() {
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon(path);
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void display(ImageIcon icon) {
        JFrame frame = new JFrame();
        ImageIcon imageIcon = resize();
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ImageIcon resize() {
        ImageIcon imageIcon = new ImageIcon("./img/imageName.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}
