import java.awt.Color;
import java.util.Scanner;

// I was going to call this class drawer or visualiser, but I decided to name it artist instead.
public class Artist {
    private SpiroVector vector;
    private double theta = 0;
    private Color colour;

    private double repeatUntil;

    public void incrementTheta(){
        theta += 0.02;
    }

    public double getTheta() {
        return theta;
    }

    public boolean initiateVectors() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("!exit")) {
                    return true;
                }
                String[] stuff = line.split(" ");
                try {
                    addVector(Integer.parseInt(stuff[0]), Integer.parseInt(stuff[1]), Integer.parseInt(stuff[2]));
                    this.colour = new Color(Integer.parseInt(stuff[3]),Integer.parseInt(stuff[4]),Integer.parseInt(stuff[5]));
                } catch (Exception e) {
                    System.out.println("Smh enter correct args.");
                    return initiateVectors();
                }
                break;
            }
        }
        return false;
    }

    public int calcGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return calcGCD(b, a % b);
        }
    }

    public double calcRepeatUntil(int a, int b) {
        if (b > a) {
            return  (double) a / calcGCD(b, a) * 2 * Math.PI;
        }
        return (double) b / calcGCD(a, b) * 2 * Math.PI;

        // https://en.wikipedia.org/wiki/Euclidean_algorithm
    }

    public double getRepeatUntil() {
        return repeatUntil;
    }

    public void addVector(int ro, int rt, int offset) {
         vector = new SpiroVector(ro, rt, offset);
         repeatUntil = calcRepeatUntil(ro, rt);
     }

    public double[] calculate() {
        incrementTheta();
        return vector.calculateVector(theta);
    }

    public Color getColour() {
        return colour;
    }
}
