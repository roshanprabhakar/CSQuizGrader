package UserInteractiveGrader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import CSQuizGrader.*;

public class UserInteractiveGrading {

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz"; //to auto-generate file names
    private final String separator = File.separator;

    public void displayImageFromFile(String filename, String title) {
        String path = "src" + separator + "ScannedImageSources" + separator + filename;

        JFrame jFrame = new JFrame(path);


    }


    public void printLocalizedPartOfScreen(int topLeftX, int topLeftY, int height, int width) {
        try {
            //define image from screen
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            Robot robot = new Robot();
            BufferedImage img = robot.createScreenCapture( new Rectangle(topLeftX, topLeftY, width, height) );

            //print it out
            JFrame frame = new JFrame();
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(new JLabel(new ImageIcon(img)));
            frame.pack();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Random generate name for file
    private String generateRandomName(int length) {
        String output = "";
        for (int i = 0; i < length; i++) {
            output += ALPHABET.substring((int) Math.random() * ALPHABET.length());
        }
        return output;
    }
}
