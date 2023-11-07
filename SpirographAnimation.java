import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class SpirographAnimation extends JPanel implements ActionListener {
    private Timer timer;
    private HashMap<Artist, List<Point>> spiroToTrailMap = new HashMap<>();

    public SpirographAnimation() {
        setSpiro();
        timer = new Timer(0, this); // 1ms delay for animation
        timer.start();
    }

    public void setSpiro() {
        while (true) {
            Artist artist = new Artist();
            if (artist.initiateVectors()) {
                return;
            }
            List<Point> trail = new ArrayList<>();
            spiroToTrailMap.put(artist, trail);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        for (Artist artist : spiroToTrailMap.keySet()) {
            double[] xyCord = artist.calculate();
            int x = (int) (centerX + xyCord[0]);
            int y = (int) (centerY + xyCord[1]);

            // Get the trail for the current artist
            List<Point> trail = spiroToTrailMap.get(artist);

            // Add the current position to the trail
            if (artist.getRepeatUntil() > artist.getTheta()) { // optimisation my beloved
                trail.add(new Point(x, y));
            }

            // Draw the trail and the circle
            g.setColor(artist.getColour());
            for (Point point : trail) {
                g.fillOval(point.x - 2, point.y - 2, 4, 4);
            }
            g.fillOval(x - 5, y - 5, 10, 10);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Spirographs my beloved");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpirographAnimation animation = new SpirographAnimation();
        frame.add(animation);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
