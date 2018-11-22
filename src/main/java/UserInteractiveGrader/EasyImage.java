package UserInteractiveGrader;

import javax.swing.*;
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
}
