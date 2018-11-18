package CSQuizGrader;

import java.io.*;
import java.util.ArrayList;

public class OCRstatsLib {

    File unFormattedOCRInput;
    String filePath;

    public OCRstatsLib(String filepath) {
        this.filePath = filepath;
        unFormattedOCRInput = new File(filepath);
    }

    public void writeFormatted(File outputFile) {
        try {
            String data = getUnformattedData();
            ArrayList<String> formattedCode = formattedCode(data);
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            for (String line : formattedCode) {
                bw.write(line);
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> formattedCode(String string) {
        ArrayList<String> lines = new ArrayList<>();
        String counter = "";
        int lastLineIndex = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) != ';' && string.charAt(i) != '{' && string.charAt(i) != '}') {
                counter += string.charAt(i);
            } else if (string.charAt(i) == '}' && string.charAt(i + 1) == ';') {
                counter += string.charAt(i);
                counter += string.charAt(i + 1);
                lines.add(counter + "\n");
                lastLineIndex = i + 2;
                i++;
                counter = "";
            } else if (!string.substring(lastLineIndex, lastLineIndex + 3).equals("for")) {
                counter += string.charAt(i);
                lines.add(counter + "\n");
                counter = "";
                lastLineIndex = i + 1;
            } else {
                counter += string.charAt(i);
            }
        }
        return lines;
    }

    private String getUnformattedData() {
        String output = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String str;
            while ((str = br.readLine()) != null) {
                output += str;
            }
        } catch (Exception e) {
            System.err.println("File not found... returning null");
        }
        return output;
    }
}
