public class SpiroVector {
    private double ro;
    private double rt;
    private double offset;

    public SpiroVector(double ro , double rt, double offset) {
        this.ro = ro;
        this.rt = rt;
        this.offset = offset;
    }

    public double[] calculateVector(double theta) {
        double x = (ro-rt)*Math.cos(theta) + offset * Math.cos(((ro-rt)/rt)*theta);
        double y = (ro-rt)*Math.sin(theta) - offset * Math.sin(((ro-rt)/rt)*theta);
        return new double[]{x, y};
    }
}
