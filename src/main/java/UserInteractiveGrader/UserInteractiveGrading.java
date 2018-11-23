package UserInteractiveGrader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import CSQuizGrader.*;

public class UserInteractiveGrading {

    private final String separator = File.separator;
    private String imagePath = "src" + separator + "ScannedImageSources" + separator;

    public void run() {

        ArrayList<Integer> startXForALlAnswers = new ArrayList<>();
        ArrayList<Integer> finalXForALlAnswers = new ArrayList<>();
        ArrayList<Integer> startYForALlAnswers = new ArrayList<>();
        ArrayList<Integer> finalYForALlAnswers = new ArrayList<>();

        File[] blanckTest = new File(imagePath + "AllPagesOfBlankTest" + separator).listFiles();
        for (File page : blanckTest) {
            EasyImage pageInTemplate = new EasyImage("AllPagesOfBlankTest" + separator + page.getName()); //when displayed, whole thing should fit in
            pageInTemplate.display(pageInTemplate.resize(1280, 800)); //readable on dimensions of a 13-inch macbook pro
            //add the bounds depicted by mouse
        }
    }

    //may not be needed
    private void printLocalizedPartOfScreen(int topLeftX, int topLeftY, int height, int width) {
        try {
            //define image from screen
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            Robot robot = new Robot();
            BufferedImage img = robot.createScreenCapture(new Rectangle(topLeftX, topLeftY, width, height));

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

    private int getMouseX() {
        return MouseInfo.getPointerInfo().getLocation().x;
    }

    private int getMouseY() {
        return MouseInfo.getPointerInfo().getLocation().y;
    }
}
