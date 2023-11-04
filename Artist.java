import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

// I was going to call this class drawer or visualiser, but I decided to name it artist instead.
public class Artist {
    private ArrayList<SpiroVector> vectorList = new ArrayList<>();
    private double theta = 0;

    public void incrementTheta(){
        theta += 0.01;
    }

    public static void main(String[] args) {
        Artist artist = new Artist();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("!exit")) {
                    break;
                } else if (line.equals("!calculate")) {
                    while (true) {
                        double x = 0;
                        double y = 0;
                        for (SpiroVector vector : artist.vectorList) {
                            double[] posVector = vector.calculateVector(artist.theta);
                            x += posVector[0];
                            y += posVector[1];
                        }
                        System.out.print(x);
                        System.out.print(" ");
                        System.out.println(y);
                        artist.incrementTheta();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }


                    }
                }
                String[] stuff = line.split(" ");
                artist.vectorList.add(new SpiroVector(Double.parseDouble(stuff[0]), Double.parseDouble(stuff[1]), Double.parseDouble(stuff[2])));
            }
        }
    }


}
