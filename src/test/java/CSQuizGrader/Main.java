package CSQuizGrader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            JavaFile jf = new JavaFile("src/TextSources/SampleText1.txt");
            System.out.println(jf.javaFile);
            System.out.println(jf.fixClassSyntax());
            jf.updateJavaFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
