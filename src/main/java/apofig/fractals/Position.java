package apofig.fractals;

/**
 * User: oleksandr.baglai
 * Date: 1/21/13
 * Time: 3:21 AM
 */
public class Position {
    private double bxMin;
    private double bxMax;
    private double byMin;
    private double byMax;

    Position(double bxMin, double bxMax, double byMin, double byMax) {
        this.bxMin = bxMin;
        this.bxMax = bxMax;
        this.byMin = byMin;
        this.byMax = byMax;
    }

    public Position zoom(double zoom) {
        double lx = (bxMax - bxMin)*(zoom-1)/(2*zoom);
        double ly = (byMax - byMin)*(zoom-1)/(2*zoom);
        double xMin = bxMin + lx;
        double xMax = bxMax - lx;
        double yMin = byMin + ly;
        double yMax = byMax - ly;

        return new Position(xMin, xMax, yMin, yMax);
    }

    public Position move(double dx, double dy) {
        double xMin = bxMin + (bxMax - bxMin)*dx;
        double xMax = bxMax + (bxMax - bxMin)*dx;
        double yMin = byMin + (byMax - byMin)*dy;
        double yMax = byMax + (byMax - byMin)*dy;

        return new Position(xMin, xMax, yMin, yMax);
    }

    public Position resize(double width, double height) {
        if (width/height > 1) {
            double dx = (bxMax - bxMin)*(width/height - 1)/2;
            double xMin = bxMin - dx;
            double xMax = bxMax + dx;
            double yMin = byMin;
            double yMax = byMax;
            return new Position(xMin, xMax, yMin, yMax);
        } if (width/height < 1) {
            double dy = (byMax - byMin)*(height/width - 1)/2;
            double xMin = bxMin;
            double xMax = bxMax;
            double yMin = byMin - dy;
            double yMax = byMax + dy;
            return new Position(xMin, xMax, yMin, yMax);
        } else {
            return this;
        }
    }

    public double getXMin() {
        return bxMin;
    }

    public double getXMax() {
        return bxMax;
    }

    public double getYMin() {
        return byMin;
    }

    public double getYMax() {
        return byMax;
    }

    public String toString() {
        return String.format("x=[%s...%s]\ny=[%s...%s]",
                bxMin, bxMax, byMin, byMax);
    }
}