import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Draw extends JPanel {

    final Map map;
    int canvasWidth = 740;
    int canvasHeight = 480;
    BufferedImage bufferedImage; //offscreen image
    Graphics2D offscreen; // offscreen graphics

    List<Double> latitudes = new ArrayList<>();
    List<Double> longitudes = new ArrayList<>();

    private Image background;

    public Draw(Map map) {
        this.map = map;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        bufferedImage = new BufferedImage(
                canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = bufferedImage.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    private void lists() {
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select latitude, longitude from cities"
            );

            if (resultSet == null) {
                System.out.println("There is not city in the database!!!");
            }

            int count = 0;
            while (true) {
                assert resultSet != null;
                if (!resultSet.next()) break;
                double latitude1 = resultSet.getDouble(1);
                double longitude1 = resultSet.getDouble(2);
                latitudes.add(latitude1);
                longitudes.add(longitude1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(background, 0, 0, this);
        int index = 0;
        graphics.setColor(Color.BLACK);
        while (index < latitudes.size()) {
            graphics.drawOval((int) (180 + longitudes.get(index)) * 2,
                    (int) (90 - latitudes.get(index)) * 2,
                    10, 10);
            index ++;
        }
        repaint();
    }

    private void init() {
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setBorder(BorderFactory.createEtchedBorder());
        lists();
        try {
            background = ImageIO.read(new File("mercator.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
