package UserInteractiveGrader;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class QGMouseListener implements MouseListener {

    public boolean isClicked;

    public void mouseClicked(MouseEvent arg0) {
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void mousePressed(MouseEvent arg0) {
        isClicked = true;
        System.out.println("pressed");
    }

    public void mouseReleased(MouseEvent arg0) {
        isClicked = false;
        System.out.println("released");
    }
}
