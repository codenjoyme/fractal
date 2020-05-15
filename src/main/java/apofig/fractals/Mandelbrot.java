package apofig.fractals;

/**
 * User: oleksandr.baglai
 * Date: 1/21/13
 * Time: 4:00 AM
 */
public class Mandelbrot implements Fractal {

    private Position mandelbrot = new Position(-1.9, 0.5, -1.2, 1.2);

    @Override
    public Position getZoom() {
        return mandelbrot.zoom(40).move(-1.25, 2).zoom(5);
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
