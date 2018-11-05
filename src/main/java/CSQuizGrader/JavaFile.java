package CSQuizGrader;

import java.io.*;
import java.util.ArrayList;

public class JavaFile {
    public ArrayList<String> javaFile = new ArrayList<>();
    public ArrayList<String> errorLog = new ArrayList<>();

    public JavaFile(String filepath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filepath)));
            String st;
            while ((st = br.readLine()) != null) {
                javaFile.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateJavaFile() throws IOException {
        File updatedFile = new File("TextSources/temp.txt");
        updatedFile.createNewFile();
        FileWriter fileWriter = new FileWriter(updatedFile);
        ArrayList<String> fixedClassFile = this.fixClassSyntax();
        for (String line : fixedClassFile) {
            fileWriter.write(line);
        }
    }

    private ArrayList<String> fixClassSyntax() {
        ArrayList<String> fixedCode = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < javaFile.size(); i++) {
            int indexOfSpace = 0;
            for (int j = 0; j < javaFile.get(i).length(); j++) { //split each among the spaces
                if (javaFile.get(i).substring(j, j + 1).equals(" ")) {
                    words.add(javaFile.get(i).substring(indexOfSpace, j));
                    indexOfSpace = j + 1;
                }
            }
            if (words.get(0).equals("public") || words.get(0).equals("private") || words.get(0).equals("protected")) {
                if (!words.get(words.size() - 1).equals("{")) {
                    words.add("{");
                    errorLog.add("Missing Bracket");
                }
            } else if (words.get(words.size() - 1).charAt(words.get(words.size() - 1).length() - 1) != ';' && words.get(i) != "}") {
                words.add(";");
                errorLog.add("Missing semicolon");
            }
            fixedCode.add(concatenateList(words));
            words.clear();
        }
        return fixedCode;
    }

    private String concatenateList(ArrayList<String> list) {
        String output = "";
        for (String str : list) {
            output += str + " ";
        }
        return output;
    }
}
