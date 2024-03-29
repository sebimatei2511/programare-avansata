import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    int canvasWidth = 700, canvasHeight = 700;
    int stoneSize = 30;
    List<Line> lineList = new ArrayList<>();

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

        int rows = (int) frame.getConfigPanel().spinner1.getValue() - 1;
        int cols = (int) frame.getConfigPanel().spinner2.getValue() - 1;
        int size = Math.min(getWidth() / cols, getHeight() / rows) - 10;

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);

        lineList.clear();

        int y = (getHeight() - (size * rows)) / 2;
        Graphics2D g2d = null;
        for (int horz = 0; horz < rows; horz++) {
            int x = (getWidth() - (size * cols)) / 2;
            for (int vert = 0; vert < cols; vert++) {
                g.setColor(Color.darkGray);
                g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(1));
                Line line1 = new Line(x, y, x, y + size);
                Line line2 = new Line(x, y, x + size, y);
                Line line3 = new Line(x, y + size, x + size, y + size);
                Line line4 = new Line(x + size, y, x + size, y + size);
                g2d.drawLine(x, y, x, y + size);
                g2d.drawLine(x, y, x + size, y);
                g2d.drawLine(x, y + size, x + size, y + size);
                g2d.drawLine(x + size, y, x + size, y + size);
                lineList.add(line1);
                lineList.add(line2);
                lineList.add(line3);
                lineList.add(line4);
                g2d.setStroke(new BasicStroke(1));
                g.setColor(Color.gray);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);

                x += size;
            }
            g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            y += size;
        }

        int x = (getWidth() - (size * cols)) / 2;
        for (int vert = 0; vert < cols + 1; vert++) {
            g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            x += size;
        }

        boldSticks(g2d);
    }

    private void init(){
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setBorder(BorderFactory.createEtchedBorder());
    }

    public void boldSticks(Graphics2D g2d){
        Collections.shuffle(lineList);
        int randomSticksLenght = (int) (Math.floor(
                Math.random()*(lineList.size()/2-lineList.size()/3+1)+
                        lineList.size()/3
        ));

        List<Line> randomSticks = lineList.subList(0,randomSticksLenght);
        for (Line line : randomSticks){
            g2d.setStroke(new BasicStroke(5));
            g2d.setColor(Color.black);
            int x1 = line.getX1();
            int y1 = line.getY1();
            int x2 = line.getX2();
            int y2 = line.getY2();
            g2d.drawLine(x1,y1,x2,y2);
        }
    }

    final void init(int rows, int cols) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawStone(e.getX(), e.getY());
                repaint();
            }
            //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }
    private void drawStone(int x, int y) {
//TODO
        offscreen.setColor(Color.red);
        offscreen.fillOval(x,y,stoneSize,stoneSize);
    }



    @Override
    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}
