package CSQuizGrader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Collections {

    private final String separator = File.separator;

    private File TextSources = new File("src" + separator + "TextSources");
    private ArrayList<File> TextFiles = new ArrayList<>();

    public Collections() {
        File[] temp = TextSources.listFiles();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].getAbsolutePath().substring(temp[i].getAbsolutePath().indexOf(".")).equals(".txt")) {
                TextFiles.add(temp[i]);
            }
        }
    }

    public void analyzeCollections() {
        String name;
        for (int i = 0; i < TextFiles.size(); i++) {
            name = TextFiles.get(i).getName();
            System.out.println();
            System.out.println("------- File " + (i + 1) + ": " + name + "-------");
            try {
                JavaFile jf = new JavaFile("src/TextSources/" + name.substring(0, name.indexOf(".")) + ".txt", name.substring(0, name.indexOf(".")) + ".txt");
                Compiler compiler = new Compiler(name.substring(0, name.indexOf(".")));

                System.out.println("Compile-time Errors: ");
                compiler.compile();

                jf.updateJavaFile(jf.fixClassSyntax());
                System.out.println("ERROR_LOG: ");
                System.out.println(jf.getERROR_LOG());

                System.out.println("Fixing errors if applicable ...");
                compiler.compile();

                System.out.println("Running synthetic JVM...");
                SyntheticJVM syntheticJVM = new SyntheticJVM(name.substring(0, name.indexOf(".")));
                syntheticJVM.run();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
