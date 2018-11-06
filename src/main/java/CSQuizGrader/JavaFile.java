package CSQuizGrader;

import java.io.*;
import java.util.ArrayList;

public class JavaFile {
    public ArrayList<String> javaFile = new ArrayList<>();
    private ArrayList<String> errorLog = new ArrayList<>();

    public JavaFile(String filepath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filepath)));
            String st;
            while ((st = br.readLine()) != null) {
                javaFile.add(st + " "); //to account for loss of info during the split by space
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
        File oldFile = new File("TextSources/SampleText1.txt");
        oldFile.delete();
    }

    public ArrayList<String> fixClassSyntax() {
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
            //words has the individual words from each line of code
            if (words.get(0).equals("public") || words.get(0).equals("private") || words.get(0).equals("protected")) {
                if (!words.get(words.size() - 1).equals("{")) {
                    words.add("{");
                    errorLog.add("missing open brace");
                }
            } else if (words.get(words.size() - 1).charAt(words.get(words.size() - 1).length() - 1) != ';') {
                words.add(";");
                errorLog.add("missing semicolon");
            }
            System.out.println(words);

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

    public ArrayList<String> getErrorLog() {
        return this.errorLog;
    }
}
