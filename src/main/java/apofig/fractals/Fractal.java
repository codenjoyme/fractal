package apofig.fractals;

/**
 * User: oleksandr.baglai
 * Date: 1/21/13
 * Time: 3:57 AM
 */
public interface Fractal {

    Position getZoom();

    int getFunction(double x, double y, int iterations);
}
