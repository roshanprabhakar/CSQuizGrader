package UserInteractiveGrader;

import java.io.File;
import java.util.Arrays;

public class AnswerField {
    int[] start_coordinates;
    int[] end_coordinates;
    File identity;

    public AnswerField(int[] start_coordinates, int[] final_coordinates, File identity) {
        this.start_coordinates = start_coordinates;
        this.end_coordinates = final_coordinates;
        this.identity = identity;
    }

    public void print() {
        System.out.println("--- this answer field ---");
        System.out.println("This for file " + identity.getName());
        System.out.println("start coordinates: " + Arrays.toString(start_coordinates));
        System.out.println("end coordinates: " + Arrays.toString(end_coordinates));
    }

    public boolean checkIdentityWith(File file) {
        if (this.identity == file) return true;
        return false;
    }

    public void setStartXAndY(int x, int y) {
        start_coordinates = new int[]{x, y};
    }

    public void setEndXAndY(int x, int y) {
        end_coordinates = new int[]{x, y};
    }
}
