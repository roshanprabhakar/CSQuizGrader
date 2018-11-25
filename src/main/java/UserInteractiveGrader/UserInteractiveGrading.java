package UserInteractiveGrader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class UserInteractiveGrading {

    private final String separator = File.separator;
    private String imagePath = "src" + separator + "ScannedImageSources" + separator;


    public void run() {

        ArrayList<AnswerField> answers = new ArrayList<>();
        File[] blankTest = new File(imagePath + "AllPagesOfBlankTest" + separator).listFiles();

        for (File page : blankTest) {

            EasyImage pageInTemplate = new EasyImage("AllPagesOfBlankTest" + separator + page.getName()); //when displayed, whole thing should fit in
            pageInTemplate.display(pageInTemplate.resize(1280, 800)); //readable on dimensions of a 13-inch macbook pro in pixels

            //assuming all answerFields will be of same size and dimensions
            AnswerField ans = new AnswerField(new int[2], new int[2]);

            while (!pageInTemplate.mouseIsClicked()) {
                continue;
            }

            ans.setStartXAndY(getLocationOfMouse()[0], getLocationOfMouse()[1]); //records first click
            System.out.println(Arrays.toString(ans.start_coordinates));

            while (!pageInTemplate.mouseIsClicked()) {
                continue;
            }

            ans.setEndXAndY(getLocationOfMouse()[0], getLocationOfMouse()[1]); //records second click
            System.out.println(Arrays.toString(ans.final_coordinates));

            answers.add(ans);
        }
    }

    private int[] getLocationOfMouse() {
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        return new int[]{mouseX, mouseY};
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
