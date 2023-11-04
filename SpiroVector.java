public class SpiroVector {
    private double r;
    private double thetaCoefficient;
    private double startPos;

    public SpiroVector(double r, double thetaCoefficient, double startPos) {
        this.r = r;
        this.thetaCoefficient = thetaCoefficient;
        this.startPos = startPos;
    }

    public double[] calculateVector(double theta) {
        double x = r * Math.cos(startPos * Math.PI + thetaCoefficient * theta);
        double y = r * Math.sin(startPos * Math.PI + thetaCoefficient * theta);
        return new double[]{x, y};
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setThetaCoefficient(double thetaCoefficient) {
        this.thetaCoefficient = thetaCoefficient;
    }

    public void setStartPos(double startPos) {
        this.startPos = startPos;
    }
}
