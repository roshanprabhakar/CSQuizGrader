package CSQuizGrader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Collections collections = new Collections();
            collections.analyzeCollections();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
