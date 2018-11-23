package UserInteractiveGrader;

public class AnswerField {
    int[] start_coordinates;
    int[] final_coordinates;

    public AnswerField(int[] start_coordinates, int[] final_coordinates) {
        this.start_coordinates = start_coordinates;
        this.final_coordinates = final_coordinates;
    }

    public void setStartXAndY(int x, int y) {
        start_coordinates = new int[] {x, y};
    }

    public void setEndXAndY(int x, int y) {
        final_coordinates = new int[] {x, y};
    }
}
