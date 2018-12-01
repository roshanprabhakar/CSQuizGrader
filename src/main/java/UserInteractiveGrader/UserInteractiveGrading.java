package UserInteractiveGrader;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class UserInteractiveGrading {

    private final String separator = File.separator;
    private String imagePath = "src" + separator + "ScannedImageSources" + separator;
    HashMap<String, ArrayList<AnswerField>> ANSWER_FIELDS;
    int numOfAnswers;


    public void run() throws InterruptedException {

        ANSWER_FIELDS = getAllAnswerFields(); //HashMap mapping page name to list of answer fields on that page

        File studentResponses = new File(imagePath + "StudentResponses");
        for (int answer = 0; answer < numOfAnswers; answer++) {
            String page = getPageNameForProblem(answer + 1);
            System.out.println(page);
        }

        /**
         * Loop through each page of test blueprint
         * display everyone's AnswerField for AnswerField ans in blueprint
         * diplay appropriate JOptionPanes
         *     - scoring (x/y)
         *     - comments
         */

        System.out.println(ANSWER_FIELDS);
        for (String file : ANSWER_FIELDS.keySet()) {
            for (AnswerField ans : ANSWER_FIELDS.get(file)) {
                ans.print();
            }
        }


        System.exit(0);
    }

    private HashMap<String, ArrayList<AnswerField>> getAllAnswerFields() throws InterruptedException {

        HashMap<String, ArrayList<AnswerField>> answers = new HashMap<>();
        File[] blankTest = new File(imagePath + "AllPagesOfBlankTest" + separator).listFiles();

        int num = 0;
        for (File page : reverse(blankTest)) {

            answers.put(page.getName(), new ArrayList<>());

            EasyImage pageInTemplate = new EasyImage("AllPagesOfBlankTest" + separator + page.getName()); //when displayed, whole thing should fit in
            pageInTemplate.display(pageInTemplate.resize(1000, 1000)); //readable on dimensions of a 13-inch macbook pro in pixels

            int numOfAnswerFields = Integer.parseInt(JOptionPane.showInputDialog("How many answer fields on this page?"));

            for (int i = 0; i < numOfAnswerFields; i++) {
                num++;
                answers.get(page.getName()).add(recordAnswerField(page.getName(), pageInTemplate, num));
            }
        }

        numOfAnswers = num;
        Thread.sleep(1000);

        return answers;
    }

    private File[] reverse(File[] list) {
        File[] output = new File[list.length];
        for (int i = 0; i < list.length; i++) {
            output[i] = list[list.length - (i + 1)];
        }
        return output;
    }

    private String getPageNameForProblem(int problemNum) {
        for (String page : ANSWER_FIELDS.keySet()) {
            for (AnswerField ans : ANSWER_FIELDS.get(page)) {
                if (ans.identity == problemNum) return page;
            }
        }
        return "no page found";
    }

    private AnswerField recordAnswerField(String page, EasyImage pageInTemplate, int num) throws InterruptedException {

        //code to record one answer sheet in file page
        //assuming all ANSWER_FIELDS will be of same size and dimensions
        AnswerField ans = new AnswerField(new int[2], new int[2], num);

        //makes sure mouse is clicked
        while (!pageInTemplate.isPressed) {
            Thread.sleep(10);
            continue;
        }

        ans.setStartXAndY(getLocationOfMouse()[0], getLocationOfMouse()[1]); //records first click

        //allows time for the user to drag the mouse
        while (pageInTemplate.isPressed) {
            Thread.sleep(10);
            continue;
        }

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
