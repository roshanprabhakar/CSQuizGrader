package CSQuizGrader;

import jdk.nashorn.internal.runtime.ECMAException;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class UserInteractiveGrading {

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz"; //to auto-generate file names
    private final String separator = File.separator;

    public void writeStudentAnswersForThisProblem(int topLeftX, int topLeftY, int width, int height, String pathToImage) throws AWTException { //x, y of bounds user selected

    }

    public void printPartOfScreen(int topLeftX, int topLeftY, int height, int width) {
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

    private String generateRandomName(int length) {
        String output = "";
        for (int i = 0; i < length; i++) {
            output += ALPHABET.substring((int) Math.random() * ALPHABET.length());
        }
        return output;
    }
}
