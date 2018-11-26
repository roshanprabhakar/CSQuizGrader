package UserInteractiveGrader;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class UserInteractiveGrading {

    private final String separator = File.separator;
    private String imagePath = "src" + separator + "ScannedImageSources" + separator;


    public void run() throws InterruptedException {

        HashMap<String, ArrayList<AnswerField>> answerFields = getAllAnswerFields();
        //HashMap mapping page name to list of answer fields on that page



        System.out.println(answerFields);
        for (String file : answerFields.keySet()) {
            for (AnswerField ans : answerFields.get(file)) {
                ans.print();
            }
        }


        System.exit(0);
    }

    private HashMap<String, ArrayList<AnswerField>> getAllAnswerFields() throws InterruptedException {

        HashMap<String, ArrayList<AnswerField>> answers = new HashMap<>();
        File[] blankTest = new File(imagePath + "AllPagesOfBlankTest" + separator).listFiles();

        for (File page : blankTest) {

            answers.put(page.getName(), new ArrayList<>());

            EasyImage pageInTemplate = new EasyImage("AllPagesOfBlankTest" + separator + page.getName()); //when displayed, whole thing should fit in
            pageInTemplate.display(pageInTemplate.resize(1000, 1000)); //readable on dimensions of a 13-inch macbook pro in pixels

            int numOfAnswerFields = Integer.parseInt(JOptionPane.showInputDialog("How many answer fields on this page?"));

            for (int i = 0; i < numOfAnswerFields; i++) {
                answers.get(page.getName()).add(recordAnswerField(page.getName(), pageInTemplate));
            }
        }

        Thread.sleep(1000);

        return answers;
    }

    private AnswerField recordAnswerField(String page, EasyImage pageInTemplate) {

        //code to record one answer sheet in file page
        //assuming all answerFields will be of same size and dimensions
        AnswerField ans = new AnswerField(new int[2], new int[2], page);

        //makes sure mouse is clicked
        while (!pageInTemplate.mouseIsClicked()) {
            System.out.print(' ');
            continue;
        }
        System.out.println();

        ans.setStartXAndY(getLocationOfMouse()[0], getLocationOfMouse()[1]); //records first click

        //allows time for the user to drag the mouse
        while (!pageInTemplate.mouseIsReleased()) {
            System.out.print(' ');
            continue;
        }
        System.out.println();

        ans.setEndXAndY(getLocationOfMouse()[0], getLocationOfMouse()[1]); //records second click

        pageInTemplate.drawRectangleAt(ans.start_coordinates[0], ans.start_coordinates[1], ans.end_coordinates[0], ans.end_coordinates[1]);

        return ans;
    }

    private int[] getLocationOfMouse() {
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        return new int[]{mouseX, mouseY};
    }

    private int getMouseX() {
        return MouseInfo.getPointerInfo().getLocation().x;
    }

    private int getMouseY() {
        return MouseInfo.getPointerInfo().getLocation().y;
    }
}
