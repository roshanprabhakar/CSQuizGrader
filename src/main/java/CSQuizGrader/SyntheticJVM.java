package CSQuizGrader;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SyntheticJVM {

    private final String separator = File.separator;
    private final String FILE_NAME;

    public SyntheticJVM(String fileName) {this.FILE_NAME = fileName;}

    public void run() {
        try {
            runProcess(("javac -cp src src" + separator + "TextSources" + separator + FILE_NAME + ".java"));
            runProcess(("java -cp src" + separator + "TextSources" + separator + " " + FILE_NAME));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printLines(InputStream ins) throws Exception {
        String line;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println("***** File output Line *****\n" + line);
        }
    }

    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(pro.getInputStream());
        printLines(pro.getErrorStream());
        pro.waitFor();
    }

}