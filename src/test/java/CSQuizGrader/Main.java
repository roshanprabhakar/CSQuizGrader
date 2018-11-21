package CSQuizGrader;

public class Main {
    public static void main(String[] args) {
//        runCollectionsAnalysis();
        userInteractiveGradingSystem();
    }

    public static void userInteractiveGradingSystem() {
        try {
            UserInteractiveGrading userInteractiveGrading = new UserInteractiveGrading();
            userInteractiveGrading.printPartOfScreen(100,100,500,500);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void runCollectionsAnalysis() {
        try {
            Collections collections = new Collections();
            collections.analyzeCollections();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
