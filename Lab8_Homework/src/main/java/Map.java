import javax.swing.*;
import java.awt.*;

public class Map extends JFrame {
    Draw canvas;

    public Map() {
        super("Map");
        setSize(740,480);
        init();
    }

    private void init() {
        canvas = new Draw(this);
        add(canvas, BorderLayout.CENTER);
        add(canvas, BorderLayout.CENTER);

        pack();
    }
}
