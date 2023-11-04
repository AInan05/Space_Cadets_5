import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

// I was going to call this class drawer or visualiser, but I decided to name it artist instead.
public class Artist {
    private SpiroVector vector;
    private double theta = 0;

    public void incrementTheta(){
        theta += 0.02;
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
                addVector(Double.parseDouble(stuff[0]), Double.parseDouble(stuff[1]), Double.parseDouble(stuff[2]));
                break;
            }
        }
        return false;
    }

     public void addVector(double ro, double rt, double offset) {
         vector = new SpiroVector(ro, rt, offset);
     }

    public double[] calculate() {
        incrementTheta();
        return vector.calculateVector(theta);
    }
}
