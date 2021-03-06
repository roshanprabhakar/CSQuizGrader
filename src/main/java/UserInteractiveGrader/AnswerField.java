package UserInteractiveGrader;

import java.util.Arrays;

public class AnswerField {
    int[] start_coordinates;
    int[] end_coordinates;
    private int identity; //number of the problem

    public AnswerField(int[] start_coordinates, int[] final_coordinates, int identity) {
        this.start_coordinates = start_coordinates;
        this.end_coordinates = final_coordinates;
        this.identity = identity;
    }

    public int getIdentity() {
        return identity;
    }

    public void print() {
        System.out.println("--- this answer field ---");
        System.out.println("This for answer field " + identity);
        System.out.println("start coordinates: " + Arrays.toString(start_coordinates));
        System.out.println("end coordinates: " + Arrays.toString(end_coordinates));
    }

    public void setStartXAndY(int x, int y) {
        start_coordinates = new int[]{x, y};
    }

    public void setEndXAndY(int x, int y) {
        end_coordinates = new int[]{x, y};
    }
}
