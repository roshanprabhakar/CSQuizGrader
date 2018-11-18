package CSQuizGrader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            JavaFile jf = new JavaFile("src/TextSources/HelloWorld.txt", "HelloWorld.txt");
            //      ArrayList<String> correctedArguments = jf.fixClassSyntax();
            //      jf.updateJavaFile(correctedArguments);

            Compiler compiler = new Compiler("HelloWorld");
            compiler.compile();

            jf.updateJavaFile(jf.fixClassSyntax());
            System.out.println();
            System.out.println(jf.getERROR_LOG());
            compiler.compile();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
