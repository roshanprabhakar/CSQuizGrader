package CSQuizGrader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        JavaFile jf = new JavaFile("src/TextSources/HelloWorld.txt", "HelloWorld.txt");

//        ArrayList<String> correctedArguments = jf.fixClassSyntax();
//        jf.updateJavaFile(correctedArguments);

        //Need to fix error log
        //System.out.println(jf.getErrorLog());
        //System.out.println(correctedArguments);

        Compiler compiler = new Compiler("HelloWorld");
        compiler.compile();
    }
}
