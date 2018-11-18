package CSQuizGrader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            JavaFile jf = new JavaFile("src/TextSources/HelloWorld.txt", "HelloWorld.txt");
            Compiler compiler = new Compiler("HelloWorld");

            System.out.println("Compile-time Errors: ");
            compiler.compile();

            jf.updateJavaFile(jf.fixClassSyntax());
            System.out.println("ERROR_LOG: ");
            System.out.println(jf.getERROR_LOG());

            System.out.println("Fixing errors...");
            compiler.compile();

            System.out.println("Running synthetic JVM...");
            SyntheticJVM syntheticJVM = new SyntheticJVM("HelloWorld");
            syntheticJVM.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
