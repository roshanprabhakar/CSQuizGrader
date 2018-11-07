package CSQuizGrader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JavaFile jf = new JavaFile("src/TextSources/graderTrial.txt", "graderTrial.txt");

        ArrayList<String> correctedArguments = jf.fixClassSyntax();
//        System.out.println(jf.getErrorLog());
//        System.out.println(correctedArguments);
        jf.updateJavaFile(correctedArguments);

    }
}
