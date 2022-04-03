import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    int canvasWidth = 700, canvasHeight = 700;
 //...
    BufferedImage image; //the offscreen image
    Graphics2D offscreen; //the offscreen graphics
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(
                canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    public void paint(Graphics g) {
        int rows = (int) frame.getConfigPanel().spinner1.getValue();
        int cols = (int) frame.getConfigPanel().spinner2.getValue();
        int size = Math.min(getWidth()/cols, getHeight()/rows) - 10;

        int y = (getHeight() - (size * rows)) / 2;
        for (int horz = 0; horz < rows; horz++) {
            int x = (getWidth() - (size * cols)) / 2;
            for (int vert = 0; vert < cols; vert++) {
                g.drawRect(x, y, size, size);
                x += size;
            }
            y += size;
        }
    }

    private void init(){
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}
