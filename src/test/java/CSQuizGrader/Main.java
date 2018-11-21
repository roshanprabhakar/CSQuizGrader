package CSQuizGrader;

import UserInteractiveGrader.UserInteractiveGrading;

public class Main {
    public static void main(String[] args) {
//        runCollectionsAnalysis();
        userInteractiveGradingSystem();
    }

    public static void userInteractiveGradingSystem() {

        UserInteractiveGrading userInteractiveGrading = new UserInteractiveGrading();
        userInteractiveGrading.displayImageFromFile("testingImg1.jpg");


    //        try {
    //            UserInteractiveGrading userInteractiveGrading = new UserInteractiveGrading();
    //            userInteractiveGrading.printLocalizedPartOfScreen(100,100,500,500);
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }

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
