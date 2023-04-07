package apofig.fractals;

public class MandelbrotNew implements Fractal{


    @Override
    public Position getZoom() {
           return new Position(-2.5, 4, -1.8, 3);
    }

    @Override
    public int getFunction(double a, double b, int iterations) {
        double r = 0;
        double x = 0;
        double y = 0;
        int color = iterations;
        while (color > 0 && r < 4) {
            double x2 = x * x;
            double y2 = y * y;
            double xy = x * y;
            x = x2 - y2 + a;
            y = 2 * xy + b;
            r = x2 + y2;
            color--;
        }
        return color;
    }
}
